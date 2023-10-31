package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readdata {

	Properties pro;
	public Readdata(){
		File file=new File("./Configuration/Kumar.properties");
		try {
			FileInputStream fis=new FileInputStream(file);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e){
			System.out.println("exception is "+e.getMessage());

		}
	}	
	public String getapplicationurl() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getemail() {
		String mail=pro.getProperty("email");
		return mail;
	}
	public String getpassword() {
		String pass=pro.getProperty("password");
		return pass;
	 }
}
