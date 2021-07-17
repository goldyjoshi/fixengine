package com.strathclyde.fixengine.fixengine.app;

import com.strathclyde.fixengine.fixengine.database.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import quickfix.FieldNotFound;
import quickfix.Message;
import quickfix.field.MsgType;
import quickfix.field.OrdStatus;


@Service
public class FixMessageHandler implements IFixMessageHandler {

    @Value("${app.fix.type}")
    private String fixType;

    /***
     * create an object of class OrderService.
     */
    @Autowired
    private OrderService orderService;


    @Override
    public void handleIncomingMessage(Message incomingMessage) {
        if (fixType.equalsIgnoreCase("initiator")) {
            try {
                String messageType = incomingMessage.getHeader().getString(35);
                char ordStatus = incomingMessage.getChar(39);
                String orderStatus = null;
                double cumulativeQuantity = 0.0;
                double leaveQuantity = incomingMessage.getDouble(151);
                if (MsgType.EXECUTION_REPORT.equalsIgnoreCase(messageType)) {
                    String orderId = incomingMessage.getString(37);
                    switch (ordStatus) {
                        case OrdStatus.PENDING_NEW:
                            orderStatus = "Order Pending for Execution";
                            break;
                        case OrdStatus.NEW:
                            orderStatus = "Order Accepted";
                            break;
                        case OrdStatus.PARTIALLY_FILLED:
                            orderStatus = "Order Partially Executed";
                            cumulativeQuantity = incomingMessage.getDouble(14);
                            if (leaveQuantity == 0.0) {
                                orderStatus = "Order Completed";
                            }
                            break;
                        case OrdStatus.FILLED:
                            orderStatus = "Order Completed";
                            cumulativeQuantity = incomingMessage.getDouble(14);
                            break;
                        default:
                            System.out.println(" Currently Execution Type " + ordStatus + "not supported.");
                    }
                    if (orderStatus != null) {
                        orderService.updateOrderStatus(orderId, orderStatus, cumulativeQuantity);
                    }
                } else {
                    System.out.println("Currently Message Type " + messageType + " not supported.");
                }
            } catch (FieldNotFound fieldNotFound) {
                fieldNotFound.printStackTrace();
            }

        }

    }

    @Override
    public void handleOutgoingMessage(Message outgoingMessage) {
        if (fixType.equalsIgnoreCase("initiator")) {
            try {
                String messageType = outgoingMessage.getHeader().getString(35);
                switch (messageType) {
                    case "D" :
                        String orderId = outgoingMessage.getString(11);
                        orderService.updateOrderStatus(orderId, "Sent for Execution", 0.0);
                        break;
                    default:
                        System.out.println("Currently Message Type " + messageType + " not supported.");
                }
            } catch (FieldNotFound fieldNotFound) {
                fieldNotFound.printStackTrace();
            }

        }

    }
}
