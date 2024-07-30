@remoteview
Feature: View remote rig computer

#  @roman1
#  Scenario: xxx
#    Given I navigate to the Chrome Remote View Page
#    When I enter login "roman@sbdirectionalservices.com"
#    And I wait for 1 seconds
#    When I click on NEXT button in modal
#    And I wait for 1 seconds
#    When I enter password "sbdirectional"
#    And I wait for 1 seconds
#    When I click on NEXTtwo button in modal
#    And I wait for 2 seconds
#    Then I click on CactusTotco button in modal
#    And I wait for 2 seconds
#    Then I enter pin "1234567"
#    And I wait for 2 seconds
#  Then I click on right arrow button
#    And I wait for 20 seconds

  @roman2
  Scenario: Job Search
    Given I navigate to the OKC Job Match
    Then I click on login
    When I enter login "Roman4331" and password "27022011Kira!"
    And I wait for 1 seconds
    When I click on Log In button in modal
    And I wait for 20 seconds
    Then I fill out search menu with keywords "Quality assurance engineer", "OKC", 50
    And I wait for 2 seconds
  Then I click on job search
    And I wait for 1200 seconds
#    When I enter password "sbdirectional"
#    And I wait for 1 seconds
#    When I click on NEXTtwo button in modal
#    And I wait for 2 seconds
#    Then I click on CactusTotco button in modal
#    And I wait for 2 seconds
#    Then I enter pin "1234567"
#    And I wait for 2 seconds
#    Then I click on right arrow button
#    And I wait for 20 seconds

#    And I wait for 1 seconds
#    When I click on next button in modal
#    And I wait for 2 seconds
#    Then I should see a registration confirmation