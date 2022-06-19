package com.qase.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class ProjectDashboardPage {

    @FindBy(xpath = "//h1[.='Project']")
    public SelenideElement projectOverview;

    @FindBy(xpath = "//span[@class='icon-issues-icon']")
    public SelenideElement issuesLink;

    public void checkProjectDashboardPage () {
        projectOverview.shouldBe(Condition.visible);
    }
    public IssuesPage openIssues () {
        issuesLink.click();
        return page (IssuesPage.class);
    }

}
