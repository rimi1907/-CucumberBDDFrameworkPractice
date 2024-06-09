#Author: Gargi Mukherjee

Feature: Home page feature

  @tag1
  Scenario: HomePageTitle
    Given user is on HomePage
    When user gets the title of the HomePage
    Then The Title of the HomePage should be "Tricentis Vehicle Insurance"

  @tag2
  Scenario: Homepage Links 
    Given user is on HomePage
    When User clicks on Automobile Link
    And user gets the Title of the NavigatedPage
    Then The title of the NavigatedPage should be "Enter Vehicle Data" 

    