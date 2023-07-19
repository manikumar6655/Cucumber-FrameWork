package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ScreenShotsUtilities;
import Utilities.validations;
import Utilities.webDriverUtilities;

public class MessengerPage {


	WebDriver driver;
	public webDriverUtilities ut=new webDriverUtilities();
	public validations validate=new validations();
	public ScreenShotsUtilities ss=new ScreenShotsUtilities();

	public MessengerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@aria-label=\"Account controls and settings\"]//div[@class=\"x9f619 x1n2onr6 x1ja2u2z\"]/child::div[@aria-label=\"Messenger\"][1]")WebElement messengerIcon;
	@FindBy(xpath = "//div[@class=\"x1c4vz4f\"]//input[@dir=\"ltr\"]")WebElement SearchBar;
	@FindBy(xpath = "//div[@class=\"x1ey2m1c x9f619 xds687c x10l6tqk x17qophe x13vifvy\"]//span[text()='Inbox']")WebElement Inbox;




	public void messageData() throws InterruptedException
	{
		Thread.sleep(4000);
		messengerIcon.click();
		ut.highlightElement(driver, messengerIcon);

	}

	public void getInboxData()
	{
		List<WebElement> sr=driver.findElements(By.xpath("//span[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft\"]"));
		for (WebElement s:  sr ) {
			System.out.println(s.getText());

		}
	}
	public void verifyMessengerIcon() throws InterruptedException
	{
		WebElement Inbox=driver.findElement(By.xpath("//div[@class='x1ey2m1c x9f619 xds687c x10l6tqk x17qophe x13vifvy']//span[text()='Inbox']"));
		validate.Displayed(Inbox, driver);
		System.out.println("Inbox is displayed");
     	ss.CaptureScreenshot(driver, "img2");
	}
	


}






