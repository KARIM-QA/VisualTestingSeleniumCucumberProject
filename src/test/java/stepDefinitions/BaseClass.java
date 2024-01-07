package stepDefinitions;



import pageObjects.AddCustomersPage;
import pageObjects.LoginPage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;



public class BaseClass {
	
	protected LoginPage loginPage ;
	protected AddCustomersPage addCustomersPage ;
	protected WebDriver myDriver;
   
	protected BatchInfo batch ;
	protected EyesRunner runner ;
	protected Eyes eyes ;
    
    
    
 // fonction that generate a random email
    protected static String RandomString() {
    	
    	String generatedString=RandomStringUtils.randomAlphabetic(5) ;
    	
    	return generatedString ;
    }
    
    protected void setBatch() {
    	batch = new BatchInfo("Visual Testing with selenium");
    	runner =new ClassicRunner();
    	eyes =new Eyes(runner);
    	eyes.setApiKey("43ga3exQD9VbnIpbIHxCqPTcRA36Znl3zKZuJjEfPYU110");
    	eyes.setBatch(batch);
    }


}
