package com.jira.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateIssueWindow extends BaseJiraPage{

    public CreateIssueWindow() {
        super("/jira/software/c/projects/SWIPH/boards/4");
    }

    // Locators
    private final By createIssuesButtonLocator = By.xpath("//button[@id='createGlobalItem']");
    private final By issueTypeLabel = By.id("type-picker-uid13-label");
    private final By issueTypeButton = By.id("issue-create.ui.modal.create-form.type-picker.issue-type-select");
    private final By priorityFieldLocator =By.id("priority-field");
    private final By priorityLabelLocator = By.id("priority-field-label");

    // Actions
    public void clickCreateIssuesButton() {
        driver().findElement(createIssuesButtonLocator).click();
    }

    public void waitForCreateIssuesButton() {
        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createIssuesButtonLocator));
    }

    @SneakyThrows
    public void selectIssueTypeBug () {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(issueTypeButton));
        driverWait().until(ExpectedConditions.elementToBeClickable(issueTypeButton)).click();
        WebElement priorityField = driver().findElement(issueTypeButton);
        priorityField.sendKeys("Bug" + Keys.ENTER);
        Thread.sleep(5000);
    }

    public void selectIssuePriority (String visibleText) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(priorityLabelLocator));
//        driverWait().until(ExpectedConditions.elementToBeClickable(priorityLabelLocator)).click();
        WebElement priorityField = driver().findElement(priorityFieldLocator);
        priorityField.sendKeys("High" + Keys.ENTER);
    }
}
