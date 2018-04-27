package com.exed.arcmtesting.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.exed.arcmtesting.infra.ElementWaiter;

public class ExplorerPage {

	private WebDriver driver;
	
	public ExplorerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ExplorerPage acessaMenuApontamento() {
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		ElementWaiter.waitForElementPresent(frame, By.id("item.explorer.issue.management"), 10);
		frame.findElement(By.id("item.explorer.issue.management")).click();
		return new ExplorerPage(driver);
	}
	
	public ExplorerPage acessaMenuRisco(){
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		frame.findElement(By.id("item.explorer.risk.management")).click();
		return new ExplorerPage(driver);
	}	
	
	public ListaRiscosPage acessaListagemRiscos(){
		driver.findElement(By.id("dataGrid.risk")).click();
		return new ListaRiscosPage(driver);
	}
	
	public ListaMeusObjPage acessaListaMeusObjetos(){
		ElementWaiter.waitForElementPresent(driver, By.id("dataGrid.MyIssueRelevantObjects"), 10);
		driver.findElement(By.id("dataGrid.MyIssueRelevantObjects")).click();
		return new ListaMeusObjPage(driver);
	}
	
}
