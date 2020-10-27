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
Feature: Create leads

  @tag1
  Scenario Outline: Create Leads using values passed from here
	Given Open the browser to the Alchemy CRM site
	When User Creates Lead with "<Lastname>"
  Then Views Leads page to see result with "<Lastname>"
  And Closes the browser

Examples: 

| Lastname |
| Ria      |
| Rachael  |
|Michale   |


