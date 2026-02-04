package com.rahulshettyacademy.steps;

import com.rahulshettyacademy.core.DriverFactory;
import com.rahulshettyacademy.pages.CartPage;
import com.rahulshettyacademy.pages.CheckoutPage;
import com.rahulshettyacademy.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrderSteps {
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @io.cucumber.java.Before
    public void initPages() {
        this.homePage = new HomePage(DriverFactory.getDriver());
        this.cartPage = new CartPage(DriverFactory.getDriver());
        this.checkoutPage = new CheckoutPage(DriverFactory.getDriver());
    }

    @Given("the user is on the GreenKart home page")
    public void openHomePage() {
        homePage.open();
    }

    @When("the user searches for product {string}")
    public void searchForProduct(String product) {
        homePage.searchForProduct(product);
        Assert.assertTrue(homePage.getFirstProductName().toLowerCase().contains(product.toLowerCase()),
                "Expected product to be visible after search.");
    }

    @And("adds the product to the cart")
    public void addProductToCart() {
        homePage.addFirstProductToCart();
    }

    @And("proceeds to the cart")
    public void proceedToCart() {
        homePage.openCartPreview();
        homePage.proceedToCheckout();
    }

    @And("applies promo code {string}")
    public void applyPromoCode(String promoCode) {
        cartPage.applyPromoCode(promoCode);
    }

    @And("places the order")
    public void placeOrder() {
        cartPage.placeOrder();
    }

    @And("selects country {string} and accepts terms")
    public void selectCountryAndAcceptTerms(String country) {
        checkoutPage.selectCountry(country);
        checkoutPage.acceptTerms();
        checkoutPage.proceed();
    }

    @Then("the order should be placed successfully")
    public void verifyOrderPlaced() {
        String message = checkoutPage.getSuccessMessage();
        Assert.assertTrue(message.toLowerCase().contains("thank you"),
                "Expected success message to confirm order placement.");
    }
}
