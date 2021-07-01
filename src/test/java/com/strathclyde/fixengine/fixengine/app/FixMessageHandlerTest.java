package com.strathclyde.fixengine.fixengine.app;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import quickfix.Message;
import quickfix.field.*;
import quickfix.fix42.NewOrderSingle;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FixMessageHandlerTest {

    @Autowired
    private FixMessageHandler fixMessageHandler;



    @Test
    public void handleOutgoingMessageTest() {
        // given
        NewOrderSingle newOrderSingle = new NewOrderSingle(
                new ClOrdID("1234"),
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


        fixMessageHandler.handleOutgoingMessage(newOrderSingle);


    }

}