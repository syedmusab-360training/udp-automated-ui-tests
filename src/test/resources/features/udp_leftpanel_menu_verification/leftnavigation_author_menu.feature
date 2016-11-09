Feature: In order to verify author menu
  user navigates to udp homepage
  user should see author menu and sub menus at left panel
  Author Menu Verification

  Scenario: Author Menu Verification
    Given user navigates to signIn page
    When user enters in udp homepage
    Then Verify that on Dashboard page left panel, first submenu should be "Author"
    And Verify under author menu, first tab is "Course Reports"
    And Verify under author menu, second tab "Create & Manage Courses"

  Scenario: Author Submenu Function Verification
    Given user navigates to signIn page
    When user enters in udp homepage
    And Verify that when user clicks on Create and Manage Courses button
    Then it should be redirected to WLCMS Author Mode screen create courses page
