package com.qase.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.page;

public class ProjectsPage {
    @FindBy(xpath = "//a[@href='https://app.qase.io/projects/DEMO']")
    public SelenideElement projectsHeader;

    @FindBy(xpath = "//a[@class='defect-title']")
    public SelenideElement projectsName;

    public void checkProjectsPage() {
        projectsHeader.shouldBe(Condition.visible);
    }
    
    public ProjectDashboardPage openProject () {
        projectsName.click();
        return page (ProjectDashboardPage.class);
    }

}
