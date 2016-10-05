Feature: Learner enrolled courses count

  Scenario: Get learner courses count information

    Given get access token from api gate way to get enrolled courses count for specific learner

    When enrolled courses count api is called with parameters "notstarted" to get learner enrolled courses count
    And  enrolled courses count api is called with parameters "notstarted", "subscription" to get learner enrolled courses count
    And  enrolled courses count api is called with parameters "notstarted", "subscription", "inProgress" to get learner enrolled courses count
    And  enrolled courses count api is called with parameters "notstarted", "subscription", "inProgress", "completed" to get learner enrolled courses count

    Then api call should return learner course count for provided learner