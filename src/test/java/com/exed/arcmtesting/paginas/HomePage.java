package com.exed.arcmtesting.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ExplorerPage acessaMenuExplorer(){
		WebElement frameElem = driver.findElement(By.name("head"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		String xPath = "/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/div[2]";
		frame.findElement(By.xpath(xPath)).click();
		return new ExplorerPage(driver);
	}

}
