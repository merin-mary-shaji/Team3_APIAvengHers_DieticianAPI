Feature: DieticianAPI Feature

  @POSTUserLogin
  Scenario: User login with valid credentials
    Given User creates  Request
    When User sends HTTPS POST Request with login endpoint and request Body
    Then User receives 200 Status Code

  @POSTUserLoginInValidUser
  Scenario: User login with Invalid credentials
    Given User creates  Request
    When User sends HTTPS POST Request with login endpoint and with invalid credentials in request Body
    Then User receives 401 Status Code

  @POSTUserLoginWithMissingMandatoryField
  Scenario: User login with missing mandatory field
    Given User creates  Request
    When User sends HTTPS POST Request with login endpoint and with missing mandatory fields in request body
    Then User receives 401 Status Code

  @POSTCreateNewPatientWithValidBody
  Scenario: User creates new patient with valid body
    Given User creates  Request
    When User sends HTTPS POST Request and with valid request body and authentication token
    Then User receives 201 Status Code

  @POSTCreateNewPatientWithmandatoryFieldNotIncluded
  Scenario: User creates new patient when mandatory field not included
    Given User creates  Request
    When User sends HTTPS POST Request when mandatory field not included and with authentication token
    Then User receives 400 Status Code

  @GETAllPatient
  Scenario: Get all Patient details
    Given User creates  Request
    When User sends HTTPS Request to Get all Patients with authentication token
    Then User receives 200 Status Code

  @PUTUpdatePatientWithValidPatientIdAndBody
  Scenario: Update Patient with a Valid PatientId
    Given User creates  Request
    When User sends HTTPS PUT Request with valid PatientId Queryparam PatientInfo Request body and with authentication token
    Then User receives 200 Status Code

  @PUTUpdatePatientWithInValidPatientId
  Scenario: Update Patient with a InValid PatientId
    Given User creates  Request
    When User sends HTTPS PUT Request with Invalid PatientId Queryparam PatientInfo Request body and with authentication token
    Then User receives 404 Status Code

  @PUTUpdatePatientWithPatientIdAndMissingField
  Scenario: Update Patient with Valid PatientId and missing mandatory fields
    Given User creates  Request
    When User sends HTTPS PUT Request with valid PatientId missing mandatory field in Queryparam PatientInfo Request body and with authentication token
    Then User receives 400 Status Code

  @GETPatientMorbidityDetailsValidId
  Scenario: Get Patients Morbidity datails with Valid PatientID
    Given User creates  Request
    When User sends HTTPS GET Request for Morbidity Details with valid PatientId and with authentication token
    Then User receives 200 Status Code

  @GETPatientMorbidityDetailsInValidId
  Scenario: Get Patients Morbidity datails with InValid PatientID
    Given User creates  Request
    When User sends HTTPS GET Request for Morbidity Details with Invalid PatientId and with authentication token
    Then User receives 404 Status Code

  @GETPatientFileByFileID
  Scenario: Get Patients File By Valid FileID
    Given User creates  Request
    When User sends HTTPS GET Request to view File with valid FileId and with authentication token
    Then User receives 200 Status Code

  @GETPatientFileByInValidFileID
  Scenario: Get Patients File By InValid FileID
    Given User creates  Request
    When User sends HTTPS GET Request to view File with Invalid FileId and with authentication token
    Then User receives 404 Status Code
