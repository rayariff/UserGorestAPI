Feature: Get User Details

  Scenario: Get user details with valid id
    Given Get user details with valid 6859426
    When Send request get user details with id
    Then Status code should be 200
    And Validate json schema "GetUserValidSchema.json"

  Scenario: Get user details with unregistered user id
    Given Get user details with user id 5880047
    When Send request get user details with user id
    Then Status code should be 404
    And Response body message was "Resource not found"
    And Validate json schema "GetUserInvalidSchema.json"

  Scenario: Get user details with invalid id
    Given Get user details with user id "hehehe"
    When Send request get user details with id
    Then Status code should be 404
    And Response body message was "Resource not found"
    And Validate json schema "GetUserInvalidSchema.json"

  Scenario: Get user details with valid name and gender parameter
    Given Get user details with parameter name is "devi" and gender is "female"
    When Send request get user details with name and gender parameter
    Then Status code should be 200

  Scenario: Get user details with unavailable name and available gender parameter
    Given Get user details with parameter name is "deeev" and gender is "female"
    When Send request get user details with name and gender parameter
    Then Status code should be 200
    And Validate json schema "GetUserInvalidNameSchema.json"

  Scenario: Get user details with invalid parameter
    Given Get user with invalid parameter is "invalid_parameter"
    When Send request get user details with invalid parameter
    Then Status code should be 404



