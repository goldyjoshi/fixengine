package com.strathclyde.fixengine.fixengine;

import com.strathclyde.fixengine.fixengine.app.FixEngineInitialization;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/***
 * This class represent the main class of application.
 */
@SpringBootApplication
public class FixengineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FixengineApplication.class, args);
	}

	/***
	 * Required to run application from command line.
	 * @param args command line arguments.
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		FixEngineInitialization fixEngineInitialization = new FixEngineInitialization();
	}

}
