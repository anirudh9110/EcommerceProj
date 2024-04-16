package testcases;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.Utilities;


public class RegisterTest extends Base {
	
	
	public RegisterTest() {
		super();
	}
	HomePage homepage=new HomePage();
	RegisterPage registerpage=new RegisterPage();
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	public static String generateEmailWithTimeStamp() {

		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "anirudh"+timestamp+"@gmail.com";
	}
	
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields()  {
		
		
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.registerOption).click();
		driver.findElement(registerpage.firstNameField).sendKeys("wegwg");
		driver.findElement(registerpage.lastNameField).sendKeys("srhrh");
		driver.findElement(registerpage.emailAddressField).sendKeys(generateEmailWithTimeStamp());
		driver.findElement(registerpage.telephoneField).sendKeys("98191");
		driver.findElement(registerpage.passwordField).sendKeys("wegwge");
		driver.findElement(registerpage.passwordConfirmField).sendKeys("wegwge");
		driver.findElement(registerpage.privacyPolicyField).click();
		driver.findElement(registerpage.continueButton).click();
		
		Assert.assertEquals(driver.findElement(registerpage.AccountCreated).getText()
				,"Your Account Has Been Created!"
				,"Account Success page is not displayed");
	
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.registerOption).click();
		driver.findElement(registerpage.firstNameField).sendKeys("wegwg");
		driver.findElement(registerpage.lastNameField).sendKeys("srhrh");
		driver.findElement(registerpage.emailAddressField).sendKeys(generateEmailWithTimeStamp());
		driver.findElement(registerpage.telephoneField).sendKeys("98191");
		driver.findElement(registerpage.passwordField).sendKeys("wegwge");
		driver.findElement(registerpage.passwordConfirmField).sendKeys("wegwge");
		driver.findElement(registerpage.yesNewsletterOption).click();
		driver.findElement(registerpage.privacyPolicyField).click();
		driver.findElement(registerpage.continueButton).click();
		Assert.assertEquals(driver.findElement(registerpage.AccountCreated).getText()
				,"Your Account Has Been Created!"
				,"Account Success page is not displayed");
	
	}
	
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
	
		
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.registerOption).click();
		driver.findElement(registerpage.firstNameField).sendKeys("wegwg");
		driver.findElement(registerpage.lastNameField).sendKeys("srhrh");
		driver.findElement(registerpage.emailAddressField).sendKeys("kotaanirudh4@gmail.com");
		driver.findElement(registerpage.telephoneField).sendKeys("98191");
		driver.findElement(registerpage.passwordField).sendKeys("wegwge");
		driver.findElement(registerpage.passwordConfirmField).sendKeys("wegwge");
		driver.findElement(registerpage.yesNewsletterOption).click();
		driver.findElement(registerpage.privacyPolicyField).click();
		driver.findElement(registerpage.continueButton).click();
		Assert.assertTrue(driver.findElement(registerpage.duplicateEmailWarning).getText().contains("Warning: E-Mail Address is already registered!")
				,"Warning message regaring duplicate email address is not displayed");
	
	}

	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		
		driver.get("https://tutorialsninja.com/demo/");
		HomePage homepage=new HomePage();
		RegisterPage registerpage=new RegisterPage();
		driver.findElement(homepage.myAccountDropMenu).click();
		driver.findElement(homepage.registerOption).click();
		driver.findElement(registerpage.continueButton).click();
		Assert.assertTrue(driver.findElement(registerpage.privacyPolicyWarning).getText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(driver.findElement(registerpage.firstNameWarning).getText().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver.findElement(registerpage.lastNameWarning).getText().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver.findElement(registerpage.emailWarning).getText().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(driver.findElement(registerpage.telephoneWarning).getText().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(driver.findElement(registerpage.passwordWarning).getText().contains("Password must be between 4 and 20 characters!"));
				
	}
	
}
