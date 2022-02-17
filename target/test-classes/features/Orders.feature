Feature: Orders page feature

  Background: User is Logged In
    Given browser is launched with url "http://karehealth.menpaniproducts.com/admin/auth/login" and user is on login page
    When user enters username as "admin" and password "admin"
    And clicks on login button
    Then user should view dashbaord page with title "Admin | Dashboard"

  Scenario: Verify Orders page title
    Given user is on Dashbaord page
    When user clicks on Total Orders panel
    Then user should view Orders page with title "Admin | Orders"

  Scenario: Search for customer in Orders list
    Given user is on Orders page with title "Admin | Orders"
    When user clicks on Filter button
    And selects customer as "Saran"
    And clicks on Search
    Then Order with selected customer should be listed
