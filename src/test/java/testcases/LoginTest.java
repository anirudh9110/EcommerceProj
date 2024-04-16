package testcases;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Utilities;

public class LoginTest extends Base{
	
	HomePage homepage=new HomePage();
	LoginPage loginpage=new LoginPage();
	public WebDriver driver;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email,String password){
	
		
		
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.loginOption).click();
		driver.findElement(loginpage.emailAddressField).sendKeys(email);
		driver.findElement(loginpage.passwordField).sendKeys(password);
		driver.findElement(loginpage.loginButton).click();
		Assert.assertTrue(driver.findElement(loginpage.accountinfo).isDisplayed(),"Edit Your Account Information option is not displayed");
	
	}
	
	
	public static String generateEmailWithTimeStamp() {

		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "amotoori"+timestamp+"@gmail.com";

	}
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		
		
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.loginOption).click();
		driver.findElement(loginpage.emailAddressField).sendKeys(generateEmailWithTimeStamp());
		driver.findElement(loginpage.passwordField).sendKeys("123");
		driver.findElement(loginpage.loginButton).click();
		//Warning: No match for E-Mail Address and/or Password.
		Assert.assertTrue(driver.findElement(loginpage.emailPasswordNotMatchingWarning).getText().contains("23")
				,"Expected Warning message is not displayed");
		
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {
	
		
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.loginOption).click();
		driver.findElement(loginpage.emailAddressField).sendKeys(generateEmailWithTimeStamp());
		driver.findElement(loginpage.passwordField).sendKeys("1234");
		driver.findElement(loginpage.loginButton).click();
		
		Assert.assertTrue(driver.findElement(loginpage.emailPasswordNotMatchingWarning).getText().contains("Warning: No match for E-Mail Address and/or Password.")
				,"Expected Warning message is not displayed");
	
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
		
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.loginOption).click();
		driver.findElement(loginpage.emailAddressField).sendKeys("kotaanirudh4@gmail.com");
		driver.findElement(loginpage.passwordField).sendKeys("123");
		driver.findElement(loginpage.loginButton).click();
		
		Assert.assertTrue(driver.findElement(loginpage.emailPasswordNotMatchingWarning).getText().contains("Warning: No match for E-Mail Address and/or Password.")
				,"Expected Warning message is not displayed");

	}
	
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() {
		
		HomePage homepage=new HomePage();
		LoginPage loginpage=new LoginPage();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.loginOption).click();
		driver.findElement(loginpage.loginButton).click();
		
		Assert.assertTrue(driver.findElement(loginpage.emailPasswordNotMatchingWarning).getText().contains("Warning: No match for E-Mail Address and/or Password.")
				,"Expected Warning message is not displayed");;
	
	}
	
}