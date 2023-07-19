package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import Utilities.Listenersutilities;
import Utilities.reports;
import Utilities.validations;


public class LoginPage {
	
	Listenersutilities ut=new Listenersutilities();
	reports repo=new reports();
	WebDriver driver;

	validations validate=new validations();


	@FindBy(id="email")
	private WebElement Username;

	@FindBy(id="pass")
	private WebElement Password;

	@FindBy(name="login")
	private WebElement Submitbtn;


	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void LoginData(String username,String password)
	{
		Username.sendKeys(username);
		Password.sendKeys(password);
		Submitbtn.click();
		
		
	}

	public void verifyLogin() throws InterruptedException
	{
		WebElement element=driver.findElement(By.xpath("//a[@aria-label=\"Facebook\"]"));
		validate.Displayed(element, driver);


	}
}
