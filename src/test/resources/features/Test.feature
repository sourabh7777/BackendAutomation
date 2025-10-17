Feature: Environment variable resolution

  Scenario: Print spring profile and API key
    Given the application context is loaded
    When I retrieve the value of "spring_profile_active"
    And I retrieve the value of "api_key"
    Then I should see the profile and key printed in the logs