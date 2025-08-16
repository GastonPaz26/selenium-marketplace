package data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import utils.JsonUtils;

public class DataReader {

	@DataProvider(name = "compareProductsData")
	public Object[][] getData() throws IOException {
		String path = System.getProperty("user.dir")
				+ "/src/test/java/data/VerifyCompareProducts.json";
		List<HashMap<String, String>> data = JsonUtils.getJsonDataFrom(path);

		  Object[][] result = new Object[data.size()][1];
		    for (int i = 0; i < data.size(); i++) {
		        result[i][0] = data.get(i);
		    }
		return result;
	}
}
