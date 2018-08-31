

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader{

	static File file ;

	static Properties prop ;
	

	//static ReadData a;
	public static String readDataFromPropertyFile(String fileName, String key){
		System.out.println(System.getProperty("user.dir"));

		try {
			
			//file = new File("testData.properties");
			file = new File(fileName);
			
			FileInputStream fileInput ;

			prop = new Properties();
			fileInput = new FileInputStream(file);

			prop.load(fileInput);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);

	}
}
