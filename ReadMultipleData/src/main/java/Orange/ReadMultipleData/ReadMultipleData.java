package Orange.ReadMultipleData;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ReadMultipleData {
	
	
	public WebDriver driver;
	  String	application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard\"";
	 
	 FileInputStream file;
	XSSFWorkbook workbook;
	 XSSFSheet sheet;
	 
	 
	@BeforeTest
	 public void setUp() throws InterruptedException
	 {
		System.setProperty("webdriver.chrome.driver","./DriverFiles1/chromedriver.exe");
		
		 driver=new ChromeDriver();
		 driver.get(application_URL);
		 
		 driver.manage().window().maximize();
		 
		 Thread.sleep(3000);
		 
	 }

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	}
	


