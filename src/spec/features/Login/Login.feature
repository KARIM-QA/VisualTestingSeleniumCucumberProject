Feature: Login interface

  Scenario Outline: Login Data Driven
    Given Open Browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "<email>" and Password as "<password>"
    And Click on Login
    When User click on Logout link
    And Close  browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
