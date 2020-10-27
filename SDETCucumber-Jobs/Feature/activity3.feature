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
@tag
Feature: Create the job and verify

  @activity3
Scenario: Searching for jobs using XPath
		Given User is on Jobs Page
    When Fill the information "abf@xyz.mail","SDETTest","Bangalore","This is for SDET Testing profile","Alchemy"
    Then Search for the job "SDETTester"
    And Close all the browser

    