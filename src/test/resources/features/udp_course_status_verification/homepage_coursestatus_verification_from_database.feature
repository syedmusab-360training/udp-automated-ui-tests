Feature: In order to verify courses with respect to their course type
  A request with valid credentials takes user to udp homepage
  verify if it displays correct number of courses with their status

  Scenario: Verify new status courses through database
    Given user navigates to signIn page
    When user enters in udp homepage
    And user clicks on New Button from search bar
    Then only new status course should be displayed in that particular branch

  Scenario: Verify started status courses through database
    Given user navigates to signIn page
    When user enters in udp homepage
    And user clicks on started button from search bar
    Then only started status courses should be displayed in that particular branch


  Scenario: Verify completed type courses through database
    Given user navigates to signIn page
    When user enters in udp homepage
    And user clicks on completed button from search bar
    Then only completed type courses should be displayed in that particular branch