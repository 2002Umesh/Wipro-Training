Feature: verify Search functionality
Scenario: verify user is able to search
Given login page should be open in default browser
When click on user name field and add valid username
And then click on password button and enter valid password
And now click on submit button <Status>
And click on search,add item and click enter <product> 
Then show search item
Examples:
|product|
|online banking|
