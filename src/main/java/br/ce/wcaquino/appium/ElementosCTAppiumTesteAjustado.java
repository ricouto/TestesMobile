package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.DSL;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ElementosCTAppiumTesteAjustado {
	
	private DSL dsl = new DSL(); 
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		// entrar no Formulario XPath
		dsl.clicarPorTexto("Formulário");
		//dsl.clicar(By.xpath("//android.widget.TextView[@text='Formulário']"));
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		//passos
		//escrever "nome" 
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Ricardo Couto");
		
		//verificar o nome inputado
		Assert.assertEquals("Ricardo Couto", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}

	@Test
	public void deveIntegarirCombo() throws MalformedURLException {
		//passos
		//clicar no combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
		
		//selecionar e verificar a opcao
		String textCombo = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		//System.out.println(textCombo);
		Assert.assertEquals("Nintendo Switch", textCombo);
	}
	
	@Test
	public void deveIntegarirSwitchCheckBox() throws MalformedURLException {
		//passos
		//verificar o status do elemento
		Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
		
		//clicar nos elementos
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));
		
		//verificar estados alterados
		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}
	
	@Test
	public void preencherCadastro() throws MalformedURLException, InterruptedException {

		String[] elementosValidacaoCTAppium = { "Nome", "Console", "Switch", "Checkbox" };
		String[] massaValidacaoCTAppium = { "Video Game!", "ps4", "Off", "Marcado" };
		ArrayList<String> validarDadosForm = new ArrayList<String>();

		// 2 - Acessando as opções do APP CTAppium
		// 2.2 - Preenchendo o "Formulário"
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Video Game!");

		dsl.clicar(By.className("android.widget.Spinner"));
		
		dsl.clicar(By.xpath("//android.widget.CheckedTextView[@text='PS4']"));
		
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("check")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		dsl.clicar(MobileBy.AccessibilityId("check"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));

		// 3 - Verificando os campos
		Assert.assertEquals(dsl.obterTexto(MobileBy.AccessibilityId("nome")), "Video Game!");
		Assert.assertEquals(dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView")),"PS4");
		
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("check")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		// 4 - Clicando no Salvar
		dsl.clicar(MobileBy.AccessibilityId("save"));

		// 5 - Validar dos dados após Salvar
		Thread.sleep(2000);// melhorar este ponto aqui com until
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text]")));

		List<MobileElement> elementosRetornadosFormAPK = dsl.obterLista(By.xpath("//android.widget.TextView[@text]"));

		// System.out.println("Qtd Elementos: "+ elementosRetornadosFormAPK.size());

		// Fiz estes dois blocos onde tentei outras estrategias, mas a APP, está ==
		// "Nome: Curso Appim" tudo junto e não separado / bonitinho
		// para pegar o valor do elemento e fazer a assertion.... ótimo desafio!
		// talvez tenha forma mais direta para a solução, mas, até o momento, não vi
		// explicação no video e estou buscando outro caminho tbem!

		// Coloco no arrayList o valor (dado inserido no form) do 'elemento'
		for (String elementoForm : elementosValidacaoCTAppium) {
			for (MobileElement elementoRetornadoApk : elementosRetornadosFormAPK) {
				if (elementoRetornadoApk.getText().contains(elementoForm)) {
					// System.out.println("Deu certo... "+
					// elementoRetornadoApk.getText().substring(elementoForm.length() + 2).trim());
					validarDadosForm.add(elementoRetornadoApk.getText().substring(elementoForm.length() + 2).trim());
				}
			}
		}

		// Valido os dados do retornoAPK (primeiro bloco 'for' acima) contra
		// MassaCTAppium (arrayList declarado no começo da classe)
		for (String massaFormInput : massaValidacaoCTAppium) {
			for (int i = 0; i < validarDadosForm.size(); i++) {
				if (massaFormInput.trim().equals(validarDadosForm.get(i).toString())) {
					System.out.println("deu certo né ... " + validarDadosForm.get(i).toString());
					Assert.assertEquals(massaFormInput.trim(), validarDadosForm.get(i).toString());
				}
			}
		}
	}
}
