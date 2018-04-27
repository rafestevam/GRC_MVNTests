package com.exed.arcmtesting.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		frame.findElement(By.id("item.explorer.issue.management")).click();
		return new ExplorerPage(driver);
	}
	
}
