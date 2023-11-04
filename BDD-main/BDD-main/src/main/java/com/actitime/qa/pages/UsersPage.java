package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UsersPage extends TestBase  {


    @FindBy(xpath = "//a[@href='/ucsc13/administration/userlist.do']")
    //add your website link to "Users" tab
    @CacheLookup
    WebElement UserPage;

    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;

    @FindBy(xpath = "//div[contains(@class,'withPlusIcon')]")
    WebElement addUserBtn;

    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/ancestor::div[@class='accountInformation section accountInformationScrollPoint']")
    WebElement beforeClick;

    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/descendant::input[@name='firstName']")
    WebElement webFirstName;

    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/descendant::input[@name='lastName']")
    WebElement webLastName;

    @FindBy(xpath = "//div[@id='createUserPanel_accountInformationSection']/descendant::input[@name='email']")
    WebElement webEmail;

    @FindBy(xpath = "//div[contains(@class,'submitBtn')]")
    WebElement addBtn;

    @FindBy(xpath = "//div[@class='createUserPanel_accountCreatedContainer']/child::div[@class='invitationInfo']")
    WebElement webConfirm;

    Logger log = Logger.getLogger(UsersPage.class);

    public UsersPage() {

        PageFactory.initElements(driver, this);



    }

    public Boolean validateActiTimeLogo() {
        return actiTimeLogo.isDisplayed();

    }

    public void addUser(String firstName, String lastName, String email){
        UserPage.click();
        addUserBtn.click();
        webFirstName.sendKeys(firstName);
        webLastName.sendKeys(lastName);
        webEmail.sendKeys(email);
        addBtn.click();
    }

    public void clickedUserPage(){
        UserPage.click();
        log.info("Click add user page button in menu");
    }

    public void clickedAddUserBtn() {
        addUserBtn.click();
        log.info("Click add user button");
    }

    public void enteredFirstName(String firstName){
        log.info("driver waiting -1");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(webFirstName));
        webFirstName.click();
        webFirstName.sendKeys(firstName);
        log.info("First Name enter as "+firstName);
    }

    public void enteredLastName(String lastName){
        log.info("driver waiting -2");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        webLastName.sendKeys(lastName);
        log.info("Last Name enter as "+lastName);
    }

    public void enteredEmail(String email){
        log.info("driver waiting -3");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        webEmail.sendKeys(email);
        log.info("Email enter as "+email);
    }

    public void clickedSubmitBtn(){
        addBtn.click();
    }

    public Boolean confirmingEmail(String email){
        return webConfirm.getText().contains(email);
    }

}
