package com.exed.arcmtesting.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.exed.arcmtesting.infra.ElementWaiter;

public class ApontamentoPage {
	
	private WebDriver driver;

	public ApontamentoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ApontamentoPage preencheTipo(IssueClassification issueClassif){
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		WebDriver formFrame = frame.switchTo().frame(frame.findElement(By.id("tabcontent")));
		
		ElementWaiter.waitForElementPresent(formFrame, By.name("action_type"), 10);
		WebElement issueType = formFrame.findElement(By.name("action_type"));
//		ElementWaiter.waitForElementPresent(driver, By.name("action_type"), 10);
//		WebElement issueType = driver.findElement(By.name("action_type"));
		Select issueTypeSel = new Select(issueType);
		
		if(issueClassif.equals(IssueClassification.APONTAMENTO))
			issueTypeSel.selectByVisibleText("Apontamento");
		
		if(issueClassif.equals(IssueClassification.PLANO_DE_ACAO))
			issueTypeSel.selectByVisibleText("Plano de Ação");
		
		return new ApontamentoPage(driver);
		
	}

}
