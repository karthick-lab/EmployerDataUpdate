package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	 private static final String DRIVER_DIR = "src/test/resources/";
	 public static WebDriver driver;
	 public static WebDriver getChromeDriver() {
	        System.setProperty("webdriver.chrome.driver", DRIVER_DIR + "chromedriver.exe");
	        driver=new ChromeDriver();
	        return driver;
	        }
}
