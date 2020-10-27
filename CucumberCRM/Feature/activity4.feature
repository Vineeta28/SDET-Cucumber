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
Feature: Create products

@activity4
Scenario Outline: Create products
Given User is on SuitCRM
When Navigates to all Products
And Enter production information with "<Productname>" and "<Description>"
Then View Products "<Productname>" 
And Close browser


Examples:
| Productname | Description|
| ABC201 | 20101 |
| DEF202 | 20102 |
| GHI203 | 20103 |
