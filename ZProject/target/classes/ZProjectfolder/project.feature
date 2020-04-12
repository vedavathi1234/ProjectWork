#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@practiseautomation
Feature: Practiseautomation testing


  @TC_01 
  Scenario: Login
    Given User on homepage
    And User on login page
    When User enters username and password
    And user clicks login button
    Then User lands on homepage
  

  @TC_02 
  Scenario Outline: Login and Accountdetails
    Given User on homepage1
    And User on login page1
    When User clicks login button1
    And User clicks on Accountdetails1
    And User enters "<currentpassword>" and "<newpassword>" and "<confirmpassword>"
    Then User lands on password changed successfully

Examples:
|  currentpassword  |  newpassword  |  confirmpassword  |
|  S@1teja12        |  S@1teja12    |  S@1teja12        |


@TC_03
Scenario Outline: Saving user's Billing Address
Given User on home page1
And User enters to login page
When User enters details and clicks login button
And User clicks on Address
And User click on edit option
Then Start entering details "<firstname>" "<lastname>" "<companyname>" "<email>" "<phone>" "<address1>" "<address2>" "<city>"
And Click on savechanges
Then User get saving notification
Examples:
| firstname | lastname | companyname |        email             |   phone    | address1 | address2 | city    | 
| affu      | lucy     |  webtoon    | afreen.md5671@gmail.com  | 9876543210 | chivstrt | railpet  | guntur  |  



 @TC_04
Scenario: Add to Basket
    Given User on homepage2
    When User searches the product
    And User select the product
    And User select the filter
    And User click the product
    And User add to basket
    Then User lands on basketpage

@TC_05
Scenario: Download File
    Given User on homepage3
    When Userclicks on Demosite
    And User clicks on Download file
    And User enters the data
    And User generates the file
    And User downloads the file
    Then File is downloaded

@TC_06
Scenario: User placingorder from cart
Given Enters the home page
When User login with valid credentials
Then User clicks on shop
Then User select an item to basket and view the product
And Clicks on proceed 
And Moveon to place order
Then User lands on other page which shows order is successfull

@TC_07
Scenario: Deleting item from cart
Given User on home page6
And select the shop for a product and add to cart
Then clicks on view basket
And delete the unwanted item
Then deleted message appear on screen

@TC_08
Scenario: play youtube video
Given User on homepage4   
When User clicks on Demosite  
And User clicks on vimeo button
Then video is played
 