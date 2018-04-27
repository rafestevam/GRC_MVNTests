package com.exed.arcmtesting.paginas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.exed.arcmtesting.infra.ElementWaiter;

public class ListaMeusObjPage {
	
	private WebDriver driver;

	public ListaMeusObjPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ListaMeusObjPage selecionaCasosDeTeste(){
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		ElementWaiter.waitForElementPresent(frame, By.id("content"), 10);
		WebElement table = frame.findElement(By.id("content"));
		
		List<WebElement> lines = table.findElements(By.tagName("tr"));
		for (WebElement line : lines) {
			if(line.getAttribute("id").contains("list_row_")){
				for(WebElement cell : line.findElements(By.tagName("td"))){
					if(cell.getText().equals("Caso de teste")){
						break;
					}
				}
				WebElement cell = line.findElement(By.className("select"));
				cell.findElement(By.name("selected_objects")).click();
				break;
			}
		}
		
		return new ListaMeusObjPage(frame);
	}
	
	public ApontamentoPage criarApontamento(){
		ElementWaiter.waitForElementPresent(driver, By.id("header_create"), 10);
		driver.findElement(By.id("header_create")).click();
		return new ApontamentoPage(driver);
	}

}
