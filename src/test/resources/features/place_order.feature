Feature: Place an order on GreenKart
  As a shopper
  I want to place an order for vegetables
  So that I can complete a purchase successfully

  Scenario: Place order for a searched product
    Given the user is on the GreenKart home page
    When the user searches for product "Brocolli"
    And adds the product to the cart
    And proceeds to the cart
    And applies promo code "rahulshettyacademy"
    And places the order
    And selects country "India" and accepts terms
    Then the order should be placed successfully
