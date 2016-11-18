Feature: In order to verify enrollment created in lms and udp increases number of courses count
  Learner access the course from the "Available Courses" page in the LMS then enrollment is created
  verify the Dashboard application then "Number of My Courses" count must increased by 1 in the current value

  Scenario: Verify "Number of My Courses" count must increased by 1 in the current value
    Given user navigates to lms signIn page
    When user enters in lms homepage
    And user clicks on continue button from initial screen and navigates to learner mode
    Then user access the course from the Available Courses page in the LMS then enrollment is created
    And verify Number of My Courses count must increased by 1 in the current value