package stepDefinition;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import Utilities.BaseUtils;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;


public class Hooks extends BaseUtils {
	
	private static boolean logInitialized = false;
	//private static final String SCENARIO_TagNAME_TO_LOG = "@GETPatientFileByFileID";
	
	
	@Before()
	public static void beforeScenario() throws FileNotFoundException {
		if (!logInitialized) {
		PrintStream stream = new PrintStream(new FileOutputStream("Team3_APIAvengHers_log.txt"));
		RestAssured.filters(RequestLoggingFilter.logRequestTo(stream));
		RestAssured.filters(ResponseLoggingFilter.logResponseTo(stream));
		
		logInitialized = true;
		}
		
	}
	
	/*@Before()
	public static void beforeScenario(Scenario scenario) throws FileNotFoundException {
		
		
		if (!logInitialized) {
			if (skipLogging(scenario)) {
				//scenario.log("Scenario is skipped based on the tag: " + SCENARIO_TagNAME_TO_LOG);
               
            } else {
		PrintStream stream = new PrintStream(new FileOutputStream("Team3_APIAvengHers_log141.txt"));
		RestAssured.filters(RequestLoggingFilter.logRequestTo(stream));
		RestAssured.filters(ResponseLoggingFilter.logResponseTo(stream));
			}
		logInitialized = true;
		}
		
	}
	private static boolean skipLogging(Scenario scenario) {
		
		 
		 return scenario.getSourceTagNames().contains(SCENARIO_TagNAME_TO_LOG);
		
   }*/
	
}
