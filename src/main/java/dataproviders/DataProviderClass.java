package dataproviders;




import org.testng.annotations.DataProvider;

import utilities.excel.NewExcelLibrary;




public class DataProviderClass {
	
	NewExcelLibrary obj = new NewExcelLibrary();
	
	
	@DataProvider
	public Object[][] getSearchData() {
		// Totals rows count
		int rows = obj.getRowCount("SearchData");
		// Total Columns
		int column = obj.getColumnCount("SearchData");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("SearchData", j, i + 2);
			}
		}
		return data;
	}

}
