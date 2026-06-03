package actiondriver;

import org.openqa.selenium.WebElement;

import Basic.BaseClass;

public class ActionDriverElement extends BaseClass{
	

	public boolean  writeData(WebElement ele, String data)
	{
		/*
		 * 1. find Element
		 * 2. call send key
		 * 3. write data
		 * */
		if(ele.isDisplayed() && ele.isEnabled())
		{
			ele.sendKeys(data);
			return true;
		}
		else
		{
			System.out.println("Element not found");
			return false;
		}

	}
	
	/*
	public String fetchData(WebElement ele)
	{
		if(ele.isDisplayed() && ele.isEnabled())
		{
		return ele.getText();
		}
		else
		{
			System.out.println("Element not found");
			return "no data found";
		}
	}
	*/
	
	public boolean checkTitle(String ExpectedTitle)
	{
		return ExpectedTitle.equals(driver.getTitle());
	}

	public static String getScreenShot(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}