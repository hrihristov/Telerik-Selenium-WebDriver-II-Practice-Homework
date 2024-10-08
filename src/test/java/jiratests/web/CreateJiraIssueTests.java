package jiratests.web;

import jiratests.core.JiraBaseWebTest;
import jiratests.enums.JiraTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import saucedemotests.enums.TestData;

public class CreateJiraIssueTests extends JiraBaseWebTest {

    @BeforeEach
    public void beforeTest(){
        atlassianLoginPage.submitLoginForm(JiraTestData.USER_USERNAME.getValue(), JiraTestData.USER_PASSWORD.getValue());
    }

    @Test
    public void storyCreatedInJira() {

        atlassianHome.waitForProjectPageTitle();

        atlassianHome.clickJiraAppLink();

        projectsPage.waitForProjectLink();

        projectsPage.clickProjectLink();

//        projectsPage.waitForIssuesLink();
//
//        projectsPage.clickIssuesLink();

        createIssueWindow.clickCreateIssuesButton();

        createIssueWindow.selectIssueTypeBug();

        createIssueWindow.selectIssuePriority("High");

    }

    @Test
    public void bugCreatedInJira() {

        atlassianHome.waitForProjectPageTitle();

        atlassianHome.clickJiraAppLink();

        projectsPage.waitForProjectLink();

        projectsPage.clickProjectLink();

        projectsPage.waitForIssuesLink();

        projectsPage.clickIssuesLink();

        createIssueWindow.clickCreateIssuesButton();

//        createIssueWindow.selectIssueType("Bug");

    }
}
