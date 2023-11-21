Feature: Motbidity module DieticianAPI Feature

  Background: User is successfully login

  @MorbidityDetailsPositiveScenario
  Scenario: Verify User is successfull in retriving the mobidity details using  Get request with valid endpoints
    Given User creates  Request
    When User sends HTTPS Request to get all morbidity details with authentication token
    Then User receives 200 Status Code

  @MorbidityDetailsNegativeScenario
  Scenario: Verify User is retriving the mobidity details using  Get request with invalid endpoints
    Given User creates  Request
    When User sends HTTPS Request to get all morbidity details with invalid endpoints authentication token
    Then User receives 404 Status Code and error "Not Found"

  @MorbidityConditionByTestName
  Scenario: Verify User is successfull in retriving the mobidity details with Get request passing test name and endpoints
    Given User creates  Request
    When User sends HTTPS  GET Request to get all morbidity deatials with passing test name and authentication token
    Then User receives 200 Status Code
