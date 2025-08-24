Feature: Create Account functionality in Salesforce

Background:
Given Launch the url

Scenario Outline: Create new account with different names and ownership
When Enter the loginname as<username>
When Enter the loginpassword as<password> 
And Click on the ok Button
And Click on toggle menu button
And Click View All 
And Select Sales from App Launcher
And Click on Accounts tab
And Click on New button
When Enter the accountname as<accountname>
And  Select Ownership as public
When Save and verify the account as<accountname>
Examples:
|username|password|accountname|
|vidyar@testleaf.com|Sales@123|Anusathya G|
|vidyar@testleaf.com|Sales@123|Viswabharathy S|
|vidyar@testleaf.com|Sales@123|Valarmathy|
