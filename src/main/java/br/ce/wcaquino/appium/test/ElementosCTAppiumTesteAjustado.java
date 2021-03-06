package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ElementosCTAppiumTesteAjustado extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();
	private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		formulario.escreverNome("Ricardo Couto");
		Assert.assertEquals("Ricardo Couto", formulario.obterNome());
	}

	@Test
	public void deveIntegarirCombo() throws MalformedURLException {
		formulario.selecionarCombo("Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", formulario.obterValorCombo());
	}
	
	@Test
	public void deveIntegarirSwitchCheckBox() throws MalformedURLException {
		Assert.assertFalse(formulario.isCheckMarcado());
		Assert.assertTrue(formulario.isSwitchMarcado());
		
		formulario.clicarCheck();
		formulario.clicarSwitch();

		Assert.assertTrue(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());
	}
	
	@Test
	public void deveAlterarData() throws InterruptedException {
		formulario.clicarPorTexto("01/01/2000");
		Thread.sleep(1000);
		formulario.clicarPorTexto("20");
		formulario.clicarPorTexto("OK");
		Assert.assertTrue(formulario.existeElementoPorTexto("20/01/2000"));
	}
	
	@Test
	public void deveAlterarHora() throws InterruptedException {
		formulario.clicarPorTexto("12:00");
		Thread.sleep(1000);
		formulario.clicar(MobileBy.AccessibilityId("8"));
		formulario.clicar(MobileBy.AccessibilityId("40"));
		formulario.clicarPorTexto("OK");
		Assert.assertTrue(formulario.existeElementoPorTexto("08:40"));
	}
	
	@Test
	public void preencherCadastro() throws MalformedURLException, InterruptedException {

		String[] elementosValidacaoCTAppium = { "Nome", "Console", "Switch", "Checkbox" };
		String[] massaValidacaoCTAppium = { "Video Game!", "ps4", "Off", "Marcado" };
		ArrayList<String> validarDadosForm = new ArrayList<String>();

		// 2 - Acessando as op????es do APP CTAppium
		// 2.2 - Preenchendo o "Formul??rio"
		formulario.escreverNome("Video Game!");

		formulario.clicarCombo();
		formulario.clicarOpcaoCombo("PS4");
		
		Assert.assertFalse(formulario.isCheckMarcado());
		Assert.assertTrue(formulario.isSwitchMarcado());

		formulario.clicarCheck();
		formulario.clicarSwitch();

		Assert.assertEquals(formulario.obterNome(), "Video Game!");
		Assert.assertEquals(formulario.obterValorCombo(),"PS4");
		
		Assert.assertTrue(formulario.isCheckMarcado());
		Assert.assertFalse(formulario.isSwitchMarcado());

		// 4 - Clicando no Salvar
		formulario.clicarSalvar();

		// 5 - Validar dos dados ap??s Salvar
		//Thread.sleep(2000);// melhorar este ponto aqui com until
		wait.until(ExpectedConditions.presenceOfElementLocated(formulario.elementosSalvo()));

		List<MobileElement> elementosRetornadosFormAPK = formulario.obterValoresLista();

		// System.out.println("Qtd Elementos: "+ elementosRetornadosFormAPK.size());

		// Fiz estes dois blocos onde tentei outras estrategias, mas a APP, est?? ==
		// "Nome: Curso Appim" tudo junto e n??o separado / bonitinho
		// para pegar o valor do elemento e fazer a assertion.... ??timo desafio!
		// talvez tenha forma mais direta para a solu????o, mas, at?? o momento, n??o vi
		// explica????o no video e estou buscando outro caminho tbem!

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
		// MassaCTAppium (arrayList declarado no come??o da classe)
		for (String massaFormInput : massaValidacaoCTAppium) {
			for (int i = 0; i < validarDadosForm.size(); i++) {
				if (massaFormInput.trim().equals(validarDadosForm.get(i).toString())) {
					System.out.println("deu certo n?? ... " + validarDadosForm.get(i).toString());
					Assert.assertEquals(massaFormInput.trim(), validarDadosForm.get(i).toString());
				}
			}
		}
	}
	
	@Ignore
	//@Test
	public void preencherCadastroDemorado() throws MalformedURLException, InterruptedException {

		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		String[] elementosValidacaoCTAppium = { "Nome" };
		String[] massaValidacaoCTAppium = { "Video Game!" };
		ArrayList<String> validarDadosForm = new ArrayList<String>();

		// 2 - Acessando as op????es do APP CTAppium
		// 2.2 - Preenchendo o "Formul??rio"
		formulario.escreverNome("Video Game!");

		Assert.assertEquals(formulario.obterNome(), "Video Game!");
		
		// 4 - Clicando no Salvar
		formulario.clicarSalvarDemorado();

		// 5 - Validar dos dados ap??s Salvar
		Thread.sleep(2000);// melhorar este ponto aqui com until
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.TextView[@text]")));

		List<MobileElement> elementosRetornadosFormAPK = formulario.obterValoresLista();

		// System.out.println("Qtd Elementos: "+ elementosRetornadosFormAPK.size());

		// Fiz estes dois blocos onde tentei outras estrategias, mas a APP, est?? ==
		// "Nome: Curso Appim" tudo junto e n??o separado / bonitinho
		// para pegar o valor do elemento e fazer a assertion.... ??timo desafio!
		// talvez tenha forma mais direta para a solu????o, mas, at?? o momento, n??o vi
		// explica????o no video e estou buscando outro caminho tbem!

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
		// MassaCTAppium (arrayList declarado no come??o da classe)
		for (String massaFormInput : massaValidacaoCTAppium) {
			for (int i = 0; i < validarDadosForm.size(); i++) {
				if (massaFormInput.trim().equals(validarDadosForm.get(i).toString())) {
					System.out.println("deu certo n?? ... " + validarDadosForm.get(i).toString());
					Assert.assertEquals(massaFormInput.trim(), validarDadosForm.get(i).toString());
				}
			}
		}
	}
}
