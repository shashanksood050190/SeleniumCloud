package com.mytests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestK8s {
	
	
	WebDriver driver;

	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browserName,  Method name) {

		System.out.println("browser name is : " + browserName);
		String methodName = name.getName();
		
		String remoteURL = "http://" + "shashankautomation" + ":" + "Zalenium2020" + "@" + "104.155.173.26" + "/wd/hub";
		System.out.println("Zalenium hub url is: "+remoteURL);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("name", methodName);
		cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		cap.setCapability("build", 111.11);
		cap.setCapability("idleTimeout", 180);
		cap.setCapability("recordVideo", true);
		cap.setCapability("tz", "Asia/Kolkata");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		}
		try {
			driver = new RemoteWebDriver(new URL(remoteURL), cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	
	

}