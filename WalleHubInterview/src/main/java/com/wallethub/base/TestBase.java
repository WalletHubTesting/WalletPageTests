package com.wallethub.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {   
	
	public static WebDriver driver;
	public static Properties prop;
	
	public  TestBase() {
		try {
			prop = new Properties();
			String filePath = System.getProperty("user.dir");
			String absolutePath = filePath + "\\src\\main\\java\\com\\wallethub\\config\\config.properties";
			//System.out.println(filePath);
			FileInputStream ip = new FileInputStream(absolutePath);
			
			prop.load(ip);
			// System.out.println(prop.getProperty("browser"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
		
	
	public WebDriver getDriver() {

		return driver;

	}
	
	
	
	public static void initilization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			/*String filePath = System.getProperty("user.dir");
			String absolutePath = filePath + "\\chromedriver_win32\\chromedriver.exe";
			System.out.println(filePath);
			System.setProperty("webdriver.chrome.driver", absolutePath);
			driver = new ChromeDriver();*/
			WebDriverManager.getInstance(CHROME).setup();
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("fireFox"))
		{
			WebDriverManager.getInstance(FIREFOX).setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("signUpUrl"));
		
		
	}
	// use with properties file
	
	
	
		
	
	
}
