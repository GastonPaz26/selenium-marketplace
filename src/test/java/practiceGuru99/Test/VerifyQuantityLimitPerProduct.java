package practiceGuru99.Test;

import org.testng.annotations.Test;

import practicesGuru66.pageObjects.CartPage;
import practicesGuru66.pageObjects.MobilePage;
import practicesGuru99.TestComponents.BaseTest;

public class VerifyQuantityLimitPerProduct extends BaseTest {
	@Test

	public void QuantityLimit() {
		String productName = "Sony Xperia";
		MobilePage mobilePage = new MobilePage(driver);
		mobilePage.goToLandingPage();
		mobilePage.goToMobilePage();
		mobilePage.clickAddToCartFromList(productName);

		CartPage cartPage = new CartPage(driver);
		cartPage.waitForSuccessMsgToLoad(productName);

		cartPage.initializeElements(productName);
		cartPage.assignInvalidQuantity(productName, "1000");

	};

}
