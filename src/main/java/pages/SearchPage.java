package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class SearchPage {
	
	
	
	
	public By validHPProduct=By.linkText("HP LP3065");
	
	public static By noProductMessage=By.xpath("//div[@id='content']/h2/following-sibling::p");
	
	
	
//	public String retrieveNoProductMessageText() {
//		
//		String noProductMessageText = noProductMessage.getText();
//		return noProductMessageText;
//	}
//	
//	public boolean displayStatusOfHPValidProduct() {
//		
//		boolean displayStatus = validHPProduct.isDisplayed();
//		return displayStatus;
//	}

}
