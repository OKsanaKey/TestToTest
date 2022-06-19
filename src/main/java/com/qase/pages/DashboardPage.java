package com.qase.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    @FindBy (xpath = "//a[@href='/project/DEMO']")
    public SelenideElement profileLink;

    @FindBy (xpath = "//div[@id='application-content']/div/div/div/table/tbody/tr/td[3]/div/a")
    public SelenideElement demoLink;

    public void checkUserAuthorized() {
        profileLink.shouldBe(Condition.visible);
    }
    public ProjectsPage openProjects() {
        demoLink.click();
        return Selenide.page(ProjectsPage.class);
    }
}
