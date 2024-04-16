package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	//Objects
	
	public By myAccountDropMenu=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
	
	
	public By loginOption=By.linkText("Login");
	
	public By registerOption=By.linkText("Register");
	
	
	public By searchBoxField=By.name("search");
	
	
	public By searchButton=By.xpath("//div[@id='search']/descendant::button");
	
	
	
	
	

	
	
}