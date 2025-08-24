Feature: Edit AccountDetail in Salesforce
Background:
Given Launch the url

Scenario: Edit and feed data to existing Account

When Enter the loginname as vidyar@testleaf.com
When Enter the loginpassword as Sales@123
And Click on the ok button
And Click on toggle menu button
And Click View All 
And Select Sales from App Launcher
And Click on Accounts tab
Then Search for the account using your unique accountname as Anusathya
And  Click the dropdown icon next to the account and select Edit 
And  Set Type to Technology Partner 
And  Set Industry to Healthcare 
When Enter the Billing Address as Tekwood street 
When Enter the Shipping Address as Wipro street
And   Select Customer Priority to Low 
And   Select SLA to Silver 
And   Set Active to NO
When  Enter a unique number in the Phone field as 9898989898
And   Set Upsell Opportunity to No 
And   Click Save and verify the phone number as 9898989898
