import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.TestBase;
 
public class TestTitle extends TestBase{
 
    @Test(dataProvider = "userData")
    public void VerifyTitle(String URL, String Title) throws IOException
    {	
    	Document doc = Jsoup.connect(URL).get();
		String title = doc.title();
		Assert.assertEquals(title, Title);
    }
    
    @Test(dataProvider = "metaDataProd")
    public void VerifyMetaDataProd(String URL, String Description) throws IOException
    {	
    	Document doc = Jsoup.connect(URL).get();
		String actualDescription = doc.select("meta[name=description]").get(0).attr("content");
		System.out.println("Meta description : " + actualDescription);
		Assert.assertEquals(actualDescription, Description);
    }
    
    @Test(dataProvider = "metaDataContent")
    public void VerifyMetaDataContent(String URL, String Description) throws IOException
    {	
    	Document doc = Jsoup.connect(URL).get();
		String actualDescription = doc.select("meta[name=description]").get(0).attr("content");
		System.out.println("Meta description : " + actualDescription);
		Assert.assertEquals(actualDescription, Description);
    }
    
    @Test
    public void te() {
    	Stream<Integer> st = Stream.of(1,2,3,5,6,4,6,7);
    	List<Integer> li = st.collect(Collectors.toList());
    	Collections.sort(li);
    	System.out.println(li);
    }
    
    @Test
    public void te2() 
    {
    	Stream<Integer> st = Stream.of(1,2,3,5,6,4,6,7);
    	Set<Integer> li = st.collect(Collectors.toSet());
    	System.out.println(li);
    }
}
