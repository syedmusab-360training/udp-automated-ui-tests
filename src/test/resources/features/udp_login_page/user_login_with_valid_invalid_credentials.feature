Feature: Login to udp Homepage
  In order to login into udp portal
  A request valid credentials takes user to udp homepage
  A request with invalid credentials returns an appropriate error message

  Scenario: Signin with valid credentials
    Given user navigates to signIn page
    When user enters valid credentials
    Then user should be taken to udp homepage
    And click on dropdown button and select signout

  Scenario: Signin with invalid credentials
    Given user navigates to signIn page
    When user enters invalid credentials
    Then user should get an appropriate error message