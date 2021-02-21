package webapplication.jupiter.ui;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webapplication.jupiter.core.Properties;


public class JupiterCloudUI {
	
	 public static WebDriver driver;
	 WebDriverWait wait;
	 Properties prop = new Properties();
	 public String welcomeMsg = "We welcome your feedback - tell it how it is.";
	 public String welcomeErrMsg = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
	 public String userName="Testuser";
	 
	 public  JupiterCloudUI() {
	        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	         wait= new WebDriverWait(driver, 30);
	        }
	    
	    By brandLogo = By.xpath("//a[@class='brand']");
	    By backBtn = By.xpath("//a[@ng-click='goBack()']");
	    By contactBtn = By.xpath("//li[@id='nav-contact']");
	    By emailField = By.xpath("//input[@id='email']");
	    By emailErrMsg = By.xpath("//span[@id='email-err']");
	    By foreNameField = By.xpath("//input[@id='forename']");
	    By forenameErrMsg = By.xpath("//span[@id='forename-err']");
	    By loginlink = By.xpath("//a[text()='Login']");
	    By loginBtn = By.xpath("//button[text()='Login']");	  
	    By logoutBtn = By.xpath("//span[text()='Logout']");
	    By messageField = By.xpath("//textarea[@id='message']");
	    By messageErrMsg = By.xpath("//span[@id='message-err']");
	    By profileName = By.xpath("//li[@id='nav-user']");
	    By surnameField = By.xpath("//input[@id='surname']");
	    By submitBtn = By.xpath("//div[@id='message-group']//..//..//a");
	    By telephoneField = By.xpath("//input[@id='telephone']");
	    By welcomeMsgLabel = By.xpath("//div[@id='header-message']//div");
	    By successMsgLabel = By.xpath("//div[@class='alert alert-success']");
	    By userNameField = By.xpath("//input[@id='loginUserName']");
	    By passwordField = By.xpath("//input[@id='loginPassword']");
	    
	 public void launchPlanitURL(){
		 driver.get(prop.getBaseUrl());
	 }

	
	public void enterContactDetails() throws Exception{  
		driver.findElement(foreNameField).sendKeys(userName);
		driver.findElement(emailField).sendKeys("Test@planit.com");
		driver.findElement(messageField).sendKeys("Test Message");
		Assert.assertFalse(isVisible(forenameErrMsg));
		Assert.assertFalse(isVisible(emailErrMsg));
		Assert.assertFalse(isVisible(messageErrMsg));
		driver.findElement(surnameField).sendKeys("Test");
		driver.findElement(telephoneField).sendKeys("12345678");
		Assert.assertTrue(driver.findElement(welcomeMsgLabel).getText().equals(welcomeMsg));
		driver.findElement(submitBtn).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(successMsgLabel));
		Assert.assertTrue(driver.findElement(successMsgLabel).getText().equals("Thanks "+userName+", we appreciate your feedback."));
		System.out.println(driver.findElement(successMsgLabel).getCssValue("color"));
		driver.findElement(backBtn).click();
		closeDriver();
		}
	
	public void validateRequiredFieldOnContactPage() throws Exception{
		driver.findElement(contactBtn).click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(submitBtn));
	     	 Assert.assertTrue(driver.findElement(welcomeMsgLabel).getText().equals(welcomeMsg));
	     	driver.findElement(submitBtn).click();
	         Assert.assertTrue(driver.findElement(forenameErrMsg).getText().equals("Forename is required"));
		    Assert.assertTrue(driver.findElement(emailErrMsg).getText().equals("Email is required"));
			Assert.assertTrue(driver.findElement(messageErrMsg).getText().equals("Message is required"));
			Assert.assertTrue(driver.findElement(welcomeMsgLabel).getText().equals(welcomeErrMsg));
			Assert.assertTrue(driver.findElement(foreNameField).getCssValue("color").equalsIgnoreCase("rgba(185, 74, 72, 1)"));
			Assert.assertTrue(driver.findElement(emailField).getCssValue("color").equalsIgnoreCase("rgba(185, 74, 72, 1)"));
			Assert.assertTrue(driver.findElement(messageField).getCssValue("color").equalsIgnoreCase("rgba(185, 74, 72, 1)"));
			
					
	}
	
	public void loginToPlanIT(){
		driver.findElement(loginlink).click();
		driver.findElement(userNameField).sendKeys(userName);
		driver.findElement(passwordField).sendKeys("letmein");
		driver.findElement(loginBtn).click();
		
	}
	
	public void verifyUserIsHomePage(){
		Assert.assertTrue(driver.findElement(profileName).getText().equalsIgnoreCase(userName));
		Assert.assertTrue(isVisible(logoutBtn));
		closeDriver();
		
	}
	public boolean isVisible(By locatorKey) {
	    try {
	    	driver.findElement(locatorKey);
	        return true;
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}

	public void closeDriver(){
		driver.quit();
	}

	
}
