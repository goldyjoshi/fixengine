package com.strathclyde.fixengine.fixengine.app;

import quickfix.Message;

/***
 * This interface used to implements abstraction of message handling.
 * @author Vijayshreejoshi
 */
public interface IFixMessageHandler {

    void handleIncomingMessage(final Message incomingMessage);
    void handleOutgoingMessage(final Message outgoingMessage);

}
