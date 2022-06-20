package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTest {
	
	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		MobileElement el8 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el8.click();
	    MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el9.click();
	    MobileElement el10 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el10.click();
	    MobileElement el11 = (MobileElement) driver.findElementByAccessibilityId("equals");
	    el11.click();
	    MobileElement el12 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    
	    //System.out.println(el12.getText());
	    Assert.assertEquals("4", el12.getText());
	    
	    driver.quit();
	}

}
