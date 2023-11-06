package login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genricUtilities.BaseClass;
import genricUtilities.ITestListnerUtility;
@Listeners(ITestListnerUtility.class)
public class DWS_Register_02_Test extends BaseClass {
	@Test
	public void Register_to_the_application_with_Valid_details() {
		registerpage.getRegisterlink().click();
		logger.log(Status.INFO, "User click on the Register link");
		registerpage.getMalebutton().click();
		registerpage.getFirstNameTF().sendKeys("shrija");
		logger.log(Status.INFO, "User sends details to firstName");
		registerpage.getLastNameTF().sendKeys("ss");
		logger.log(Status.INFO, "User sends details to lastName");
		registerpage.getEmailTF().sendKeys("shrijap986@gmail.com");
		logger.log(Status.INFO, "User sends details to email");
		registerpage.getPasswordTF().sendKeys("12345");
		registerpage.getConfirmPwdTF().sendKeys("12345");
		logger.log(Status.INFO, "User sends details to password");
		registerpage.getRegisterbutton().click();
	}
}


