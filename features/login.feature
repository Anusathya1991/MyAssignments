Feature: Login functionality for leaftaps application

Scenario: login with valid credentials
Given launch the browser and load the url
When Enter the username as 'demosalesmanager'
When Enter the password as 'crmfsa'
And Click on the login button
Then Homepage should be displayed


Scenario: login with invalid credentials
Given launch the browser and load the url
When Enter the username as 'demosales'
When Enter the password as 'crmsfa'
And Click on the login button
But Error msg is displayed
