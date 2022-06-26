Feature: Account
  Background:
    Given there is a user with email "zbcjackson@odd-e.com" and password "password"
    Given signin with email "zbcjackson@odd-e.com" and password "password"
    Given create account with name "altman" and balance 123

  Scenario: success
    When login with email "zbcjackson@odd-e.com" and password "password"
    When list accounts
    Then verify account success with name "altman" and balance 123

#  Scenario: fail
#    When login with email "zbcjackson@odd-e.com" and password "incorrect-password"
#    Then login fail with message "Email and password are invalid."