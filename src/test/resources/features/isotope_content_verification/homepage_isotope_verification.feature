Feature: In order to verify retake this course functionality
  user will click on retake this course icon
  verify if it navigates to course player popup

  Scenario: Verify retake this course functionality
    Given user navigates to signIn page
    When user enters in udp homepage
    And user clicks on retake this course icon or course isotope image.
    Then it should popup "courseplayer" window
