Feature: Patient Feature

  @POSTUserLogin
  Scenario: User login as Patient with valid credentials
    Given User creates  Request
    When User sends HTTPS POST Request with patient login endpoint and request Body
    Then User receives 200 Status Code

  @GETPatientMorbidityloginAsPatientDetails
  Scenario: Get Patients Morbidity datails login as patient with PatientID
    Given User creates  Request
    When User sends HTTPS GET Request login as patient for Morbidity Details with  PatientId and with authentication token
    Then User receives 200 Status Code

  @GETPatientFileByFileIDloginAsPatient
  Scenario: Get Patients File By FileID login as patient
    Given User creates  Request
    When User sends HTTPS GET Request login as patient to view File with FileId and with authentication token
    Then User receives 200 Status Code

  @DELETEPatientWithValidID
  Scenario: Delete a patient with valid PatientId
    Given User creates  Request
    When User sends HTTPS Delete Patient Request and with valid PatientId and authentication token
    Then User receives 200 Status Code

  @DELETEPatientWithInValidID
  Scenario: Delete a patient with Invalid PatientId
    Given User creates  Request
    When User sends HTTPS Delete Patient Request and with Invalid PatientId and authentication token
    Then User receives 404 Status Code

  @DieticianLogOut
  Scenario: Dietician LogOut
    Given User creates  Request
    When User sends HTTPS GET Request to logout as a Dietician and authentication token
    Then User receives 200 Status Code
