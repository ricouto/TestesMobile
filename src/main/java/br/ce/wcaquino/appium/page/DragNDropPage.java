package br.ce.wcaquino.appium.page;

import java.util.List;
import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileElement;

public class DragNDropPage extends BasePage {
	
	public void arrastar(String origem, String destino) {
		
	}
	
	public String[] obterLista() {
		
		List<MobileElement> elements = getDriver().findElements(By.className("android.view.ViewGroup"));
		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			System.out.println("\"" + retorno[i] + "\", ");
		}
		return retorno; 
	}

}
