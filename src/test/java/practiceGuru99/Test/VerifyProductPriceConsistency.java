package practiceGuru99.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import practicesGuru66.pageObjects.DetailProduct;
import practicesGuru66.pageObjects.MobilePage;
import practicesGuru99.TestComponents.BaseTest;

public class VerifyProductPriceConsistency extends BaseTest {
@Test
	public void ProductPriceConsistency() {

		String productToTest = "IPhone";
		MobilePage mobilePage = new MobilePage(driver);
		mobilePage.goToLandingPage();
		mobilePage.goToMobilePage();
		String priceInListingPage = mobilePage.getProductPrice(productToTest);
        System.out.println("Precio en la página de listado: " + priceInListingPage);
		DetailProduct detailProductPage = mobilePage.clickOnProductTitle(productToTest);

		String PriceOnDetailPage = detailProductPage.getProductPrice();
        System.out.println("Precio en la página de detalle: " + PriceOnDetailPage);
        Assert.assertEquals(PriceOnDetailPage, priceInListingPage, 
                "El precio del producto no coincide entre la página de listado y la página de detalle");
    }
}