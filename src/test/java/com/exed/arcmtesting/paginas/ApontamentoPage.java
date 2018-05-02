package com.exed.arcmtesting.paginas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.exed.arcmtesting.infra.ElementWaiter;

public class ApontamentoPage {
	
	private WebDriver formFrame;
	private WebDriver driver;

	public ApontamentoPage(WebDriver driver) {
		WebDriver frameset = driver.switchTo().defaultContent();
		WebDriver childFrameset = frameset.switchTo().defaultContent();
		WebElement frameElem = childFrameset.findElement(By.name("main"));
		WebDriver frame = childFrameset.switchTo().frame(frameElem);
		
		ElementWaiter.waitForElementPresent(frame, By.id("tabcontent"), 10);
		WebDriver formFrame = frame.switchTo().frame(frame.findElement(By.id("tabcontent")));

		this.formFrame = formFrame;		
		this.driver = driver;
	}
	
	public ApontamentoPage preencheTipo(IssueClassification issueClassif){
		
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
	
	public ApontamentoPage preencheDados(){
				
		ElementWaiter.waitForElementPresent(formFrame, By.id("name"), 10);
		WebElement issueTitle = formFrame.findElement(By.id("name"));
		issueTitle.sendKeys("Teste de Apontamento - Selenium 5");
		
		ElementWaiter.waitForElementPresent(formFrame, By.name("description"), 10);
		WebElement issueDescription = formFrame.findElement(By.name("description"));
		issueDescription.sendKeys("Descrição para Teste de Apontamento - Selenium");
		
		ElementWaiter.waitForElementPresent(formFrame, By.name("root_cause"), 10);
		WebElement issueCause = formFrame.findElement(By.name("root_cause"));
		issueCause.sendKeys("Causa Raiz para Teste de Apontamento - Selenium");
		
		ElementWaiter.waitForElementPresent(formFrame, By.id("plannedenddate"), 10);
		WebElement issueDate = formFrame.findElement(By.id("plannedenddate"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 10);
		Date currentDate = calendar.getTime();
		
		String dateInString = dateFormat.format(currentDate).toString();
		issueDate.sendKeys(dateInString);
		
		ElementWaiter.waitForElementPresent(formFrame, By.name("acting_front"), 10);
		WebElement issueActing = formFrame.findElement(By.name("acting_front"));
		Select actingSelection = new Select(issueActing);
		actingSelection.selectByVisibleText("Riscos");
		
		return new ApontamentoPage(driver);
	}
	
	public void preencheDono(){
		
		String mainWindowHandle = formFrame.getWindowHandle();
		
		ElementWaiter.waitForElementPresent(formFrame, By.id("attach_owners"), 10);
		formFrame.findElement(By.id("attach_owners")).click();
		
		String ownersPopup = null;
		Iterator<String> iteratorPopup = formFrame.getWindowHandles().iterator();
		while(iteratorPopup.hasNext()){
			ownersPopup = iteratorPopup.next();
		}
		
		WebDriver ownersWindow = formFrame.switchTo().window(ownersPopup);
		
		ElementWaiter.waitForElementPresent(ownersWindow, By.name("objectId"), 10);
		ownersWindow.findElement(By.name("objectId")).sendKeys("f000580");
		
		ElementWaiter.waitForElementPresent(ownersWindow, By.id("__filterapply"), 10);
		ownersWindow.findElement(By.id("__filterapply")).click();
		
		ElementWaiter.waitForElementPresent(ownersWindow, By.id("content"), 10);
		WebElement table = ownersWindow.findElement(By.id("content"));
		
		List<WebElement> lines = table.findElements(By.tagName("tr"));
		for (WebElement line : lines) {
			if(line.getAttribute("id").contains("list_row_")){
				WebElement cell = line.findElement(By.className("select"));
				cell.findElement(By.name("selected_objects")).click();
				break;
			}
			break;
		}
		
		ElementWaiter.waitForElementPresent(ownersWindow, By.id("header_attach"), 10);
		ownersWindow.findElement(By.id("header_attach")).click();
		//ownersWindow.close();
		
		formFrame.switchTo().window(mainWindowHandle);
		//return new ApontamentoPage(driver);
	}
	
	public void preencheRevisor(){
		
		String mainWindowHandle = formFrame.getWindowHandle();
		
		ElementWaiter.waitForElementPresent(formFrame, By.id("attach_reviewers"), 10);
		formFrame.findElement(By.id("attach_reviewers")).click();
		
		String reviewersPopup = null;
		Iterator<String> iteratorPopup = formFrame.getWindowHandles().iterator();
		while(iteratorPopup.hasNext()){
			reviewersPopup = iteratorPopup.next();
		}
		
		WebDriver reviewersWindow = formFrame.switchTo().window(reviewersPopup);
		
		ElementWaiter.waitForElementPresent(reviewersWindow, By.name("objectId"), 10);
		reviewersWindow.findElement(By.name("objectId")).sendKeys("lucas.claros");
		
		ElementWaiter.waitForElementPresent(reviewersWindow, By.id("__filterapply"), 10);
		reviewersWindow.findElement(By.id("__filterapply")).click();
		
		ElementWaiter.waitForElementPresent(reviewersWindow, By.id("content"), 10);
		WebElement table = reviewersWindow.findElement(By.id("content"));
		
		List<WebElement> lines = table.findElements(By.tagName("tr"));
		for (WebElement line : lines) {
			if(line.getAttribute("id").contains("list_row_")){
				WebElement cell = line.findElement(By.className("select"));
				cell.findElement(By.name("selected_objects")).click();
				break;
			}
			break;
		}
		
		ElementWaiter.waitForElementPresent(reviewersWindow, By.id("header_attach"), 10);
		reviewersWindow.findElement(By.id("header_attach")).click();
		//reviewersWindow.close();
		
		formFrame.switchTo().window(mainWindowHandle);
		//return new ApontamentoPage(driver);
	}
	
	public ApontamentoPage salvaApontamento(){

		try{
			ElementWaiter.waitForElementPresent(formFrame, By.id("form_save"), 10);
			Thread.sleep(3000);
			formFrame.findElement(By.id("form_save")).click();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
		return new ApontamentoPage(driver);
	} 
	
	public boolean verificaErroFormulario(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return formFrame.getPageSource().contains("O formulário contém erros.");
	}

}
