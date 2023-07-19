package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;

import PageObjects.GroupsPage;
import PageObjects.LoginPage;
import PageObjects.MessengerPage;
import Utilities.Logutilities;
import Utilities.ScreenShotsUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(Utilities.Listenersutilities.class)

public class stepDefinition extends Logutilities{

	WebDriver driver;

	ScreenShotsUtilities ss=new ScreenShotsUtilities();
	
	@Given(": User Launch the browser")
	public void user_launch_the_browser() {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(opt);
		info("----Chrome opened Successfully----");

	}

	@When(": User opens the Url {string}")
	public void user_opens_the_url(String string) {

		driver.get(string);
		driver.manage().window().maximize();
		
	}

	@When(": User enters email as {string} and Password {string}")
	public void user_enters_email_as_and_password(String username, String password) {

		LoginPage l=new LoginPage(driver);
		l.LoginData(username, password);
		info("----Login Successfully----");





	}

	@When(": Click on login")
	public void click_on_login() {

		LoginPage l=new LoginPage(driver);

	}
	@Then(": verify the facebook home page")
	public void verify_the_facebook_home_page() throws InterruptedException {

		LoginPage l=new LoginPage(driver);
		l.verifyLogin();
		info("----Login is verified Successfully----");
		//ss.CaptureScreenshot(driver, "Image");


	}

	@Then(":click on messenger Icon")
	public void click_on_messenger_icon() throws InterruptedException {
		MessengerPage l=new MessengerPage(driver);
		l.messageData();
		info("----Icon is clicked----");

	}

	@Then(":click on inbox and get data from the inbox")
	public void click_on_inbox_and_get_data_from_the_inbox() {
		MessengerPage l=new MessengerPage(driver);
		l.getInboxData();
		info("----Inbox data is read successfully----");


	}

	@Then(": Verify the messenger page")
	public void verify_the_messenger_page() throws InterruptedException {
		MessengerPage l=new MessengerPage(driver);
		l.verifyMessengerIcon();
		info("----Messenger page is verified Successfully----");



	}

	@Then(": click on group button")
	public void click_on_group_button() throws InterruptedException {
		GroupsPage gp=new GroupsPage(driver);
		gp.groupCreation();
		
		
	}

	@When(":click on create new btn")
	public void click_on_create_new_btn() {
		GroupsPage gp=new GroupsPage(driver);
		gp.createGrp();

	}

	@Then(": user enter group name as\"Kairos\" and choose privacy")
	public void user_enter_group_name_as_kairos_and_choose_privacy() throws InterruptedException {
		GroupsPage gp=new GroupsPage(driver);
		gp.grpName();

	}

	@Then(": click on create btn")
	public void click_on_create_btn() throws InterruptedException {
		GroupsPage gp=new GroupsPage(driver);
		gp.clickBtn();
		info("----Group is Successfully----");

	}

	@Then(":close browser")
	public void close_browser() {
		driver.quit();

	}
}
