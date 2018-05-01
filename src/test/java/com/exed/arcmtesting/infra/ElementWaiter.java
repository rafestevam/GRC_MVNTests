package com.exed.arcmtesting.infra;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementWaiter {

	public static void waitForElementPresent(WebDriver driver, final By by, int timeout) {
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout)
				.ignoring(StaleElementReferenceException.class);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				WebElement element = webDriver.findElement(by);
				return element != null && element.isDisplayed();
			}
		});
	}
	
	public static WebElement waitForElementClickable(WebDriver driver, final By by, int timeout){
		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		return element;
//		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout)
//				.ignoring(StaleElementReferenceException.class);
//		wait.until(new ExpectedCondition<Boolean>() {
//			public Boolean apply(WebDriver webDriver){
//				WebElement element = webDriver.findElement(by);
//				return element != null && element.isEnabled();
//			}
//		});
		
	}

}
