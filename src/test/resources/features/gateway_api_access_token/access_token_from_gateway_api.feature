Feature: Access token from ls360 gateway api
  In order to get access token from LS360 API-Gateway
  A request to LS360 API gateway with valid end point always return Access Token
  A request with invalid end point and/or invalid parameters returns appropriate error message

  Scenario: A api call with valid end point and parameters returns valid access token
    Given get access token through ls360 api gateway
    When a request is sent to ls360 api gateway with valid parameters
    Then ls360 api gateway returns valid access token when valid parameters were passed

  Scenario: A api call with Invalid parameters returns error with appropriate status code
    Given get access token through ls360 api gateway
    When a request is sent to ls360 api gateway with invalid parameters
    Then ls360 api gateway returns error with status code 401