package jiratests.core;

import com.jira.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class JiraBaseWebTest extends BaseWebTest {
    protected AtlassianLoginPage atlassianLoginPage;
    protected AtlassianHome atlassianHome;
    protected ProjectsPage projectsPage;
    protected CreateIssueWindow createIssueWindow;

    @BeforeEach
    public void beforeTests() {
        // perform some code before each test starts
        atlassianLoginPage = new AtlassianLoginPage();
        atlassianHome = new AtlassianHome();
        projectsPage = new ProjectsPage();
        createIssueWindow = new CreateIssueWindow();


        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("jiraBaseUrl"));
    }

    // close driver
    @AfterEach
    public void afterTest() {
        driver().close();
    }

    // Extract methods that use multiple pages
    public void authenticateWithUser(String username, String pass) {
        atlassianLoginPage.submitLoginForm(username, pass);

        atlassianHome.waitForProjectPageTitle();

    }
}
