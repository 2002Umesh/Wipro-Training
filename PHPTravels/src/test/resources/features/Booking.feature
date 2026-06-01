Feature: Booking Workflow

  Background: PHPTravels home page is open
    Given PHPTravels home page is open

  @Booking
  Scenario Outline: Complete Booking Flow
    Given user searches hotel "<city>"
    When user choose a hotel
    And user completes booking "<fname>" "<lname>" "<email>" "<phonenum>"
    Then booking should be confirmed

    Examples:
      | city  | fname | lname | email                | phonenum   |
      | Dubai | Kumar | Shanu | shanuwkfhc@gmail.com | 7249246953 |
