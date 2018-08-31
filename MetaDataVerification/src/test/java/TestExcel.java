import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExcel {
	
	@Test(dataProvider="Authentication")
	public void Test1(String sURL, String sTitle) throws IOException
	{
		Document doc = Jsoup.connect(sURL).get();
		String title = doc.title();
		Assert.assertEquals(title, sTitle);
	}
	
	@DataProvider	 
    public Object[][] Authentication() throws Exception{
 
         Object[][] testObjArray = ExcelUtils.getTableArray("Test.xlsx","Title");
 
         return (testObjArray);
 
		}

}
