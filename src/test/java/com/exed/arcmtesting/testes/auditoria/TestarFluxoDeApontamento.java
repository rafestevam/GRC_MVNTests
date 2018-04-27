package com.exed.arcmtesting.testes.auditoria;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.exed.arcmtesting.paginas.HomePage;
import com.exed.arcmtesting.paginas.LoginPage;

public class TestarFluxoDeApontamento {
	
	private LoginPage login;
	private WebDriver driver;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("no-sandbox");
		driver = new ChromeDriver();	
		login = new LoginPage(driver);
	}
	
	@Test
	public void acessarListagemRelatorioGerencial(){
		
		login.visita();
		HomePage home = login.executaLogin("caio.robert", "manager");
		home.acessaMenuExplorer().acessaMenuApontamento();
		
	}
	
	

}
