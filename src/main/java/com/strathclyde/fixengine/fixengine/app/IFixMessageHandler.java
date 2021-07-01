package com.strathclyde.fixengine.fixengine.app;

import quickfix.Message;

public interface IFixMessageHandler {

    public void handleIncomingMessage(final Message incomingMessage);
    public void handleOutgoingMessage(final Message outgoingMessage);

}
