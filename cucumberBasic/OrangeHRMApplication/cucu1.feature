Feature: OrangeHRM Application Functionalities Testing
Background:
	Given User Should Launch the Chrome Browser 
	@Ram
	Scenario: Validating OrangeHRM Application LoIn Page
	
	#Given User Should Launch the Chrome Browser 
	When User Enters OrangeHRM Application URL Address
	Then User Should be at the LogIn Page
	Then User should Close the Application
	
	
	@Ram @Babu
Scenario: Validating OrangeHRM Application LogIn Functionality

	#Given User Should Launch the Chrome Browser 
	When User Enters OrangeHRM Application URL Address
	Then User Should be at the LogIn Page
	When User enters UserName and Password and click on LogIn button
	Then User should be navigated to HomePage of OrangeHRM Application
	Then User should Close the Application
	
	@ApplicationFunctionalityWithTestData
	Scenario Outline: Validating OrangeHRM Application LogIn Functionality with Multiple data
	#Given User Should Launch the Chrome Browser 
	When User Enters OrangeHRM Application URL Address
	Then User Should be at the LogIn Page
	When User enters "<UserName>" and "<Password>" and click on LogIn button
	Then User should be navigated to HomePage of OrangeHRM Application
	Then User should Close the Application
	
	Examples:
|	UserName | Password |
	|	Rambabu	|	Oran$970 |
	|	Rambabu	|	Oran$970 |
	| Rambabu | Oran$970 |
		
	
	
	
	