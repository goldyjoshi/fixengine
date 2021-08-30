package com.strathclyde.fixengine.fixengine.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;

@SpringBootTest
public class FixEngineInitializationTest {

    @Autowired
    private FixEngineInitialization fixEngineInitialization;

    @Test
    public void getConfigFromFileTest() {
        // Application configuration test.
        InputStream configuration = fixEngineInitialization.getConfigFromFile();
        assertNotNull(configuration);
    }

}
