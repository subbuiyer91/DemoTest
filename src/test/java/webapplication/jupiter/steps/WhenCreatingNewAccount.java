package webapplication.jupiter.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webapplication.jupiter.steplib.NavigatingUser;

public class WhenCreatingNewAccount {
	
	NavigatingUser user = new NavigatingUser();

	 @Given("^user launches the web url$")
     public void userLaunchesWebURL() {
   	 user.launchWebURL(); 
	 }
	 
	 @When("^user attempts to submit contact form without filling mandatory details and verifies error message$")
     public void userAttemptsToSubmitContactFormWithoutDetails() throws Exception {
   	 user.submitContactFormWithoutDetails(); 
	 }
	 
	 @Then("^user retries to fill the form with complete details successfully$")
     public void userAttemptsToSubmitContactFormWithDetails() throws Exception {
   	 user.submitContactFormWithDetails(); 
	 }
	 

	 @When("^user attempts to login$")
     public void userAttemptsToLogin() {
   	 user.loginToJupiterPlanit(); 
	 }
	 
	 @Then("^user must be logged in successfully and should be able to verify the name of the looged in user$")
     public void userIsOnHomePage() {
   	 user.userIsOnHomepage(); 
	 }
	 
	 
}
