package com.qase.pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class IssuesPage {

    @FindBy(xpath = "//a[.='Create new defect']")
    public SelenideElement createIssueBtn;

    @FindBy(xpath = "//h1[.='Defects']")
    public SelenideElement defectsTitle;

    @FindBy(id = "title")
    public SelenideElement issueTitle;

    @FindBy(className = "ProseMirror")
    public SelenideElement issueResult;

    @FindBy(xpath = "//div[@id='severityGroup']/div[1]/div/div[1]")
    public SelenideElement IssuePrioritySelector;

    @FindBy(id = "react-select-3-option-1")
    public SelenideElement IssuePriorityNormal;

    @FindBy(xpath = "//button[.='Create defect']")
    public SelenideElement saveIssueBtn;

    @FindBy(xpath="//a[@id='defect-2-title']")
    public SelenideElement cardName;

    public void checkIssuesPage (){
        createIssueBtn.shouldBe(Condition.visible);
        defectsTitle.shouldBe (Condition.visible);
    }

    public void clickDefects (){
        defectsTitle.click();
    }

    public void setIssuePrioritySelector (){
        IssuePrioritySelector.click();
    }

    private void setIssuePriorityNormal() {
        IssuePriorityNormal.click();
    }

    public void defectsTitle (String issueName, String issueDesc){
        issueTitle.click();
        issueTitle.sendKeys(issueName);

        issueResult.click();
        issueResult.sendKeys(issueDesc);
        setIssuePrioritySelector();
        setIssuePriorityNormal();
        saveIssueBtn.click();
    }

    public void checkIssueAdded(String issueName){
        cardName.shouldBe(Condition.text(issueName));
    }

}
