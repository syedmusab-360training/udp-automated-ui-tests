Feature: In order to verify resource menu
  user navigates to udp homepage
  user should see resource menu and sub menus at left panel
  Resource Menu Verification

  Scenario: Resource Menu Verification
    Given user navigates to signIn page
    When user enters in udp homepage
    Then Verify that on Dashboard page left panel, fourth tab should be "Resources"
    And Verify under resource menu, first tab is "Shop Courses"
    And Verify under resource menu, second tab is "Browse Free Courses"
    And Verify under resource menu, third tab is "Support Forum"