package com.qase.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage {
    @FindBy(xpath = "//a[@href='https://app.qase.io/projects']")
    public SelenideElement projectsHeader;

    ///a[@innertext='Demo Project']

    public void checkProjectsPage() {
        projectsHeader.shouldBe(Condition.visible);
    }

}
