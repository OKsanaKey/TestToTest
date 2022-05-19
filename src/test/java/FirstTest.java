import com.codeborne.selenide.Configuration;
import com.qase.pages.DashboardPage;
import com.qase.pages.LoginPage;
import com.qase.pages.ProjectsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWindow;

public class FirstTest {

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

    @AfterMethod
    public void tearDown() throws Exception {
       closeWindow();
    }
}
