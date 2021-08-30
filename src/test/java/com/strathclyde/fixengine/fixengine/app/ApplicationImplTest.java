package com.strathclyde.fixengine.fixengine.app;

import com.strathclyde.fixengine.fixengine.utility.TestUtility;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import quickfix.*;

@SpringBootTest
public class ApplicationImplTest {

    @Mock
    private FixMessageHandler fixMessageHandlerMock;

    @InjectMocks
    private ApplicationImpl applicationImplMock;

    @Test
    public void toAppTest() throws DoNotSend {
        // Given
        Message fixMessage = TestUtility.createFixMessage("TestOrderId", "D");
        SessionID sessionID = new SessionID("FIX.4.2:STRATHCLYDE_FIXENGINE->INVESTMENT_BANK");

        // When
        applicationImplMock.toApp(fixMessage, sessionID);
        Mockito.doNothing().when(fixMessageHandlerMock).handleOutgoingMessage(fixMessage);

        // Then
        Mockito.verify(fixMessageHandlerMock, Mockito.times(1))
                .handleOutgoingMessage(fixMessage);
    }

    @Test
    public void fromAppTest() throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        // Given
        Message fixMessage = TestUtility.createFixMessage("TestOrderId", "D");
        SessionID sessionID = new SessionID("FIX.4.2:STRATHCLYDE_FIXENGINE->INVESTMENT_BANK");

        // When
        applicationImplMock.fromApp(fixMessage, sessionID);
        Mockito.doNothing().when(fixMessageHandlerMock).handleIncomingMessage(fixMessage);

        // Then
        Mockito.verify(fixMessageHandlerMock, Mockito.times(1))
                .handleIncomingMessage(fixMessage);
    }

}
