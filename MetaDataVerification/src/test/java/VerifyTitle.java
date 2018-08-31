import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitle
{
	@Test
	public void Test1() throws IOException
	{
		Document doc = Jsoup.connect(PropertyReader.readDataFromPropertyFile("title.properties", "URL1")).get();
		String title = doc.title();
		Assert.assertEquals(title, PropertyReader.readDataFromPropertyFile("title.properties", "ExpectedTitle1"));
	}
	
	@Test
	public void Test2() throws IOException
	{
		Document doc = Jsoup.connect(PropertyReader.readDataFromPropertyFile("title.properties", "URL2")).get();
		String title = doc.title();
		Assert.assertEquals(title, PropertyReader.readDataFromPropertyFile("title.properties", "ExpectedTitle2"));
	}
	
	@Test
	public void Test3() throws IOException
	{
		Document doc = Jsoup.connect(PropertyReader.readDataFromPropertyFile("title.properties", "URL3")).get();
		String title = doc.title();
		Assert.assertEquals(title, PropertyReader.readDataFromPropertyFile("title.properties", "ExpectedTitle3"));
	}
}
