Feature: Login page


  Background: Login with valid Credentials
    Given : User Launch the browser
    When : User opens the Url "https://www.facebook.com"
    And : User enters email as "9063137748" and Password "mani123@"
    And : Click on login
    Then : verify the facebook home page
        
    

    Scenario: faceBook chat functionality
    And :click on messenger Icon
    Then :click on inbox and get data from the inbox
    Then : Verify the messenger page
   

  Scenario: Group chat functionality
    And : click on group button
    When :click on create new btn
    Then : user enter group name as"Kairos" and choose privacy
    And : click on create btn
    And :close browser
    