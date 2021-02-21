@Test
Feature: CLSS Cross Browser Test Scenarios
  As a client
  I want to carry out subscription requests to the MPP server
  So that I can receive and validate responses from the server

Scenario Outline: Test One
	Given user launches the web url
	When user attempts submit contact form without details 
	
     Examples: 
     |status|newSubscriptionstatus|removedStatus|
     |200|201|204|
 	