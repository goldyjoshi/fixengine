package com.strathclyde.fixengine.fixengine.utility;

import com.strathclyde.fixengine.fixengine.model.SingleOrderRequest;
import com.strathclyde.fixengine.fixengine.model.TraderDetails;
import quickfix.Message;
import quickfix.field.*;
import quickfix.fix42.NewOrderSingle;
import java.util.UUID;

public class TestUtility {

    public static SingleOrderRequest createSingleOrderRequest() {
        String orderId = UUID.randomUUID().toString();
        SingleOrderRequest singleOrderRequest = new SingleOrderRequest();
        singleOrderRequest.setOrderId(orderId);
        singleOrderRequest.setAccountId("TestAccount");
        singleOrderRequest.setExecutedQuantity(0.0);
        singleOrderRequest.setStatus("test");
        singleOrderRequest.setSide("Buy");
        singleOrderRequest.setSymbol("test");
        singleOrderRequest.setQuantity(0.0);
        return singleOrderRequest;
    }

    public static TraderDetails employeeDetails() {
       TraderDetails traderDetails = new TraderDetails("235", "vijayshree@hotmail.com", "vj2985@",
               "Trader");
       return traderDetails;
    }

    public static NewOrderSingle createNewOrderSingle(String orderId) {
        NewOrderSingle newOrderSingle = new NewOrderSingle(
                new ClOrdID(orderId),
                new HandlInst(HandlInst.AUTOMATED_EXECUTION_ORDER_PUBLIC_BROKER_INTERVENTION_OK),
                new Symbol("apple"),
                new Side(Side.BUY),
                new TransactTime(),
                new OrdType(OrdType.MARKET));
        Message.Header header = newOrderSingle.getHeader();
        header.setField(new BeginString("FIX.4.2"));
        header.setField(new SenderCompID("STRATHCLYDE_FIXENGINE"));
        header.setField(new TargetCompID("INVESTMENT_BANK"));
        newOrderSingle.setString(1, "123456");
        newOrderSingle.setString(38, "2.5");
        newOrderSingle.setString(35, "D");

        return newOrderSingle;
    }

    public static Message createFixMessage(final String orderId, final String msgType) {
        Message message = new Message();
        Message.Header header = message.getHeader();
        header.setField(new BeginString("FIX.4.2"));
        header.setField(new SenderCompID("STRATHCLYDE_FIXENGINE"));
        header.setField(new TargetCompID("INVESTMENT_BANK"));
        header.setField(new MsgType(msgType));
        message.setString(37, orderId);
        message.setString(39, "2");
        message.setString(1, "123456");
        message.setString(38, "2.5");
        message.setString(151, "0.0");
        message.setString(14, "10.0");
        return message;
    }

}
