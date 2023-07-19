package Utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class reports {

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

	public void extentReports()
	{

		ExtentSparkReporter  spark=new ExtentSparkReporter(".\\ExtentReports\\Reports.html"+ new reports().getSystemDateInFormat()+".html");

		ExtentReports extent=new ExtentReports();
	
		extent.attachReporter(spark);
		ExtentTest  test=extent.createTest("Search Functionality");
		test.log(Status.INFO,"Test is starting");
		spark.config().setTheme(Theme.DARK);
		extent.flush();


	}
}
