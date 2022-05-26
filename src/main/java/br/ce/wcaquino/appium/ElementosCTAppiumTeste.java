package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ElementosCTAppiumTeste {
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Git_Automacao\\CursoAppium\\evidencias\\appTreinamento\\CTAppium_2_0.apk");
        
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//passos
		//entrar no Formulario
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		for (MobileElement elemento: elementosEncontrados) {
			System.out.println(elemento.getText());
		}
		
		elementosEncontrados.get(1).click();

		//escrever "nome" e
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));//.sendKeys("Ricardo Couto");
		campoNome.sendKeys("Ricardo Couto");
		
		//verificar o nome
		String text = campoNome.getText();
		Assert.assertEquals("Ricardo Couto", text);
		
	    driver.quit();
	}

	@Test
	public void deveIntegarirCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Git_Automacao\\CursoAppium\\evidencias\\appTreinamento\\CTAppium_2_0.apk");
        
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//passos
		//entrar no Formulario XPath
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//selecionar a opcao
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//verificar a opcao
		String textCombo = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		System.out.println(textCombo);
		Assert.assertEquals("Nintendo Switch", textCombo);
		
	    driver.quit();
	}
	
	@Test
	public void deveIntegarirSwitchCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Git_Automacao\\CursoAppium\\evidencias\\appTreinamento\\CTAppium_2_0.apk");
        
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//passos
		//entrar no Formulario XPath
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//verificar o status do elemento
		MobileElement elCheck = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement elSwitch = driver.findElement(MobileBy.AccessibilityId("switch"));
		
		Assert.assertTrue(elCheck.getAttribute("checked").equals("false"));
		Assert.assertTrue(elSwitch.getAttribute("checked").equals("true"));
		
		//clicar nos elementos
		elCheck.click();
		elSwitch.click();
		
		//verificar estados alterados
		Assert.assertFalse(elCheck.getAttribute("checked").equals("false")); //poderia mudar somente de false -> true
		Assert.assertFalse(elSwitch.getAttribute("checked").equals("true")); //poderia mudar somente de true -> false
		
	    driver.quit();
	}
}
