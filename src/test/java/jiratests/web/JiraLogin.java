package jiratests.web;

import jiratests.core.JiraBaseWebTest;
import jiratests.enums.JiraTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class JiraLogin extends JiraBaseWebTest {

    public static final String EXPECTED_STRING = "G'day, Hristo Hristov";

    private final By loginMessageLocator = By.xpath("//h1[@class='css-xtidjr']");

    @Test
    public void userAuthenticated_when_validCredentialsProvided(){

        atlassianLoginPage.submitLoginForm(JiraTestData.USER_USERNAME.getValue(),
                JiraTestData.USER_PASSWORD.getValue());

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(loginMessageLocator));
        String loginMessage = driver().findElement(atlassianHome.loginMessageLocator).getText();
        Assertions.assertEquals(EXPECTED_STRING, loginMessage);
    }
}
