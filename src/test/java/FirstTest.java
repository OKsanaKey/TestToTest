import com.codeborne.selenide.Configuration;
import com.qase.pages.*;
import com.qase.pages.util.CardData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class FirstTest {

    private String cardName;
    private Object cardDescription;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        Configuration.browser="chrome";
    }

    @Test
    public void loginAsRegisteredUser() {
        LoginPage loginPage = open ("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin("bagira-56@yandex.ru");
        loginPage.enterPassword("e5wL*P3q7JqBbF6");
        DashboardPage dashboardPage = loginPage.clickBtnLogin();
        dashboardPage.checkUserAuthorized();
    }

    @Test
    public void openProjects() {
        LoginPage loginPage = open ("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin("bagira-56@yandex.ru");
        loginPage.enterPassword("e5wL*P3q7JqBbF6");
        DashboardPage dashboardPage = loginPage.clickBtnLogin();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openProjects();
        projectsPage.checkProjectsPage();
    }

    @Test
    public void createCard() {
        CardData issue = new CardData ( "test2", "test Description");
        LoginPage loginPage = open("https://app.qase.io/login", LoginPage.class);
        loginPage.enterLogin("bagira-56@yandex.ru");
        loginPage.enterPassword("e5wL*P3q7JqBbF6");
        DashboardPage dashboardPage = loginPage.clickBtnLogin();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openProjects();
        projectsPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openIssues();
        issuesPage.checkIssuesPage();
        issuesPage.clickDefects();
        issuesPage.defectsTitle(issue.getCardName(), issue.getCardDescription());
        issuesPage.checkIssueAdded(issue.getCardName());
    }

    @AfterMethod
    public void tearDown() throws Exception {
       closeWindow();
    }
}
