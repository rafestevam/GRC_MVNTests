package com.exed.arcmtesting.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita(){
		driver.get("http://localhost:8080/arcm/login.jsp");
	}
	
	public HomePage executaLogin(String user, String pass){
		WebElement txtUser = driver.findElement(By.name("username"));
		txtUser.sendKeys(user);
		
		WebElement txtPass = driver.findElement(By.name("password"));
		txtPass.sendKeys(pass);

		txtUser.submit();
		return new HomePage(driver);
	}
}
