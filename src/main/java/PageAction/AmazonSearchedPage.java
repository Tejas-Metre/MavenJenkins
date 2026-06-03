package PageAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basic.BaseClass;

public class AmazonSearchedPage  extends BaseClass{
	@FindBy(id="twotabsearchtextbox")
	WebElement textbox;
	
	
	
	public AmazonSearchedPage()
	{
		PageFactory.initElements(super.driver, this);
		
	}
	
	public boolean checkTitle(String expectedTitle)
	{
		boolean status =ad.checkTitle(expectedTitle);
		
		if(status)
			System.out.println("Title Matched");
		else
			System.out.println("Title not matched");
		return status;
	}
	
	public void checkUrl(String expectedURL)
	{
		String actualURL=driver.getCurrentUrl();
		if(actualURL.equals(expectedURL))
			System.out.println("URL Matched");
		else
			System.out.println("URL not matched");
	}
	
	
	public void searchData(String searchData)
	{
		if(textbox.isDisplayed() && textbox.isEnabled())
		{
			String actualdata=textbox.getAttribute("value");
			if(actualdata.equals(searchData))
				System.out.println("Data Matched");
			else
				System.out.println("Data Not Matched");//
		
		}
		else
			System.out.println("Search functionality not working");
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
