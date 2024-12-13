package com.back_LimpPlast.integrationTests.testContainers;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.flyway.FlywayProperties.Postgresql;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.*;
import org.testcontainers.lifecycle.Startables;

import com.fasterxml.jackson.databind.ser.std.MapProperty;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {

	static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static   PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15.3");
    
	 private static void startContainers(){
		
		 Startables.deepStart(Stream.of(postgresContainer)).join();
	 }
	    
	 private static Map<String, String> createConnectionConfiguration(){
		 
		 return Map.of(
				   "spring.datasource,url",postgresContainer.getJdbcUrl(),
				   "spring.datasource.username", postgresContainer.getUsername(),
				   "spring.datasource.password",postgresContainer.getPassword());
				 
	 } 
		@SuppressWarnings("unchecked")
		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {

	       startContainers();
		ConfigurableEnvironment  enviroment = applicationContext.getEnvironment();
		
		@SuppressWarnings("rawtypes")
		MapPropertySource  testcontainers = new  MapPropertySource("testcontainers",(Map)createConnectionConfiguration());
		 enviroment.getPropertySources().addFirst(testcontainers);
		
		
		}

	}
}
