package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AtlassianLoginPage extends BaseJiraPage{
    public AtlassianLoginPage() {
        super("/login");
    }

    // Locators
    private final By usernameLocator = By.xpath("//input[@id='username']");
    private final By passwordLocator = By.xpath("//input[@id='password']");
    private final By loginButtonLocator = By.xpath("//button[@id='login-submit']");

    // Actions
    public void submitLoginForm(String username, String pass) {

//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
//        WebElement usernameInput = driver().findElement(usernameLocator);
//        usernameInput.sendKeys(username + Keys.ENTER);
//
//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
//        WebElement passwordInput = driver().findElement(passwordLocator);
//        passwordInput.sendKeys(pass);
//
//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
//        WebElement loginButton = driver().findElement(loginButtonLocator);
//        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        usernameInput.sendKeys(username);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        submitButton.click();

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordInput.sendKeys(pass);

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        submitBtn.click();
    }
}
