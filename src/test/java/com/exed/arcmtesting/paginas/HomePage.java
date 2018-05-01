package com.exed.arcmtesting.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.exed.arcmtesting.infra.ElementWaiter;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ExplorerPage navegarParaExplorerPage(){
		ElementWaiter.waitForElementPresent(driver, By.name("head"), 10);
		WebElement frameElem = driver.findElement(By.name("head"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		String xPath = "/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/div[2]";
		
		ElementWaiter.waitForElementPresent(frame, By.xpath(xPath), 10);
		frame.findElement(By.xpath(xPath)).click();
			
		return new ExplorerPage(driver);
	}
}
