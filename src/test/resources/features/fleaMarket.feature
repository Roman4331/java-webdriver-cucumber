@flea
Feature: Automate Flea Market E2E Flow (or Checkout)

  @flea1
  Scenario: Checkout Flow
    Given I navigate to fleaMarket Page
    Then I verify title of the page is "e-commerce – Automation Practice Website"
    When I add "iMac" from the Landing Page
    And I click the View Cart button from the Landing Page
    Then I verify title of the page is "Cart – e-commerce"
    When I click Proceed to checkout from the cart page
    Then I verify title of the page is "Checkout – e-commerce"
    When I fill out all the required information at checkout
    And I click Place Order button
    Then I verify I landed on Order Received page
    Then I verify that "iMac" appears in my order details


  @flea2
  Scenario Outline: Checkout Flow Outline
    Given I navigate to fleaMarket Page
    Then I verify title of the page is "e-commerce – Automation Practice Website"
    When I add <product> from the Landing Page
    And I click the View Cart button from the Landing Page
    Then I verify title of the page is "Cart – e-commerce"
    When I click Proceed to checkout from the cart page
    Then I verify title of the page is "Checkout – e-commerce"
    When I fill out all the required information at checkout
    And I click Place Order button
    Then I verify I landed on Order Received page
    Then I verify that <product> appears in my order details
    Examples:
      | product |
      | "AirPods Pro"  |
      | "Apple Watch Series 6"  |
      | "iMac"  |
      | "IPhone XR"  |
      | "Macbook Air"  |





#//rrrrr
#Checkout Flow/Confirmation
#Add an Item from Landing Page
#Go to Cart page and verify that you are there
#Click Proceed to Checkout
#Fill out the Checkout page and Click Place Order
#Verify the Confirmation Page and all of the information there
#Do this for EACH Item
