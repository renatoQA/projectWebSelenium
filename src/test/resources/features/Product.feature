#Author: Renato Bernardes

Feature: Validate saucedemo features for products

  Background:
    Given I access the "Url" to realize login
    When I realize login with the user "UsernameStandard" and password "PasswordValid"
    Then I should be logged in successfully

  @TestCase
  Scenario: Try to checkout the cheapest item
    Given which I filtered to the "cheapest" item
    When I add the first product to my cart
    And realize the flow of checkout with my data "FirstName" "LastName" and "ZipCode"
    Then valid that my checkout was a success

  @TestCase
  Scenario: Try to checkout the highest item
    Given which I filtered to the "expensive" item
    When I add the first product to my cart
    And realize the flow of checkout with my data "FirstName" "LastName" and "ZipCode"
    Then valid that my checkout was a success

  @TestCase
  Scenario: Try to remove item from cart
    Given which I filtered to the "expensive" item
    When I add the first product to my cart
    And remove itens from cart and click to back shopping
    Then should return to list of items


