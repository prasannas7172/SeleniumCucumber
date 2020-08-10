package com.Trip.utlity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
 
    //initialize webdriver
    private static WebDriver driver;
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    private  SeleniumDriver(String browser) {
    	
    	if(browser.equalsIgnoreCase("Chrome")) {
    		System.err.println(System.getProperty("user.dir"));
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--disable-notifications");	
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//"+"chromedriver.exe");
    		driver = new ChromeDriver(options);	
		 }else if (browser.equalsIgnoreCase("Firefox")) {
			  System.err.println(System.getProperty("user.dir"));
			  System.setProperty("webdriver.gecko.driver",
			  System.getProperty("user.dir")+"//"+"geckodriver.exe"); 
			  driver = new FirefoxDriver();
			}
    	
			 
			 
        driver.manage().window().maximize();

        waitDriver = new WebDriverWait(driver, TIMEOUT);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window=driver.getWindowHandle();
        System.out.println("Window ->"+window);
       
    }

    public static void openPage(String url) {
    	System.out.println(url);
    	System.out.println(driver);
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver(String browser) {
       if (seleniumDriver == null) {
    	   if(browser.equalsIgnoreCase("Chrome")){
    		   seleniumDriver = new SeleniumDriver("Chrome");
    	   }
    	   else if(browser.equalsIgnoreCase("Firefox"))
    		   seleniumDriver = new SeleniumDriver("Firefox");
    	   }
       }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

