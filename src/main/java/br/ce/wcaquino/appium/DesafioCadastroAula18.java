package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesafioCadastroAula18 {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Before
	public void setUp() throws Exception {
		
		// 1 - DesiredCapabilities
		DesiredCapabilities dsCapabilities = new DesiredCapabilities();
		dsCapabilities.setCapability("platformName", "Android");
		dsCapabilities.setCapability("deviceName", "emulator-5554");
		dsCapabilities.setCapability("automationName", "uiautomator2");
		dsCapabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir") + "\\evidencias\\appTreinamento\\CTAppium_2_0.apk");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dsCapabilities);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
	}

	@After
	public void tearDown() throws Exception {
		//Finalizar o driver
		driver.quit();
	}
	
	@Test
	public void preencherCadastroDesafioAula18() throws MalformedURLException, InterruptedException {
		
		String[] elementosValidacaoCTAppium = {"Nome","Console","Switch","Checkbox"};
		String[] massaValidacaoCTAppium = {"Video Game!","ps4","Off","Marcado"};
		ArrayList<String> validarDadosForm = new ArrayList<String>();

		//2 - Acessando as opções do APP CTAppium
		
		//2.1 - Clicar na opção "Formulário"
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//2.2 - Preenchendo o "Formulário"
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Video Game!");
				
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();
		
		MobileElement elCheck = driver.findElement(MobileBy.AccessibilityId("check"));
		MobileElement elSwitch = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(elCheck.getAttribute("checked").equals("false"));
		Assert.assertTrue(elSwitch.getAttribute("checked").equals("true"));
		elCheck.click();
		elSwitch.click();
		
		//3 - Verificando os campos
		Assert.assertEquals(driver.findElement(MobileBy.AccessibilityId("nome")).getText(), "Video Game!");
	  	Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText(), "PS4");
	  	Assert.assertTrue(elCheck.getAttribute("checked").equals("true"));
	  	Assert.assertTrue(elSwitch.getAttribute("checked").equals("false"));
	  	
		//4 - Clicando no Salvar
		driver.findElement(MobileBy.AccessibilityId("save")).click();
		
		//5 - Validar dos dados após Salvar
		//Thread.sleep(1000);// melhorar este ponto aqui com until
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text]")));
		
		List<MobileElement> elementosRetornadosFormAPK = driver.findElements(By.xpath("//android.widget.TextView[@text]"));
		
		// System.out.println("Qtd Elementos: "+ elementosRetornadosFormAPK.size());
		
		//Fiz estes dois blocos onde tentei outras estrategias, mas a APP, está == "Nome: Curso Appim" tudo junto e não separado / bonitinho
		//para pegar o valor do elemento e fazer a assertion.... ótimo desafio!
		//talvez tenha forma mais direta para a solução, mas, até o momento, não vi explicação no video e estou buscando outro caminho tbem!
		
		//Coloco no arrayList o valor (dado inserido no form) do 'elemento'
		for (String elementoForm : elementosValidacaoCTAppium) {
			for (MobileElement elementoRetornadoApk : elementosRetornadosFormAPK) {
				if (elementoRetornadoApk.getText().contains(elementoForm)) {
					//System.out.println("Deu certo... "+ elementoRetornadoApk.getText().substring(elementoForm.length() + 2).trim());
					validarDadosForm.add(elementoRetornadoApk.getText().substring(elementoForm.length() + 2).trim());
				}
			}
		}
		
		//Valido os dados do retornoAPK (primeiro bloco 'for' acima) contra MassaCTAppium (arrayList declarado no começo da classe)
		for (String massaFormInput : massaValidacaoCTAppium) {
			for (int i = 0; i < validarDadosForm.size(); i++) {
				if(massaFormInput.trim().equals(validarDadosForm.get(i).toString())) {
					System.out.println("deu certo né ... " + validarDadosForm.get(i).toString());
					Assert.assertEquals(massaFormInput.trim(), validarDadosForm.get(i).toString());
				}
			}
		}
	}
}
