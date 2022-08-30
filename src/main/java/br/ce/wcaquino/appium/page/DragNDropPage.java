package br.ce.wcaquino.appium.page;

import java.util.List;
import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class DragNDropPage extends BasePage {
	
	@SuppressWarnings("rawtypes")
	public void arrastar(String origem, String destino) {
		MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='" + origem + "']"));
		MobileElement fim = getDriver().findElement(By.xpath("//*[@text='" + destino + "']"));
		
		TouchAction touchAction = new TouchAction(DriverFactory.getDriver());
		touchAction.longPress(ElementOption.element(inicio)).moveTo(ElementOption.element(fim)).release().perform();
		
	}
	
	public String[] obterLista() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("android.view.ViewGroup")));
		
		List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
		String[] retorno = new String[elements.size()];

		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			//System.out.println("\"" + retorno[i] + "\", ");
		}
		return retorno; 
	}

}
