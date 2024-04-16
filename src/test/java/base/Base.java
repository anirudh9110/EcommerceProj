package base;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utilities;

public class Base {

	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static Properties prop;

	public Base() {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");


		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
		}
	}

	@Parameters("browserName")
	public static WebDriver initializeBrowserAndOpenApplicationURL( String browserName) 
	{

		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver","C:\\Users\\kotaa\\eclipse-workspace\\java web driver\\drivers\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			options.setBinary("C:\\Users\\kotaa\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
			driver=new ChromeDriver(options);

		}
		else if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.firefox.marionette", "C:\\Users\\kotaa\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		else if(browserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", "C:\\Users\\kotaa\\eclipse-workspace\\java web driver\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		return driver;

	}



	


}

