package Basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import actiondriver.ActionDriverElement;
//import actiondriver.ActionDriverClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.excel.ExtentManager;

public class BaseClass {
	public static  Properties prop;
	static public WebDriver driver;
	protected static ActionDriverElement ad= new ActionDriverElement();
	@BeforeSuite
public	void loadConfig() throws IOException
	{
		prop= new Properties();
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\config.properties";
		
		System.out.println(path);

		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		ExtentManager.setExtent();
	}

public void setUp()
{
	String browser=prop.getProperty("browsername");
	if(browser.equalsIgnoreCase("chrome"))
	{	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	
	else if(browser.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	//driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}	
	
   public  void reload()
     {
	String url=prop.getProperty("url");
	driver.get(url);
     }
	

@AfterSuite
public void close()
{
	//driver.quit();
	ExtentManager.endReport();
}

}
