package Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComparePopupPage;
import pageObjects.MobilePage;
import utils.AssertUtils;
import TestComponents.BaseTest;

public class VerifyCompareProducts extends BaseTest {
	@Test
	public void sortByName() {

		List<String> productList = List.of("Sony Xperia", "IPhone");

		MobilePage mobilePage = new MobilePage(driver);
		mobilePage.goToLandingPage();
		mobilePage.getTitlePage();
		mobilePage.goToMobilePage();
		mobilePage.addProductsToCompare(productList);
		mobilePage.clickCompareRedirectButton();

		ComparePopupPage popup = new ComparePopupPage(driver);
		Assert.assertEquals(popup.getHeading(), "COMPARE PRODUCTS");
		System.out.println(popup.getAllProductNames());
		AssertUtils.assertListsEqualTrimmedIgnoreCase(productList, popup.getAllProductNames());

	};
	
	
	
}