Feature: Verify login functionality

  Scenario: Verify user is able to login with valid credentials
    Given login page should be open in default browser everytime
    When click on email and enter valid <email>
    And click on password and enter valid <password>
    And now click on login button
    Then login should be successful and redirect to home page

    Examples:
      |email|password|
      |xbzytg@gmail.com|A1234567X|
