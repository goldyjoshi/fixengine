package com.strathclyde.fixengine.fixengine.app;

//import org.graalvm.compiler.api.replacements.Snippet;
import com.strathclyde.fixengine.fixengine.database.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import quickfix.*;


import javax.annotation.PostConstruct;
import java.io.InputStream;

/***
 * Class is used to start Fix connection as an initiator mode and after getting configuration
 * @author vijayshreejoshi
 */
@Component
public class FixEngineInitialization {

    @Value("${app.fix.type}")
    private String fixType;

    @Autowired
    private FixMessageHandler fixMessageHandler;

// @value not working with constructor because spring injecting value before creation of object.
//    public FixEngineInitialization() {
//        InputStream configurationAsStream = getConfigFromFile();
//        startInitiator(configurationAsStream);
//    }

    @PostConstruct
    public void init() {
        InputStream configurationAsStream = getConfigFromFile();
        startInitiator(configurationAsStream);
    }



    /***
     * This method is used to start an Fix connection in initiator mode.
     * @param configurationAsInputStream will give configuration to start a connection.
     */
    public void startInitiator(InputStream configurationAsInputStream) {
        /***
         * Create an object of ApplicationImpl Class.
         */
        ApplicationImpl application = new ApplicationImpl(fixMessageHandler);

        /***
         * Create an object of MessageFactory Class.
         */
        MessageFactory messageFactory = new DefaultMessageFactory();

        try {

            /***
             * Create an object of SessionSettings Class.
             */
            SessionSettings sessionSettings = new SessionSettings(configurationAsInputStream);


            /***
             * Create an object of MessageStoreFactory Class.
             */
            MessageStoreFactory messageStoreFactory = new FileStoreFactory(sessionSettings);


            /***
             * There is if condition to check either application will start as initiator(trader) or acceptor(Broker)
             * mode
             */
            if(fixType.equalsIgnoreCase("initiator")) {
                Initiator initiator = new SocketInitiator(application, messageStoreFactory,
                        sessionSettings, messageFactory);
                initiator.start();
            } else {
                Acceptor acceptor = new SocketAcceptor(application, messageStoreFactory,
                        sessionSettings, messageFactory);
                acceptor.start();
            }
        } catch (ConfigError configError) {
            configError.printStackTrace();
        }

    }

    /***
     * This method is used to get all configuration information from file to start connection.
     * @return  value of configurationAsStream of type InputStream.
     */
    public InputStream getConfigFromFile() {
        String configLocation = "/fixengine_acceptor_configuration.cfg";
        if (fixType != null && fixType.equals("initiator")) {
            configLocation = "/fixengine_initiator_configuration.cfg";
        }
        InputStream configurationAsStream = FixEngineInitialization.class.getResourceAsStream(configLocation);

        return configurationAsStream;
    }

}
