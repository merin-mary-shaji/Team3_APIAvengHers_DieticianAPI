package Utilities;

import java.io.File;
import java.util.ResourceBundle;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoPayload.DieticianPayload;
import pojoPayload.MandatoryFieldMissingPatientPayload;
import pojoPayload.NewPatientPayload;
import pojoPayload.PatientLoginPayLoad;

public class BaseUtils {

	public static ResourceBundle config = ResourceBundle.getBundle("Config");
	public static ExcelUtils excelutils = new ExcelUtils(config.getString("Excel_Path"));
	public static DieticianPayload dieticianpayload = new DieticianPayload();
	public static NewPatientPayload newpatientpayload = new NewPatientPayload();
	public static MandatoryFieldMissingPatientPayload payload = new MandatoryFieldMissingPatientPayload();
	public static PatientLoginPayLoad patientpayload = new PatientLoginPayLoad();

	public static File patientDetailSchemaf = new File(config.getString("PatientDetailSchema"));
	public static File loginSchemaf = new File(config.getString("LoginSchema"));
	public static File createPatientSchemaf = new File(config.getString("CreatePatientSchema"));
	public static File updatePatientSchemaf = new File(config.getString("UpdatePatientSchema"));
	public static File PatientMorbiditySchemaf = new File(config.getString("PatientMorbiditySchema"));

	public static RequestSpecification request;
	public static Response response;
	public static String BaseURI = config.getString("BaseUrl");
	public static Faker faker = new Faker();
}
