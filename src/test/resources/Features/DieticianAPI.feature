Feature: DieticianAPI Feature

  @POSTUserLogin
  Scenario: User login with valid credentials
    Given User creates  Request
    When User sends HTTPS POST Request with login endpoint and request Body
    Then User receives 200 Status with response body

  @POSTUserLoginInValidUser
  Scenario: User login with Invalid credentials
    Given User creates  Request
    When User sends HTTPS POST Request with login endpoint and with invalid credentials in request Body
    Then User receives 401 Status with response body

  @POSTUserLoginWithMissingMandatoryField
  Scenario: User login with missing mandatory field
    Given User creates  Request
    When User sends HTTPS POST Request with login endpoint and with missing mandatory fields in request body
    Then User receives 401 Status with response body

  

  @GETAllPatient
  Scenario: Get all Patient details
    Given User creates  Request
    When User sends HTTPS Request to Get all Patients with authentication token
    Then User receives 200 Status with response body
