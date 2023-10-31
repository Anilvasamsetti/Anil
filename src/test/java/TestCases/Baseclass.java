package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.Readdata;

public class Baseclass {
	Readdata rd=new Readdata();
	public String url=rd.getapplicationurl();
	public String email=rd.getemail();
	public String password=rd.getpassword();
	public static Logger log;
	public static WebDriver driver;
	
	@BeforeClass
	public void openapplication(){
		log=Logger.getLogger(this.getClass());
		PropertyConfigurator.configure("log4j.properties");
		
		driver=new ChromeDriver();
		driver.get(url);
		
	}
	@AfterClass

	public void Closepage()
	{
		driver.close();
}
	public void capturescreen(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./Screenshots/"+name+".png");
		FileUtils.copyFile(src, target);
		log.info("screenshot is taken");
}
}