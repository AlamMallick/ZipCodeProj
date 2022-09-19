@smoke
Feature: Google search functionality
  Agile Story: As a user, when I'm on google search page, I should be able to search whatever I want & see relevant info

  Scenario: User search title verification
    Given User is on Google home page
    When User searches for apple
    Then User should see apple in the title
