package testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import utilities.excel.ListenerClass;

import Basic.BaseClass;
import PageAction.AmazonHomePageAction;
import PageAction.AmazonSearchedPage;
import dataproviders.DataProviderClass;

@Listeners(value={ListenerClass.class})
public class AmazonTestCases extends BaseClass {
	
	
	
	AmazonHomePageAction ap;
	
	@BeforeClass
	void beforeClass()
	{
		setUp();
		
	}
	
	@BeforeMethod
	void beforeMethod()
	{
		//reload();
		reload();
	}
	
	@AfterClass
	void afterClass()
	{
		//close();
	}
	
	@Parameters("title1")
	@Test
	void verifyTitle(String expectedTitle)
	{
		 ap=new AmazonHomePageAction();
		 Assert.assertTrue(ap.checkTitle(expectedTitle));
	}
	
	@Test()
	void verifyURL()
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
	@Test(priority = 2,dependsOnMethods = {"verifyTitle"},dataProvider = "getSearchData", dataProviderClass = DataProviderClass.class)
	void verifyDataSearch(String data)
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
