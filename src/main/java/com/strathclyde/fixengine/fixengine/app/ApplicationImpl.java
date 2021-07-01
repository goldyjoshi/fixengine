package com.strathclyde.fixengine.fixengine.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quickfix.*;

@Component
public class ApplicationImpl implements Application {


    private FixMessageHandler fixMessageHandler;

    public ApplicationImpl(final FixMessageHandler fixMessageHandler) {
        super();
        this.fixMessageHandler = fixMessageHandler;
    }

    /***
     * This method will be called on creation of Fix session.
     * @param sessionID
     */
    @Override
    public void onCreate(SessionID sessionID) {
        System.out.println("On session creation, session Id : " + sessionID );


    }

    /***
     * This call back method called when fix connection has been established.
     * @param sessionID
     */
    @Override
    public void onLogon(SessionID sessionID) {
        System.out.println("On session logon, session Id : " + sessionID );

    }

    /***
     *  This call back method called and inform you when Fix session will be off.
     *
     * @param sessionID to give unique id of fix session.
     */
    @Override
    public void onLogout(SessionID sessionID) {
        System.out.println("On session logout, session Id : " + sessionID );
    }

    /***
     * This call back method called when message send to counter party by fix engine and allow you to
     * add  fields to administrative message.
     * @param message to give type of message in Fix.
     * @param sessionID to give value of id of fix session.
     */
    @Override
    public void toAdmin(Message message, SessionID sessionID) {
        System.out.println("Admin message " + message + " sent with session Id : " + sessionID );

    }

    /***
     * This call back method called after fix connection established notifies you
     * about counter party message.This is useful to validate on logon message. this also throw exception
     * and might be disconnect counter party.
     * @param message to give value of message receive from counter party or acceptor.
     * @param sessionID to give Id of Fix Session.
     * @throws FieldNotFound if not found file(message, type of message(version).
     * @throws IncorrectDataFormat if FIx message format is incorrect.
     * @throws IncorrectTagValue throw exception if tag value is incorrect.
     * @throws RejectLogon will disconnect the counter party.
     */
    @Override
    public void fromAdmin(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        System.out.println("Admin message " + message + " received with session Id : " + sessionID );
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {
        System.out.println("Business message sent " + message + " with session Id : " + sessionID );
        fixMessageHandler.handleOutgoingMessage(message);
    }

    @Override
    public void fromApp(Message message, SessionID sessionID) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        System.out.println("Business message received " + message + " with session Id : " + sessionID );
        fixMessageHandler.handleIncomingMessage(message);
    }
}
