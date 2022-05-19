package com.qase.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    @FindBy (xpath = "//a[@href='/project/DEMO']")
    public SelenideElement profileLink;

    @FindBy (xpath = "//a[@innertext='Task11']")
    public SelenideElement task11Link;

    public void checkUserAuthorized() {
        profileLink.shouldBe(Condition.visible);
    }
    public ProjectsPage openProjects() {
        task11Link.click();
        return Selenide.page(ProjectsPage.class);
    }
}
