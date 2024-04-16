package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.SearchPage;

//Updated Comment - Added more details

public class SearchTest extends Base {
	
	public SearchTest() {
		super();
	}
	
	HomePage homepage=new HomePage();
	SearchPage searchpage=new SearchPage();
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		
		driver.findElement(homepage.searchBoxField).sendKeys("HP");
		driver.findElement(homepage.searchButton).click();
		Assert.assertTrue(driver.findElement(searchpage.validHPProduct).isDisplayed(),"Valid product HP is not displayed in the search results");
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		
		driver.findElement(homepage.searchBoxField).sendKeys("Honda");
		driver.findElement(homepage.searchButton).click();
		Assert.assertEquals(driver.findElement(searchpage.noProductMessage).getText(),"There is no product that matches the search criteria."
				,"No product message in search results is not displayed");
		
	}
	
	@Test(priority=3)
	public void verifySearchWithoutAnyProduct() {
		
		
		driver.findElement(homepage.searchButton).click();
		Assert.assertEquals(driver.findElement(searchpage.noProductMessage).getText(),"There is no product that matches the search criteria."
				,"No product message in search results is not displayed");
		
	}
	
}
