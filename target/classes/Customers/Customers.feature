Feature: Customers

  Scenario: Validation Add Customers
    Given Open Browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashbord
    When User click on Customers Menu
    And Click on Customers Menu Item
    And Click on add new button
    Then User can view add new Customer Page
    When User enter Customer info
    And Click on save button
    Then User can view confirmation message "the new customer hass been added successfully."
    When User click on Logout link
    Then Close  browser

    