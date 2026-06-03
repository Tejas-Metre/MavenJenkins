package dataproviders;

import org.testng.annotations.DataProvider;

public class DataGivers {

	@DataProvider
	Object[][] getData() {
		Object[][] obj = { 	{ "Amazon.in : Laptop", "Laptop" }, 
							{ "Amazon.in : Samsung", "Samsung" },
							{ "Amazon.in : Watches", "Watches" }
				};
		return obj;
	}

}
