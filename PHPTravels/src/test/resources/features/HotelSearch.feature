Feature: Hotel Search

  Background: PHPTravels home page is open
    Given PHPTravels home page is open

  @Smoke
  Scenario Outline: Search Hotels
    Given user searches hotel "<city>"
    Then validate hotel results

    Examples:
      | city  |
      | Dubai |
