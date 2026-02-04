package com.rahulshettyacademy.pages;

import com.rahulshettyacademy.utils.WaitUtils;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private final WebDriver driver;
    private final WaitUtils wait;

    private final By countryDropdown = By.cssSelector("select");
    private final By termsCheckbox = By.cssSelector("input[type='checkbox']");
    private final By proceedButton = By.xpath("//button[contains(.,'Proceed')]");
    private final By successMessage = By.cssSelector("span[class*='green']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, Duration.ofSeconds(10));
    }

    public void selectCountry(String country) {
        Select select = new Select(wait.waitForVisible(countryDropdown));
        select.selectByVisibleText(country);
    }

    public void acceptTerms() {
        wait.waitForClickable(termsCheckbox).click();
    }

    public void proceed() {
        wait.waitForClickable(proceedButton).click();
    }

    public String getSuccessMessage() {
        return wait.waitForVisible(successMessage).getText();
    }
}
