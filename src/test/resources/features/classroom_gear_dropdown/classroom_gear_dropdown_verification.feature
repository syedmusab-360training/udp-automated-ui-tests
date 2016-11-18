Feature: In order to gear feature in classroom course isotope
  user will click on gear icon and it will open drop down
  verify if it displays appropriate options list

  Scenario: Verify gear icon of classroom course isotope
    Given user navigates to signIn page
    When user enters in udp homepage and click gear icon from classroom isotope
    Then it should display all following options
    |Prepare for Class|
    |Check your System|
    |Network & Bandwidth|
    |Lync Demonstration|
    |Lab Demonstration|
    |My Courseware|
    |Support|