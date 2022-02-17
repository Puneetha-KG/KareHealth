Feature: Login page feature

 # Scenario: Login page title
 #   Given browser is launched with url "http://karehealth.menpaniproducts.com/admin/auth/login" and user is on login page
 #   When user gets the title of the page
 #   Then page title should be "Admin | Login"

 

  Scenario: Login with correct credentials
    Given browser is launched with url "http://karehealth.menpaniproducts.com/admin/auth/login" and user is on login page
    When user enters username as "admin" and password "admin"
    And clicks on login button
    Then user gets the title of the page
    And page title should be "Admin | Dashboard"