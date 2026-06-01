Feature: PHPTravels Login Module

  Background: PHPTravels home page is open
    Given PHPTravels home page is open

  @Smoke @Regression
  Scenario: Validate Login Functionality
    Given user launches browser and click login
    When user enters username and password
    And clicks on login button
    Then validate login result

  
