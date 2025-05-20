@quote
Feature: Quote

  @quote1
  Scenario Outline: (Smoke Test) Fill out the Required Fields of Quote and arrive on the Confirmation Page
    Given I visit Quote Page in the <env> Environment
    When I enter <userName> for the Username field
    And I enter <firstName> for first name and <lastName> for the last name in the Name field
    And I enter <email> for the Email field
    When I enter <password> for the Password field
    And I enter <password> for the Confirm Password field
    Then I <status> the Privacy Policy Policy checkbox
    When I click on the <button> button at the bottom of the page
#    Then I verify we see the Submitted Application Page
#    Then I verify username is <userName>, first name is <firstName>, last name is <lastName>, email is <email>
    Examples:
      | env  | userName   | firstName | lastName | email           | password | status  | button |
      | "QA" | "Scorpion" | "Hanzo"   | "Hashashi"    | "test@test.com" | "123456" | "check" | "Submit" |
      | "QA" | "SubZero" | "Kuai"   | "Liang"    | "test@test.com" | "123456" | "check" | "Submit" |
      | "QA" | "Raiden" | "Raiden"   | "D"    | "test@test.com" | "123456" | "check" | "Submit" |
      | "QA" | "ShaoKhan" | "Shao"   | "Khan"    | "test@test.com" | "123456" | "check" | "Submit" |

  @quote2
  Scenario: Quote smoke test oop
    Given I navigate to "quote" page
    When I fill out the required fields on the form oop
    And I wait for 2 sec
    And I submit the quote form oop
    And I wait for 2 sec
    Then I see required fields submitted successfully oop

  @quote3
  Scenario: Quote smoke test
    Given I navigate to "quote" page
    When I fill out the required fields on the form
    And I wait for 1 sec
    And I submit the quote form
    Then I see page title contains "Submitted Application"
    Then I verify required fields submitted sucessully with AssertJ library
    Then I verify required fields submitted in a lazy way with resultbox