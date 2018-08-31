package Utilities;
import org.testng.annotations.*;
 
public class TestBase {
 
    String xlFilePath = "page_data_qa2_200.xlsx";
    String sheetName = "Title";
	
	String prodPagedata = "productpageData_qa2.xlsx";
    String prodSheetName = "Description";
    
    String contentPagedata = "contentpageData_qa2.xlsx";
    String contentSheetName = "Description";
    ExcelApiTest eat = null;
    ExcelBaseSetup base;

    @DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }
    
    @DataProvider(name="metaDataProd")
    public Object[][] metaDataProd() throws Exception
    {
        Object[][] data = testData(prodPagedata, prodSheetName);
        return data;
    }
    
    @DataProvider(name="metaDataContent")
    public Object[][] metaDataContent() throws Exception
    {
        Object[][] data = testData(contentPagedata, contentSheetName);
        return data;
    }
 
    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
    {
        Object[][] excelData = null;
        eat = new ExcelApiTest(xlFilePath);
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);
 
        excelData = new Object[rows-1][columns];
 
        for(int i=1; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
            }
 
        }
        return excelData;
    }

}
