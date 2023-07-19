package Utilities;

import java.io.FileInputStream;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenersutilities implements ITestListener{


	public ExtentSparkReporter spark;

	public static WebDriver driver;
	public FileInputStream file;
	public ExtentReports extent;
	public ExtentTest test;
    public webDriverUtilities wu;
	

	public void onTestStart(ITestResult result) {
		test.log(Status.INFO,"Test is starting");

	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.YELLOW));

	}

	public void onStart(ITestContext context) {

		spark=new ExtentSparkReporter(".\\ExtentReports\\Reports.html"+ new Listenersutilities().getSystemDateInFormat()+".html");
		extent=new ExtentReports();
		extent.attachReporter(spark);
		test=extent.createTest("Search Functionality");
		test.log(Status.INFO,"Test is starting");
		spark.config().setTheme(Theme.DARK);
//		wu=new webDriverUtilities();
//		wu.CaptureScreenshot("Image");


	}

	public void onFinish(ITestContext context) {


		test.log(Status.INFO,"Test is completed");
		extent.flush();
	}

	public String getSystemDateInFormat()
	{

		Date d = new Date();

		String[] dArr = d.toString().split(" ");

		String date = dArr[2];

		String month = dArr[1];

		String year = dArr[5];

		String time = dArr[3].replace(":", "-");

		String currentDateAndTime = date+" "+month+" "+year+" "+time;

		return currentDateAndTime;

	}


}
