package genricUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListnerUtility extends BaseClass implements ITestListener {
	ExtentReports report;
	
	
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("./report/Extentdemo.html");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Demo Extent Report");
		reporter.config().setReportName("shrija reporter");
		
		report=new ExtentReports();
		report.attachReporter(reporter);
		
	}
	public void onTestStart(ITestResult result) {
		logger=report.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, "The test"+result.getName()+"is passed");
	}
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, "The test"+result.getName()+"is failed");
		
		logger.addScreenCaptureFromPath(screenshotUtility.capturingScreenshot(result.getName()));
		
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}

}

