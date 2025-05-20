@wiki
  Feature:script for wikipedia

@wiki
Scenario: Wikipedia Script For Homework
  Given I open url "https://www.wikipedia.org/"
  Then I should see page title as "Wikipedia"
  Then element with xpath "//input[@id='searchInput']" should be present
  When I type "The Great Emu War" into element with xpath "//input[@id='searchInput']"
  Then I click on element using JavaScript with xpath "//button[@class='pure-button pure-button-primary-progressive']"
  Then element with xpath "//main[@id='content']" should contain text "The Great Emu War"
  Then I wait for 5 sec


