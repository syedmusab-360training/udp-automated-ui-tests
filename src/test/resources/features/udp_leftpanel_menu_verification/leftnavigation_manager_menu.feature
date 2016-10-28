Feature: In order to verify manager menu
  user navigates to udp homepage
  user should see manager menu and sub menus at left panel
  Manager Menu Verification

  Scenario: Author Menu Verification
    Given user navigates to signIn page
    When user enters in udp homepage
    Then Verify that on Dashboard page left panel, third tab should be "Manager"
    And Verify under manager menu, first tab is "Manage Users"
    And Verify under manager menu, second tab is "Enroll Users"
    And Verify under manager menu, third tab is "Run Reports"