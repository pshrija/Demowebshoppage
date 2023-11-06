package genricUtilities;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.Books_Page;
import objectRepository.Computers_Page;
import objectRepository.Jewelry_page;
import objectRepository.Login_Page;
import objectRepository.Register_Page;
import objectRepository.Welcome_page;


public class BaseClass implements IAutoConstants{

	public static WebDriver driver;
	public static PropertyUtility property;
	public static TakescreenshotUtility screenshotUtility;
	public static WebdriverUtility webdriverUtility;
	public static ExtentTest logger;
	public static Jewelry_page jewelrypage;
	public static Login_Page loginpage;
	public static Register_Page registerpage;
	public static objectRepository.Welcome_page welcomepage;
	public static Books_Page bookspage;
	public static Computers_Page computerpage;
	JavaUtilty javaUtility;
	DatabaseUtility dbUtility;
	
	@BeforeClass(alwaysRun = true)
	public void launchingTheBrowserAndNaviagateToApplication() {
		property=new PropertyUtility();
		if (BROWSER.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(op);
		}else if (BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property.readingDataFromPropertyfile("url"));
		webdriverUtility=new WebdriverUtility(driver);
		javaUtility=new JavaUtilty();
		dbUtility=new DatabaseUtility();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() {
		loginpage=new Login_Page(driver);
		registerpage=new Register_Page(driver);
		welcomepage=new Welcome_page(driver);
		bookspage=new Books_Page(driver);
		jewelrypage=new Jewelry_page(driver);
		computerpage=new Computers_Page(driver);
		screenshotUtility=new TakescreenshotUtility(driver);
		System.out.println("Logged in to appliaction");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromApplication() {
		System.out.println("Logged Out from the application");
	}
	
	@AfterClass(alwaysRun = true)
	public void closingTheServer() {
		driver.quit();
	}



}