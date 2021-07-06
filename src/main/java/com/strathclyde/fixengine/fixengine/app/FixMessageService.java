package com.strathclyde.fixengine.fixengine.app;

import com.strathclyde.fixengine.fixengine.model.ExecutionRequest;
import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import org.springframework.stereotype.Service;
import quickfix.Message;
import quickfix.Session;
import quickfix.SessionNotFound;
import quickfix.field.*;
import quickfix.fix42.ExecutionReport;
import quickfix.fix42.NewOrderSingle;

import java.util.UUID;

@Service
public class FixMessageService {

    public void createAndSendExecutionReport(final ExecutionRequest executionRequest) {
        String incomingExecType = executionRequest.getExecType();
        char side = "BUY".equalsIgnoreCase(executionRequest.getSide()) ? Side.BUY : Side.SELL;
        char execType = ExecType.NEW;
        char orderStatus = OrdStatus.NEW;
        switch (incomingExecType) {
            case "Partial":
                execType = ExecType.PARTIAL_FILL;
                orderStatus = OrdStatus.PARTIALLY_FILLED;
                break;
            case "Full":
                execType = ExecType.FILL;
                orderStatus = OrdStatus.FILLED;
                break;
            default:
                System.out.println(incomingExecType +" Execution type is not supported.");
        }
        String execId = UUID.randomUUID().toString();
        double cumulativeQuantity = executionRequest.getPreviousExecQuantity() +
                executionRequest.getQuantityRequestedForExec();
        double leaveQuantity = executionRequest.getTotalQuantity() - cumulativeQuantity;
        ExecutionReport executionReport = new ExecutionReport(
            new OrderID(executionRequest.getOrderId()),
                new ExecID(execId),
                new ExecTransType(ExecTransType.NEW),
                new ExecType(execType),
                new OrdStatus(orderStatus),
                new Symbol(executionRequest.getSymbol()),
                new Side(side),
                new LeavesQty(leaveQuantity),
                new CumQty(cumulativeQuantity),
                new AvgPx(executionRequest.getExecutionPrice())
        );
        executionReport.setString(1, executionRequest.getAccountId());
        executionReport.setString(38, String.valueOf(executionRequest.getTotalQuantity()));
        Message.Header header = executionReport.getHeader();
        header.setField(new BeginString("FIX.4.2"));
        header.setField(new SenderCompID("INVESTMENT_BANK"));
        header.setField(new TargetCompID("STRATHCLYDE_FIXENGINE"));
        try {
            Session.sendToTarget(executionReport);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }

    }

    public void createAndSendSingleOrderMessage(final SingleOrderRequest singleOrderRequest) {
        char side = "BUY".equalsIgnoreCase(singleOrderRequest.getSide()) ? Side.BUY : Side.SELL;
        NewOrderSingle newOrderSingle = new NewOrderSingle(
                new ClOrdID(singleOrderRequest.getOrderId()),
                new HandlInst(HandlInst.AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK),
                new Symbol(singleOrderRequest.getSymbol()),
                new Side(side),
                new TransactTime(),
                new OrdType(OrdType.MARKET));
        Message.Header header = newOrderSingle.getHeader();
        header.setField(new BeginString("FIX.4.2"));
        header.setField(new SenderCompID("STRATHCLYDE_FIXENGINE"));
        header.setField(new TargetCompID("INVESTMENT_BANK"));
        newOrderSingle.setString(1, singleOrderRequest.getAccountId());
        newOrderSingle.setString(38, String.valueOf(singleOrderRequest.getQuantity()));

        try {
            Session.sendToTarget(newOrderSingle);
        } catch (SessionNotFound sessionNotFound) {
            sessionNotFound.printStackTrace();
        }
    }
}
