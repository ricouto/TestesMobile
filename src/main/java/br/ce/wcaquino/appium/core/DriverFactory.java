package br.ce.wcaquino.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
			//createSauceLabsDriver();
		}
		return driver;
	}

	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Git_Automacao\\CursoAppium\\evidencias\\appTreinamento\\CTAppium_1_2.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	private static void createSauceLabsDriver() {
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName","Android");
		caps.setCapability("appium:deviceName","Android GoogleAPI Emulator");
		caps.setCapability("appium:deviceOrientation", "portrait");
		caps.setCapability("appium:platformVersion","7.0");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:app", "storage:filename=CTAppium_1_2.apk");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("build", "oauth-qualidadevia2022-44603");
		sauceOptions.setCapability("name", "c31abe53-f2e8-415c-b21b-3aee75319a07");
		caps.setCapability("sauce:options", sauceOptions);

		try {
			driver = new AndroidDriver<MobileElement>(new URL("https://oauth-qualidadevia2022-44603:c31abe53-f2e8-415c-b21b-3aee75319a07@ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
