Feature: Learner enrolled courses count

  Scenario: Get learner courses count information

    Given get access token from api gate way to get enrolled courses count for specific learner
    When enrolled courses count api is called with valid parameters to get learner enrolled courses count
    Then api call should return learner course count for provided learner