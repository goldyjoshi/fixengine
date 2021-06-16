package com.strathclyde.fixengine.fixengine;

import com.strathclyde.fixengine.fixengine.app.FixEngineInitialization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FixengineApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FixengineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		FixEngineInitialization fixEngineInitialization = new FixEngineInitialization();

	}
}
