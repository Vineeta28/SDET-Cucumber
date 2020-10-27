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
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Searching for jobs using XPath
		Given User is on the Jobs Page
    When Fill all the required information:<gmail>,<title>,<location>,<description>,<cmpny_name>
    Then Search for the job:<title>
    And Close all the browser

 

    Examples: 
| gmail 				| title      | location  |        description             | cmpny_name |
| abg@xyz.mail  | SDETTestNG | Bangalore |This is for SDET Testing profile| Alchemy    |
|def@rty.mail   | SDETTester | Bangalore | This is for SDET Tester        | Alchmeny   |
|adf@rty.mail   | Tester     | Bangalore | This is for Tester             | Alchemy    |
