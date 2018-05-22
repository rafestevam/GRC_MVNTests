package com.exed.arcmtesting.testes.auditoria;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.exed.arcmtesting.paginas.ApontamentoPage;
import com.exed.arcmtesting.paginas.HomePage;
import com.exed.arcmtesting.paginas.IssueClassification;
import com.exed.arcmtesting.paginas.ListaMeusObjPage;
import com.exed.arcmtesting.paginas.LoginPage;

import static org.junit.Assert.assertTrue;

public class TestarFluxoDeApontamento {
	
	private LoginPage login;
	private WebDriver driver;
	
	@Before
	public void inicializa(){
//		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("no-sandbox");
//		driver = new ChromeDriver();	
//		login = new LoginPage(driver);
		System.setProperty("webdriver.gecko.driver", "C:/GeckoDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		login = new LoginPage(driver);
	}
	
	@Test
	public void criarApontamento(){
		
		login.visita();
		HomePage home = login.executaLogin("caio.robert", "manager");
		ListaMeusObjPage meusObjPage = home.navegarParaExplorerPage()
			.acessaMenuApontamento()
			.acessaListaMeusObjetos();
		
		ApontamentoPage apontamento = meusObjPage.selecionaCasosDeTeste().criarApontamento();
		apontamento
			.preencheTipo(IssueClassification.APONTAMENTO)
			.preencheDados();
		apontamento.preencheDono();
		apontamento.preencheRevisor();
		apontamento.salvaApontamento();
		
		assertTrue(!apontamento.verificaErroFormulario());
		
	}
	
	

}
