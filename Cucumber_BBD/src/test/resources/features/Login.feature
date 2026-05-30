Feature: verify Login functionality
Scenario: verify user is able to login with valid credentials
Given login page should be open in default browser
When click on user name field and add valid <username1>
And then click on password button and enter valid <password1>
And now click on submit button <Status>
Then login successfully and redirect to home page
Examples:
|username1|password1|Status|
|username|password|success|
|user123|password|fail|
|username|pass123|fail|
