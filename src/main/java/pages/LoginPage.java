package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	
	
	public By emailAddressField=By.id("input-email");
	
	public By passwordField=By.id("input-password");
	
	
	public By loginButton=By.xpath("//input[@value='Login']");
	
	
	public By emailPasswordNotMatchingWarning=By.xpath("//div[contains(@class,'alert-dismissible')]");
	
	public By accountinfo=By.linkText("Edit your account information");	
	
	

}