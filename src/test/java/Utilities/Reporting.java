package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	

public void onStart(ITestContext testcontext) {
	//create time stamp
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
	//create report name
	String repName="Test-Report" + timestamp + ".html";
	//specify the location
	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/" + repName);
    htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
    
    extent =new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Hostname", "localhost");
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("user", "Anil");
    
    
    htmlReporter.config().setDocumentTitle("Fundraiser test project");
    htmlReporter.config().setReportName("Function test report");
    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    htmlReporter.config().setTheme(Theme.DARK);
    
   
}
public void onTestSuccess(ITestResult tr) {
	//create new entry
	logger=extent.createTest(tr.getName()); 
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
}

public void onTestFailure(ITestResult tr) {
	
	logger=extent.createTest(tr.getName());
	logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	
	String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	
	File f = new File(screenshotPath); 
	
	if(f.exists())
	{
	try {
		logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		} 
	catch (IOException e) 
			{
			e.printStackTrace();
			}
	}
}
	public void onTestSkipped(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}

	public void onFinish(ITestContext testcntext) {
		
		extent.flush();
	}

}
