package com.rahulshettyacademy.pages;

import com.rahulshettyacademy.utils.WaitUtils;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By promoCodeInput = By.cssSelector("input.promoCode");
    private final By applyPromoButton = By.cssSelector("button.promoBtn");
    private final By promoInfo = By.cssSelector("span.promoInfo");
    private final By placeOrderButton = By.xpath("//button[contains(.,'Place Order')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, Duration.ofSeconds(10));
    }

    public void applyPromoCode(String promoCode) {
        if (promoCode == null || promoCode.isBlank()) {
            return;
        }
        wait.waitForVisible(promoCodeInput).sendKeys(promoCode.trim());
        wait.waitForClickable(applyPromoButton).click();
        wait.waitForVisible(promoInfo);
    }

    public String getPromoMessage() {
        return wait.waitForVisible(promoInfo).getText();
    }

    public void placeOrder() {
        wait.waitForClickable(placeOrderButton).click();
    }
}
