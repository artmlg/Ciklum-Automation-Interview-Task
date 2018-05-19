package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WrestlerTabPage extends BasePage {
    public WrestlerTabPage(WebDriver driver) {
        super(driver);
    }

    //New Wrestler | Input Fields
    @FindBy(xpath = ".//*[@placeholder='First name']")
    private WebElement fName;

    @FindBy(xpath = ".//*[@placeholder='Last name']")
    private WebElement lName;

    @FindBy(xpath = ".//*[@placeholder='Middle name']")
    private WebElement mName;

    @FindBy(xpath = ".//*[@placeholder='Date of Birth']")
    private WebElement dOfBirth;

    @FindBy(xpath = ".//*[@label='Trainer' and @value='wr.trainer1']//input")
    private WebElement trainerFirstField;

    @FindBy(xpath = ".//*[@label='Trainer' and @value='wr.trainer2']//input")
    private WebElement trainerSecondField;

    //New Wrestler | Dropdown's
    @FindBy(xpath = ".//*[@label='Region' and @value='wr.region1']//select")
    private WebElement regionFirstDropdown;

    @FindBy(xpath = ".//*[@label='Region' and @value='wr.region2']//select")
    private WebElement regionSecondDropdown;

    @FindBy(xpath = ".//*[@label='FST' and @value='wr.fst1']//select")
    private WebElement fstFirst;

    @FindBy(xpath = ".//*[@label='FST' and @value='wr.fst2']//select")
    private WebElement fstSecond;

    @FindBy(xpath = ".//*[@label='Style']//select")
    private WebElement style;

    @FindBy(xpath = ".//*[@label='Age']//select")
    private WebElement ageField;

    @FindBy(xpath = ".//*[@label='Year']//select")
    private WebElement yearField;

    @FindBy(xpath = ".//*[@label='Status']//select")
    private WebElement statusField;

    @FindBy(xpath = ".//button[@class='btn btn-lg btn-success']")
    private WebElement acceptBtn;

    public void addFirstName(String fName) {
        clearAndType(this.fName, fName);
    }

    public void addMiddleName(String mName) {
        clearAndType(this.mName, mName);
    }

    public void addLastName(String lName) {
        clearAndType(this.lName, lName);
    }

    public void addDateOfBirth(String dOfBirth) {
        clearAndType(this.dOfBirth, dOfBirth);
    }

    public void addFirstTrainer(String firstTrainer) {
        clearAndType(trainerFirstField, firstTrainer);
    }

    public void addSecondTrainer(String secondTrainer) {
        clearAndType(trainerSecondField, secondTrainer);
    }

    public void selectFromFristRegion(String firstRegion) {
        selectFromDropDownByVisibleText(regionFirstDropdown, firstRegion);
    }

    public void selectFromSecondRegion(String secondRegion) {
        selectFromDropDownByVisibleText(regionSecondDropdown, secondRegion);
    }

    public void selectFromFristFST(String firstFST) {
        selectFromDropDownByVisibleText(fstFirst, firstFST);
    }

    public void selectFromSecondFST(String secondFST) {
        selectFromDropDownByVisibleText(fstSecond, secondFST);
    }

    public void selectFromStyle(String style) {
        selectFromDropDownByVisibleText(this.style, style);
    }

    public void selectFromYear(String year) {
        selectFromDropDownByVisibleText(yearField, year);
    }

    public void selectFromStatus(String status) {
        selectFromDropDownByVisibleText(statusField, status);
    }

    public void selectFromAge(String age) {
        selectFromDropDownByVisibleText(ageField, age);
    }

    private void selectFromDropDownByVisibleText(WebElement webElement, String selectByText) {
        LOG.info("Select from DropDown Element: " + webElement.getTagName() + ", with text: " + webElement.getText());
        Select select = new Select(webElement);
        waitForElementDisplayed(webElement);
        select.selectByVisibleText(selectByText);
    }

    public void clickAcceptNewWrestler() {
        clickBtn(acceptBtn);
    }
}