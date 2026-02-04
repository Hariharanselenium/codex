package com.rahulshettyacademy.pages;

import com.rahulshettyacademy.utils.WaitUtils;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static final String BASE_URL = "https://rahulshettyacademy.com/seleniumPractise/#/";

    private final WebDriver driver;
    private final WaitUtils wait;

    private final By searchInput = By.cssSelector("input.search-keyword");
    private final By productName = By.cssSelector("h4.product-name");
    private final By addToCartButton = By.cssSelector("button.search-button + button");
    private final By cartIcon = By.cssSelector("a.cart-icon");
    private final By proceedToCheckoutButton = By.cssSelector("div.cart-preview.active button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get(BASE_URL);
        wait.waitForUrlContains("seleniumPractise");
    }

    public void searchForProduct(String product) {
        WebElement input = wait.waitForVisible(searchInput);
        input.clear();
        input.sendKeys(product);
        wait.waitForText(productName, product);
    }

    public String getFirstProductName() {
        return wait.waitForVisible(productName).getText();
    }

    public void addFirstProductToCart() {
        wait.waitForClickable(addToCartButton).click();
    }

    public void openCartPreview() {
        wait.waitForClickable(cartIcon).click();
    }

    public void proceedToCheckout() {
        wait.waitForClickable(proceedToCheckoutButton).click();
    }
}
