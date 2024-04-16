package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	
	public By firstNameField=By.id("input-firstname");
	
	public By lastNameField=By.id("input-lastname");
	
	public By emailAddressField=By.id("input-email");
	
	public By telephoneField=By.id("input-telephone");
	
	public By passwordField=By.id("input-password");

	public By passwordConfirmField=By.id("input-confirm");
	
	public By privacyPolicyField=By.name("agree");
	
	public By continueButton=By.xpath("//input[@value='Continue']");
	
	public By yesNewsletterOption=By.xpath("//input[@name='newsletter'][@value='1']");
	
	public By duplicateEmailAddressWarning=By.xpath("//div[contains(@class,'alert-dismissible')]");
	
	public By privacyPolicyWarning=By.xpath("//div[contains(@class,'alert-dismissible')]");
	
	public By firstNameWarning=By.xpath("//input[@id='input-firstname']/following-sibling::div");
	
	public By lastNameWarning=By.xpath("//input[@id='input-lastname']/following-sibling::div");
	
	public By emailWarning=By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]");
	
	public By telephoneWarning=By.xpath("//input[@id='input-telephone']/following-sibling::div");
	
	public By passwordWarning=By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div");
	
	public By AccountCreated=By.xpath("//*[@id=\"content\"]/h1");
	
	public By duplicateEmailWarning=By.xpath("//*[@id=\"account-register\"]/div[1]");

	
	
	
	
}
