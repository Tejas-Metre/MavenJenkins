package PageAction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basic.BaseClass;

public class AmazonHomePageAction extends BaseClass {

	@FindBy(id = "twotabsearchtextbox")
	WebElement textbox;
	@FindBy(id = "nav-search-submit-button")
	WebElement searchBoxButton;

	public AmazonHomePageAction() {
		PageFactory.initElements(super.driver, this);
	}

	public boolean checkTitle(String expectedTitle) {
		boolean status = ad.checkTitle(expectedTitle);

		if (status)
			System.out.println("Title Matched");
		else
			System.out.println("Title not matched");
		return status;
	}
	
	
	public boolean checkURL(String expectedurl)
	{
		if(expectedurl.equals(driver.getCurrentUrl()))
		{
			System.out.println("***Url Match***");
			return true;
		}
		System.out.println("***Url Not Match****");
		return false;
	}
	
	
	
	

	public AmazonSearchedPage searchFunctionality(String searchData) {
		boolean status = ad.writeData(textbox, searchData);
		if (status) {
			this.searchBoxButton.submit();

			return new AmazonSearchedPage();
		} else
			return null;

	}

}
