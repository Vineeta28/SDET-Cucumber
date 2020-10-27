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
Feature: Add multiple employees

  @activity3
  
  Scenario Outline: Add multiple employees using an the Examples table
    Given Open the OrangeHRM Home page 
  	When Login with credentials provided
	  Then Find the PIM option in the menu and click it
	 	Then Go to Add Employee
    And Fill the required values <firstNmae>,<lastName>
    Then Click on Create Login Details
    And fill other values <UserName> and Save  
   	Then Go to Employee List
  	And Search the employee <firstName>
  	And Verify the employee <firstName>

    Examples: 
      |firstName| lastName | UserName  |
      | Sam     |     15   | name1235  |
      | Sammy   |     35   | name2341  |
      | Nia     |   Mary   | niamary   |
