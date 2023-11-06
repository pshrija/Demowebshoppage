package genricUtilities;

import org.testng.internal.ReporterConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo {

	public static void main(String[] args) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("./report/Extentdemo.html");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Demo Extent Report");
		reporter.config().setReportName("shrija reporter");
		
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(reporter);
		
		ExtentTest logger=report.createTest("test1");
		
		logger.log(Status.FAIL, "This is failed");
		logger.log(Status.PASS, "This is passed");
		logger.log(Status.INFO, "this is information");
		logger.log(Status.SKIP, "this is skipped");
		logger.log(Status.WARNING, "this is warning");
		logger.addScreenCaptureFromPath("C:\\Users\\hi\\OneDrive\\Desktop\\screenshot_01.jpg");
		ExtentTest logger1=report.createTest("test2");
		
		report.flush();
		System.out.println("done");
		

		
		

	

	}

}
