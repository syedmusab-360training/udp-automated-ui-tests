Feature: Homepage title verification
  In order to verify homepage title
  A request with valid credentials takes user to udp homepage
  verify it displayed page heading

  Scenario: Verify udp page title
    Given user navigates to signIn page
    When user enters valid credentials
    Then user should be taken to udp homepage
    And verify the page heading is displayed