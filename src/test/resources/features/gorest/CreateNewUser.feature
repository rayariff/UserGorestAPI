Feature: Create New User

  Scenario: Create new user with valid name, email, gender, and status
    Given Create new user with json "CreateUserValidData.json"
    When Send request post create new user
    Then Status code should be 201
    And Validate json schema "CreateUserValidSchema.json"

  Scenario: Create new user with email has been used before
    Given Create new user with json "CreateUserRegisteredEmail.json"
    When Send request post create new user
    Then Status code should be 422
    And Response body field was "email" and message was "has already been taken"
    And Validate json schema "CreateUserInvalid1Schema.json"

  Scenario: Create new user with invalid email format
    Given Create new user with json "CreateUserInvalidEmail.json"
    When Send request post create new user
    Then Status code should be 422
    And Response body field was "email" and message was "is invalid"
    And Validate json schema "CreateUserInvalid1Schema.json"

  Scenario: Create new user with invalid name format
    Given Create new user with json "CreateUserInvalidName.json"
    When Send request post create new user
    Then Status code should be 422
    And Response body field was "name" and message was "is invalid"

  Scenario: Create new user with invalid status format
    Given Create new user with json "CreateUserInvalidStatus.json"
    When Send request post create new user
    Then Status code should be 422
    And Response body field was "status" and message was "can't be blank"
    And Validate json schema "CreateUserInvalid1Schema.json"

   Scenario: Create new user with blank name
     Given Create new user with json "CreateUserBlankName.json"
     When Send request post create new user
     Then Status code should be 422
     And Response body field was "name" and message was "can't be blank"
     And Validate json schema "CreateUserInvalid1Schema.json"

   Scenario: Create new user with invalid gender and status
     Given Create new user with json "CreateUserInvalidGenderStatus.json"
     When Send request post create new user
     Then Status code should be 422
     And Response body field was "gender" and message was "can't be blank, can be male of female"
     And Response body second field was "status" and message was "can't be blank"
     And Validate json schema "CreateUserInvalid2Schema.json"


