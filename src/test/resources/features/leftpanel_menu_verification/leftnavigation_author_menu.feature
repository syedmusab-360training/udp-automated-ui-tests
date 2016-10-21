Feature: Author Menu Verification From Left Panel Navigation
  In order to verify author menu
  user navigates to udp homepage
  user should see author menu and sub menus at left panel

  Scenario: Author Menu Verification
    Given user navigates to signIn page
    When user enters in udp homepage
    Then Verify that on Dashboard page left panel, first submenu should be "Author"
    And Verify under author menu, first tab is "Course Reports"
    And Verify under author menu, second tab "Create & Manage Courses"
