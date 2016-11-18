Feature: In order to verify retake this course functionality
  user will click on retake this course icon
  verify if it navigates to course player popup

  Scenario: Verify retake this course functionality
    Given user navigates to signIn page
    When user enters in udp homepage
    And user clicks on retake this course icon or course isotope image.
    Then it should popup "courseplayer" window

  Scenario: Verify about your class information popup functionality
    Given user navigates to signIn page
    When user enters in udp homepage
    And user clicks on course details icon from course isotope
    Then it should popup about your class popup

  Scenario: Verify time spent functionality of course isotope
    Given user navigates to signIn page
    When user enters in udp homepage
    Then course isotopes displays Time Spent for online courses

