Feature:In order to verify learner mode account
  a request with valid credentials display learner and resources tab at left panel
  Learner Mode Verification

  Scenario: Verify Learner Mode Verification
    Given user enters learner mode credentials
    When user navigate to udp homepage
    Then user should see "learner" and "resources" tab at left panel