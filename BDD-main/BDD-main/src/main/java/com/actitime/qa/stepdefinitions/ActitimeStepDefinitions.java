package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActitimeStepDefinitions extends TestBase {
	
	
	LoginPage loginPage;
	UsersPage usersPage;
	HomePage homePage;
	String sheetName = "Users";
	TestUtil testUtil;

	
	@Given("^User in the Actitime Loging Page$")
	public void user_in_the_Actitime_Loging_Page() throws Throwable {
	    
		initialization();
		loginPage = new LoginPage();
	}

	@When("^User Enter the User Name as  \"([^\"]*)\"$")
	public void user_Enter_the_User_Name_as(String userName) throws Throwable {
		loginPage.enterUserName(userName);
	}

	@Then("^User Enter the Password as  \"([^\"]*)\"$")
	public void user_Enter_the_Password_as(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@Then("^User click in Loging button$")
	public void user_click_in_Loging_button() throws Throwable {
		homePage =loginPage.clickSubmitButton();
	}

	@Then("^User should be able to successfuly loging to Actitime$")
	public void user_should_be_able_to_successfuly_loging_to_Actitime() throws Throwable {
	    
		homePage.validateActiTimeLogo();
		driver.quit();
		
	}


	@Given("^Admin user log into actiTime application and enter \"([^\"]*)\" and \"([^\"]*)\" and go to Users Page$")
	public void user_loginto_app_entering_credintials_and_gto_users_page(String username, String password) throws Throwable{
		initialization();
		loginPage = new LoginPage();
		loginPage.loging(username,password);
		usersPage = new UsersPage();
		usersPage.clickedUserPage();
	}

	@When("^Admin user click on New User button$")
	public void user_clicked_in_new_user_button() throws Throwable {
		usersPage.clickedAddUserBtn();
	}

	@Then("^Admin user enter the First Name as \"([^\"]*)\"$")
	public void user_entered_first_name_as(String firstName) throws Throwable{
		usersPage.enteredFirstName(firstName);
	}

	@Then("^Admin user enter the Last Name as \"([^\"]*)\"$")
	public void user_entered_last_name_as(String lastName) throws Throwable{
		usersPage.enteredLastName(lastName);
	}

	@Then("^Admin user enter the Email as \"([^\"]*)\"$")
	public void user_entered_email_as(String email) throws Throwable{
		usersPage.enteredEmail(email);
	}

	@Then("^Admin user click on Save button$")
	public void user_clicked_in_save_button() throws Throwable{
		usersPage.clickedSubmitBtn();
	}

	@Then("^Admin User should be able to successfully add a new user with email as \"([^\"]*)\"$")
	public void user_should_be_able_to_successfully_add_a_new_user(String email) throws Throwable{
		usersPage.confirmingEmail(email);

	}


}
