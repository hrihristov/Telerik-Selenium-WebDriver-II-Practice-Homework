package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AtlassianHome extends BaseJiraPage{
    public AtlassianHome() {
        super("/o/644f9c5c-8f29-4f9f-84e6-d32395b4760e/?cloudId=35669429-6e30-4c5e-91b9-d75a209ad087");
    }

    // Locators
    private final By jiraAppButtonLocator =
     By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[1]/div/div[2]/main/div/div[1]/div[2]/div/div/a[1]/div/div");
    public final By loginMessageLocator = By.xpath("//h1[@class='css-xtidjr']");

    // Actions
    public void clickJiraAppLink() {
        driver().findElement(jiraAppButtonLocator).click();
    }

    public void waitForProjectPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(jiraAppButtonLocator));
    }
}
