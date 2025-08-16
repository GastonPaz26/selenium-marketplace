package Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComparePopupPage;
import pageObjects.MobilePage;
import utils.AssertUtils;
import TestComponents.BaseTest;

public class VerifyCompareProducts extends BaseTest {
	
	@Test(dataProvider = "compareProductsData", dataProviderClass = data.DataReader.class, groups= {"Smoke Test"})
	public void sortByName(HashMap<String, String> input)
			throws IOException, InterruptedException {

		List<String> productList = List.of(input.get("product1"),
				input.get("product2"));
		System.out.println(productList);

		MobilePage mobilePage = new MobilePage(driver);
		mobilePage.goToLandingPage();
		mobilePage.getTitlePage();
		mobilePage.goToMobilePage();
		mobilePage.addProductsToCompare(productList);
		mobilePage.clickCompareRedirectButton();

		ComparePopupPage popup = new ComparePopupPage(driver);
		Assert.assertEquals(popup.getHeading(), "COMPARE PRODUCTS");
		System.out.println(popup.getAllProductNames());
		AssertUtils.assertListsEqualTrimmedIgnoreCase(productList,
				popup.getAllProductNames());

	};

}