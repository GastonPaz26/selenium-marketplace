package practiceGuru99.Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import practicesGuru66.pageObjects.ComparePopupPage;
import practicesGuru66.pageObjects.MobilePage;
import practicesGuru99.TestComponents.BaseTest;

public class VerifyCompareProducts extends BaseTest {
	@Test
	public void sortByName() {
		
		List<String> productList = List.of("Sony Xperia", "IPhone");

		MobilePage mobilePage = new MobilePage(driver);
		mobilePage.goToLandingPage();
		mobilePage.getTitlePage();
		mobilePage.goToMobilePage();
		for (String productos : productList) {
			mobilePage.clickAddToCompare(productos);
		}
		mobilePage.clickCompareButton();
		ComparePopupPage popup = new ComparePopupPage(driver);
		Assert.assertEquals("COMPARE PRODUCTS", popup.getHeading());
		

	};
}