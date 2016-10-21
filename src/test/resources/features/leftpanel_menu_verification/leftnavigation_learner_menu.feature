Feature: Learner Menu Verification From Left Panel Navigation
  In order to verify learner menu
  user navigates to udp homepage
  user should see Learner menu and sub menus at left panel

  Scenario: Learner Menu Verification
    Given user navigates to signIn page
    When user enters in udp homepage
    Then Verify that on Dashboard page left panel, first submenu should be "Learner"
    And Verify that first tab is "My Courses"
    And Verify that second tab is "My Subscriptions"
    And Verify that third tab is "Transcriptions & Certificates"