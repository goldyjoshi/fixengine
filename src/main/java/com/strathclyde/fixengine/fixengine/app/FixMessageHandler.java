package com.strathclyde.fixengine.fixengine.app;

import com.strathclyde.fixengine.fixengine.database.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import quickfix.FieldNotFound;
import quickfix.Message;

@Service
public class FixMessageHandler implements IFixMessageHandler {

    @Value("${app.fix.type}")
    private String fixType;

    @Autowired
    private OrderService orderService;


    @Override
    public void handleIncomingMessage(Message incomingMessage) {

    }

    @Override
    public void handleOutgoingMessage(Message outgoingMessage) {
        if (fixType.equalsIgnoreCase("initiator")) {
            try {
                String messageType = outgoingMessage.getHeader().getString(35);
                switch (messageType) {
                    case "D" :
                        String orderId = outgoingMessage.getString(11);
                        orderService.updateOrderStatus(orderId, "Sent for Execution");
                        break;
                    default:
                        System.out.println(" Message Type Not supported.");

                }
            } catch (FieldNotFound fieldNotFound) {
                fieldNotFound.printStackTrace();
            }

        }

    }
}
