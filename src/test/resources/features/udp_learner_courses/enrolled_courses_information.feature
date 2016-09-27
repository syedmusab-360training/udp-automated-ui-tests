Feature: Learner enrolled courses detailed information

  Scenario: Verify learner enrolled courses detailed information

    Given get access token from api gate way to get enrolled courses information for specific learner
    When enrolled courses information api is called  with valid parameters to get learner enrolled courses information
    Then enrolled courses information for provided learner is returned
