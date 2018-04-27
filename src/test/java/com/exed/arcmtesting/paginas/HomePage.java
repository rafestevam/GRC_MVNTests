package com.exed.arcmtesting.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ExplorerPage navegarParaExplorerPage(){
		this.waitForElementPresent(By.name("head"), 10);
		WebElement frameElem = driver.findElement(By.name("head"));
		WebDriver frame = driver.switchTo().frame(frameElem);
		String xPath = "/html/body/table/tbody/tr[1]/td/table/tbody/tr/td[2]/div[2]";
		frame.findElement(By.xpath(xPath)).click();
			
		return new ExplorerPage(driver);
	}
	
	public void waitForElementPresent(final By by, int timeout) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout)
				.ignoring(StaleElementReferenceException.class);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				WebElement element = webDriver.findElement(by);
				return element != null && element.isDisplayed();
			}
		});
	}

}
