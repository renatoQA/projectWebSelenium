#Author: Renato Bernardes

 Feature: Validate saucedemo features for login

  Background:
   Given I access the "Url" to realize login

  @TestCase
  Scenario: Try to login wih standard user
  When I realize login with the user "UsernameStandard" and password "PasswordValid"
  Then I should be logged in successfully


