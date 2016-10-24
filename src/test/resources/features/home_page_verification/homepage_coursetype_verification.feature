Feature: In order to get course type heading
  A request with valid credentials takes user to udp homepage
  verify it displayed courses type titles
  course type verification

  Scenario: Verify header box titles
    Given user navigates to signIn page
    When user enters in udp homepage
    Then "Number Of My Courses" should be displayed in first box with respect to all courses count
    And "Courses In Your Subscription" should be displayed in second box with respect to subscription count
    And "Courses You've Completed" should be displayed in third box with respect to completed count




