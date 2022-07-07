package BasePack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class BaseClass {
	
	//	String driverPath= "E:\\chromedriver_win32 (3)\\chromedriver.exe";
		public static WebDriver driver;
		
		public void screenShot(String TestName)  {
			String check= System.getProperty("user.dir")+"/Screenshot/";
			System.out.println(check);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source= ts.getScreenshotAs(OutputType.FILE);
			File Destination= new File(System.getProperty("user.dir")+"/Screenshot/"+TestName+".png");
			try {
				FileUtils.copyFile(source, Destination);
				Reporter.log("<br><img src='"+Destination+"' height='400' width='400'/><br>");
			} catch (IOException e) {			
				e.printStackTrace();
			}
			
		}
		
		
		@BeforeTest()
			public void setUp() {
				System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32 (3)\\chromedriver.exe");
				 driver= new ChromeDriver();
				 driver.get("https://www.facebook.com");
			}
		
			@Test
			public void Test1() {	
				Assert.assertEquals(false, false);
				Reporter.log("test1 is complete", true);
				
			}
		
			@Test
			public void Test2() {
				Assert.assertTrue(true);
				Reporter.log("test2 is complete", true);
			}
			
			
			
			
	/*		@AfterMethod
			public void screenShot(ITestResult tr) throws WebDriverException, IOException {
				
				 Reporter.log("after method execution started", true);
				String name= tr.getMethod().getMethodName();
				try {
					File destination= new File(System.getProperty("user.dir")+"/Screenshot/"+name+".png");
					FileOutputStream os=new FileOutputStream(destination);
					TakesScreenshot ts= (TakesScreenshot)driver;
					os.write(ts.getScreenshotAs(OutputType.BYTES));
					os.close();	
					
					Reporter.log("<a href='"+destination.getAbsolutePath()+"'><img src='"+destination.getAbsolutePath()+"' height='400' width='400'/> </a>");
				
					Reporter.log("after method execution ended", true);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			*/
			
			@AfterTest
			public void tearDown() {
				driver.close();
			}
}
	
