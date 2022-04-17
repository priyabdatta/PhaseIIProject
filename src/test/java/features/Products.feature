
Feature: This feature would be used to validate the Products price
 
Background: Open the Swag Labs application
   Given  User is on SauceDemo login page
   When   User enters Username "standard_user" and Password "secret_sauce"
   And    User clicks on Login button
   
   @Sanity
   Scenario: To validate the product prices
       When  User is on Products Page
       Then  user compare the following products prices
   
  
      |    Sauce Labs Backpack | $29.99 |
      |  Sauce Labs Bike Light | $9.99  |
      
