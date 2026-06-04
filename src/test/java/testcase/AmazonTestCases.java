package testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Basic.BaseClass;
import PageAction.AmazonHomePageAction;
import PageAction.AmazonSearchedPage;
import dataproviders.DataProviderClass;
import utilities.excel.ListenerClass;

@Listeners(value={ListenerClass.class})
public class AmazonTestCases extends BaseClass {
	
	
	
	AmazonHomePageAction ap;
	
	@BeforeClass
	public void beforeClass()
	{
		setUp();
		
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		//reload();
		reload();
	}
	
	@AfterClass
	public void afterClass()
	{
		//close();
	}
	
	@Parameters("titles1")
	@Test
	public void verifyTitle(String expectedTitle) throws InterruptedException
	{
		 ap=new AmazonHomePageAction();
		 Thread.sleep(3000);
		 System.out.println("Expected: " + expectedTitle);
		    System.out.println("Actual: " + driver.getTitle());

		 Assert.assertTrue(ap.checkTitle(expectedTitle));
	}
	
	@Test()
	public void verifyURL()
	{
		//gp= new GooglePage();
		//System.out.println("Url status : "+gp.checkURL(prop.getProperty("url")));
		Assert.assertTrue(ap.checkURL(prop.getProperty("url")));
	}
	
	
	
	
	//@Test(priority=2, timeOut = 200,dependsOnMethods = {"verifyTitle"},dataProvider = "getSearchData",dataProviderClass =DataProviderClass.class )
	//@Parameters("title2")
	//@Test(priority=2,dependsOnMethods = {"verifyTitle"},dataProvider="getData",dataProviderClass=DataGivers.class)
	
	/*@Test(priority=2,dependsOnMethods = {"verifyTitle"})
	void AmazonsearchProcess(String expectedTitle)
	{
		AmazonSearchedPage sp=ap.searchFunctionality("Laptop");
		//Assert.assertTrue(sp.checkTitle("Amazon.in : Laptop"));
		 Assert.assertTrue(ap.checkTitle(expectedTitle));
		 }
		 */
	
/*
	@Test(priority=2,dependsOnMethods = {"verifyTitle"},dataProvider = "getData",dataProviderClass =DataGivers.class )
	void searchProcess(String expectedTitle,String data )
	{
		AmazonSearchedPage sp=ap.searchFunctionality(data);
		
		Assert.assertTrue(sp.checkTitle(expectedTitle));
		//System.out.println("Search Textbox content : "+sp.searchData(data));

	System.out.println("Search textbox content:");
	sp.searchData(data);
	}
	*/
	
	
	//@Parameters("watchTitle1")
	@Test(priority = 2,/*dependsOnMethods = {"verifyTitle"},*/dataProvider = "getSearchData", dataProviderClass = DataProviderClass.class)
	public	void verifyDataSearch(String data)
	{
		//String SearchData="STAD Solution";
		ap= new AmazonHomePageAction();
		AmazonSearchedPage asp=ap.searchFunctionality(data);		
		System.out.println("Search page title status : "+asp.checkTitle("Amazon.in : Watches"));
		//System.out.println("*Title*");
		//asp.checkTitle(data);
		System.out.println("Search Textbox content : ");
		asp.searchData(data);	
		
	}
	
	
	
	


}
