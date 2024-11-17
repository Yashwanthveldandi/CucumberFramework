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
Feature: feature to check login functionality
  I want to use this template for my feature file

Background: verify page
Given user in the login page

 @Smoke
  Scenario: Check login is successfull with valid credentials
    Given user is on login page
    When user enters credentials
    And click on login button
    Then user is navigated to homepage
    Then user clicks on admin button
    
   
  @Smoke
  Scenario Outline: Check login is successful with valid username and password
    Given user on login page
    When user enter "<username>" and "<password>"
    And click login button
    Then user navigated to homepage
    Then user clicks on admin page

    Examples: 
      | username | password |
      | Admin    | admin123 |