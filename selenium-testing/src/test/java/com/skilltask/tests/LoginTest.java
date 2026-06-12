package com.skilltask.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void managerLogin() {
        login("manager@demo.com", "password123");
        wait.until(ExpectedConditions.urlContains("/manager"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/manager"));
    }

    @Test
    public void employeeLogin() {
        login("alice@demo.com", "password123");
        wait.until(ExpectedConditions.urlContains("/employee"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/employee"));
    }

    @Test
    public void invalidLogin() {
        login("manager@demo.com", "wrongpass");
        String error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".form-error-banner"))).getText();
        Assert.assertTrue(error.toLowerCase().contains("invalid"));
    }
}
