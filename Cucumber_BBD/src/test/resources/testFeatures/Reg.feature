Feature: Verify Registration functionality

Scenario: Verify user is able to register with valid details
Given registration page should be open in default browser
When click on first name field and add valid <firstname>
And click on last name field and add valid <lastname>
And click on email field and enter valid <email>
And click on telephone field and enter valid <phonenumber>
And click on password field and enter valid <password1>
And click on confirm password field and enter same <password2>
And click on privacy policy checkbox
And now click on continue button
Then registration should be successful and redirect to home page
Examples:
|firstname|lastname|email|phonenumber|password1|password2|
|abc|xyz|xbzytg@gmail.com|2222222222|A1234567X|A1234567X|