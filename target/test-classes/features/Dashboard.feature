 Feature: Dashboard page feature
 Scenario: View Dashboard page- Total oders panel
    Given browser is launched with url "http://karehealth.menpaniproducts.com/admin/auth/login" and user is on login page
    When user enters username as "admin" and password "admin"
    And clicks on login button
    Then user should view dashbaord page with title "Admin | Dashboard"
    And Total Orders panel should be displayed
    
    