Feature: Dashboard Title Verification
  In order to verify dashboard title verification
  user navigates to udp homepage
  user should see Dashboard title at left panel

  Scenario: Left Panel Title Verification
    Given user navigates to signIn page
    When user enters in udp homepage
    Then Verify that on Dashboard page left panel, main heading should be "Dashboard"