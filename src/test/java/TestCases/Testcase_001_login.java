package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class Testcase_001_login extends Baseclass {
	@Test
	public void logintest() throws IOException  {

		driver.get(url);
		log.info("url is enter");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
		LoginPage lp=new LoginPage(driver);
	
		
		lp.setmail(email);
		log.info("email is entered");

		lp.setpassbutton();

		lp.setpassword(password);
		log.info("password is entered");
		lp.setlogin();
		lp.setcategories();
		String actual_res=driver.getTitle();

		String exp_res="Buy the best organic products, spices, handlooms and more at reasonable prices. Order directly from producers through Swayam Sikkim.";
		System.out.println(actual_res);
		 if(actual_res.equals(exp_res)){
	        	Assert.assertTrue(true);
	        	log.info("testcase is passed");
	        	
	        }
	        else{
	        	capturescreen( driver,"logintest" );
	        	Assert.assertFalse(true);
	        	log.info("testcase is failed");
	        }
	}
}
