package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Utilities.XLUtils;

public class TC_LoginDataDriven_001 extends Baseclass{

	@Test(dataProvider="datareports")
	public void LoginPage() throws InterruptedException {	
	
		driver.manage().window().maximize();
	
		LoginPage lp=new LoginPage(driver);

       // driver.get(baseurl);
		lp.setmail(email);
		Thread.sleep(2000);
		log.info("user name provided");
		lp.setpassbutton();
		log.info("password provided button clickied");
		lp.setpassword(password);
		Thread.sleep(2000);
		log.info("password provided");
		lp.setlogin();
		Thread.sleep(2000);
		lp.setcategories();
		Thread.sleep(2000);
		lp.SetLogout();

		Thread.sleep(2000);
	}
	@DataProvider(name="datareports")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/TestData/datareports.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}

		}
		return logindata;
	}
}

