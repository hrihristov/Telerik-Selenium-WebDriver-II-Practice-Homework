package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProjectsPage extends BaseJiraPage{

    public ProjectsPage() {
        super("/jira/projects?selectedProjectType=software%2Cbusiness");
    }

    // Locators
    private final By projectButtonLocator = By.xpath(
            "//*[@id=\"ak-main-content\"]/span/div/div[4]/table/tbody/tr[5]/td[2]/div/a");
    private final By issuesButtonLocator = By.xpath(
            "//*[@id=\"ak-side-navigation\"]/div/div[1]/div/nav/div[2]/div/div/div/div/div[1]/div[2]/div[2]/a[3]/span/div");

    // Actions
    public void clickProjectLink() {
        driver().findElement(projectButtonLocator).click();
    }

    public void waitForProjectLink() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(projectButtonLocator));
    }

    public void clickIssuesLink() {
        driver().findElement(issuesButtonLocator).click();
    }

    public void waitForIssuesLink() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(issuesButtonLocator));
    }
}
