Feature: Booking Workflow

  Background: PHPTravels home page is open
    Given PHPTravels home page is open

  @Booking
  Scenario: Complete Booking Flow
    Given user searches hotel "<city>"
    When user choose a hotel
    And user completes booking
    Then booking should be confirmed

    Examples:
      | city  |
      | Dubai |
