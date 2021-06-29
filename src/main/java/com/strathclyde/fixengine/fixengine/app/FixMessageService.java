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
        char side = "BUY".equalsIgnoreCase(executionRequest.getSide()) ? Side.BUY : Side.SELL;
        char execTransType;
        char execType;
        char orderStatus;
        if ("new".equalsIgnoreCase(executionRequest.getExecType())) {
            execTransType = ExecTransType.NEW;
            execType = ExecType.NEW;
            orderStatus = OrdStatus.NEW;
        } else {
            System.out.println(executionRequest.getExecType() +" Execution type is not supported.");
            return;
        }

        String execId = UUID.randomUUID().toString();
        ExecutionReport executionReport = new ExecutionReport(
            new OrderID(executionRequest.getOrderId()),
                new ExecID(execId),
                new ExecTransType(execTransType),
                new ExecType(execType),
                new OrdStatus(orderStatus),
                new Symbol(executionRequest.getSymbol()),
                new Side(side),
                new LeavesQty(executionRequest.getTotalQuantity()),
                new CumQty(0.0),
                new AvgPx(executionRequest.getExecutionPrice())
        );
        executionReport.setString(1, executionRequest.getAccountId());
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

    public void createAndSendSingleOrderMessage(final SingleOrderRequest singleOrderRequest,
                                                final String currentTime) {
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
