package Utilities;

import java.util.ResourceBundle;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoPayload.DieticianPayload;
import pojoPayload.NewPatientPayload;

public class BaseUtils {
	
	public static ResourceBundle config = ResourceBundle.getBundle("Config");
	public static ExcelUtils excelutils=new ExcelUtils(config.getString("Excel_Path"));
	public static DieticianPayload dieticianpayload = new DieticianPayload();
	public static NewPatientPayload newpatientpayload = new NewPatientPayload();
	public static RequestSpecification request;
	public static Response response;
	public static String  BaseURI = config.getString("BaseUrl");
	public static Faker faker = new Faker();
}
