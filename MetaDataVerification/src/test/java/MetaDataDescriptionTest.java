
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MetaDataDescriptionTest {
	
	@Test
	public void Test1() throws IOException {
		Document doc = Jsoup.connect(PropertyReader.readDataFromPropertyFile("testData.properties", "URL")).get();
		String title = doc.title();
		System.out.println("Title of the Page is: " + title);
		String keywords = doc.select("meta[name=keywords]").first().attr("content");
		System.out.println("Meta keyword : " + keywords);
		String actualDescription = doc.select("meta[name=description]").get(0).attr("content");
		System.out.println("Meta description : " + actualDescription);
		Assert.assertEquals(PropertyReader.readDataFromPropertyFile("testData.properties", "expectedDescription"), actualDescription);
	}
}
