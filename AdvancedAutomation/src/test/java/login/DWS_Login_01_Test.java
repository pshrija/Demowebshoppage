
package login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genricUtilities.BaseClass;
import genricUtilities.ITestListnerUtility;

@Listeners(ITestListnerUtility.class)
	public class DWS_Login_01_Test extends BaseClass{
		
		@Test
		public void Login_to_application_with_valid_credentials() {
			loginpage.getLoginlink().click();
			logger.log(Status.INFO, "User click on the login link");
			loginpage.getEmailTF().sendKeys("shrijap@gmail.com");
			logger.log(Status.INFO, "User sends the credentials to email text field");
			loginpage.getPasswordTF().sendKeys("123465");
			logger.log(Status.INFO, "User sends the credentials to password text field");
			loginpage.getLogin_button().click();
		}
	}
	
	
	
		
	
	
	
	
	


