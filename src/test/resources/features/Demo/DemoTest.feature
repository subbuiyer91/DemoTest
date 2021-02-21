@Test
Feature: PlanIT Demo Assignment
 To verify mandatory fields in Contact Form and to verify user login

Scenario: Test scenario One and Two
	Given user launches the web url
	When user attempts to submit contact form without filling mandatory details and verifies error message
	Then user retries to fill the form with complete details successfully
		
		
Scenario: Test scenario Three
 	Given user launches the web url
 	When user attempts to login
 	Then user must be logged in successfully and should be able to verify the name of the looged in user
 	
 	 
	 
	