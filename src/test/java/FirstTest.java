import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.closeWindow;

class FirstTest {

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        Configuration.browser="chrome";
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        open ("https://app.qase.io/login");
        $(UIMap.login).click();
        $(UIMap.login).clear();
        $(UIMap.login).sendKeys("bagira-56@yandex.ru");
        $(UIMap.password).click();
        $(UIMap.password).clear();
        $(UIMap.password).sendKeys("e5wL*P3q7JqBbF6");
        $(UIMap.loginBtn).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
       closeWindow();
    }
}
