package br.ce.wcaquino.appium.core;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

//import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTitulo() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	public String obterMensagem() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public String clicarOpcaoPorXPath(String opc, String texto) {
		//clicar(By.xpath("//*//android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView/*[@text='" + texto + "']"));
		
		//clicar(By.xpath("//*[@text='" + opc + "']//../../..//android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView//*[@text='" + texto + "']"));
		
		return obterTexto(By.xpath("//*[@text='" + opc + "']/../../..//android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView//*[@text=" + texto + "]"));
		
		//../../..//android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView//*[@text='" + texto + "']"
		
	}

	public List<MobileElement> obterLista(By by) {
		return getDriver().findElements(by);
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}
	
	public void clicarSeekBar(double posicao) {
		@SuppressWarnings("unused")
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
		// getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+valor+"']")).click();
	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	public void tap(int startx, int starty) {
		 AndroidTouchAction touchAction = new AndroidTouchAction (getDriver());
		//@SuppressWarnings("rawtypes")
		//TouchAction touchAction = new TouchAction(getDriver());

		System.out.println("clicado na tap em : " + startx + " " + starty);
		//touchAction.tap(PointOption.point(startx, starty)).release().perform(); //com TAP

		touchAction.press(PointOption.point(startx, starty)).perform(); // com Press -> OK funcionou

		// touchAction.press(PointOption.point(startx, starty)).release().perform();
		// //NÃO funcionou!
	}
	
	@SuppressWarnings("rawtypes")
	public void scroll(double inicio, double fim) {
		//AndroidTouchAction touchAction = new AndroidTouchAction (getDriver());
		
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		new TouchAction(getDriver())
        .longPress(PointOption.point(x, start_y))
        .moveTo(PointOption.point(x, end_y))
        .release()
        .perform();
	}
	
	@SuppressWarnings("rawtypes")
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2;
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction(getDriver())
        .longPress(PointOption.point(start_x, y))
        .moveTo(PointOption.point(end_x, y))
        .release()
        .perform();
		
	}
	
	@SuppressWarnings("rawtypes")
	public void swipeList(String texto, double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		
		if (elementos.size() > 0) {
			clicarPorTexto(texto);
			int y = size.height / 8;
			int start_x = (int) (size.width * inicio);
			int end_x = (int) (size.width * fim);
			new TouchAction(getDriver())
				.longPress(PointOption.point(start_x, y))
				.moveTo(PointOption.point(end_x, y))
				.release().perform();
		} else {
			Assert.fail("Não existe a opção com o texto : " + texto);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void swipeElement(MobileElement element, double inicio, double fim) {

		int y = element.getLocation().y + (element.getSize().height / 2);

		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		
		new TouchAction(getDriver())
			.longPress(PointOption.point(start_x, y))
			.moveTo(PointOption.point(end_x, y))
			.release().perform();
	}
	
	public void cliqueLongo(By by) {
		AndroidTouchAction touch = new AndroidTouchAction(DriverFactory.getDriver());
        touch.longPress(LongPressOptions.longPressOptions()
        		.withElement(ElementOption.element(DriverFactory.getDriver().findElement(by))))
        		.perform();
	}
}	
