package testBase;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public Logger logger;
	public WebDriver driver;
	public Properties p; // to read the config.properties
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException {
		
//		loading properties file
		FileReader file=  new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
//		loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		
		if (br.equalsIgnoreCase("chrome")){
		driver = new ChromeDriver();
		}else if(br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void popupHandle() {
		try {
		driver.findElement(By.xpath("//a[@class='nostyle']")).click();
		}catch(Exception e) {
			
		}
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return (generatedString +generatedNumber);
	}
	
	// to select dropdown using index
	
	public int randomNumber(int n) {
		int a=0;
		boolean flag = true;
		while(flag) {
			a =(int)(Math.random()* 1000); //b/w 0.0-1.0
			
			if(a<n && a>0) {
				flag= false;
			}
		}
		return a;
	}
	
	
	public void screenshot(String name) {
		String loc=System.getProperty("user.dir")+"\\Screenshots\\"+name+ ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		  	File trg=new File(loc);
		      FileUtils.copyFile(src,trg);
		  } catch (IOException e) {
		      System.out.println(e.getMessage());
		  }	
	}
	
	public void scrolling(int y) {
		new Actions(driver).scrollByAmount(0,y).perform();
	}
	
}
