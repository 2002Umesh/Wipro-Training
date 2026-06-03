Feature: Registration Module

  Background: PHPTravels home page is open
    Given PHPTravels home page is open

  @Smoke
  Scenario Outline: Validate Registration
    Given user clicks Register option
    When enters necessary credentials "<firstname>" "<lastname>" "<email>" "<password>" "<confirm_password>"
    And enters security check value
    And selects privacy checkbox
    And clicks create account button
    Then registration should complete

    Examples:
      | firstname | lastname | email             | password  | confirm_password |
      | abc       | xyz      | ac135mp@gmail.com | 123Asd!@# | 123Asd!@#        |
