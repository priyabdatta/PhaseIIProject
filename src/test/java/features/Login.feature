Feature: Login Feature Scenarios
@Regression
  Scenario Outline: Login Functionality with correct username and password
    Given I have open the Swag Labs Application
   
    And I enters username "<UserName>"
    And I enters password "<Password>"
    And I click on login button
    Then I Should be landed on the Products Page

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Login Functionality with incorrect username and password
    Given I have open the Swag Labs Application
   
    When I enters username "<UserName>"
    And I enters password "<Password>"
    And I click on login button
    Then I Should be Getting the "<Error>"

    Examples: 
      | UserName      | Password      |                    Error                                                  |                   
      | standard_user | secret_sauce2 | Epic sadface: Username and password do not match any user in this service |
