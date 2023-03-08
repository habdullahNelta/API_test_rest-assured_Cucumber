Feature: API Test with rest assured
#tested site is: https://reqres.in/
  @GetAndDelete
  Scenario: GET test Scenarios
    Given test GET for ListUsers with status code 200
    And test Delete with status code 204
    Then test GET for userNotFound with status code 404

  @POST
  Scenario Outline:: POST test Scenarios
    Given test POST for Login with "<Email>" and "<Password>" status code 200
    And test POST for register user with "<Email>" and "<Password>" status code 200
    Then test POST for create user with "<Email>" and "<Password>" status code 201
    Examples:
      | Email              | Password |
      | eve.holt@reqres.in | pistol   |