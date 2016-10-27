Feature: In order to verify udp search bar
  user navigates to udp homepage
  user should see search bar below the course count

  Scenario: Search Bar Verification
    Given user navigates to signIn page
    When user enters in udp homepage
    Then Verify that on my courses page should display input field for search courses
    And Verify that search bar contains following button
    |All|
    |New|
    |Started|
    |Completed|
    |Subscription|
