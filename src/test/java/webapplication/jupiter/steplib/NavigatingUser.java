package webapplication.jupiter.steplib;


import webapplication.jupiter.ui.JupiterCloudUI;


public class NavigatingUser{
	
	JupiterCloudUI uiObj = new JupiterCloudUI();
	
	public void launchWebURL(){
		uiObj.launchPlanitURL();
	}
	
	public void submitContactFormWithoutDetails() throws Exception{
		uiObj.validateRequiredFieldOnContactPage();
	}
	
	public void submitContactFormWithDetails() throws Exception{
		uiObj.enterContactDetails();
	}
	
	public void loginToJupiterPlanit(){
		uiObj.loginToPlanIT();
	}
	
	public void userIsOnHomepage(){
		uiObj.verifyUserIsHomePage();
	}
}
