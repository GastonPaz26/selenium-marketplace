package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class MobilePage extends AbstractComponent {

	WebDriver driver;

	public MobilePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	};

	@FindBy(css = "select[title='Sort By']")
	private WebElement sortByDropdown;

	@FindBy(xpath = "//h2[@class='product-name']/a")
	private List<WebElement> productNames;

	@FindBy(xpath = "button[@title='Compare']")
	WebElement compareButton;

	public void selectSortBy(String visibleText) {
		waitForWebElementToAppear(sortByDropdown);
		Select selectSortBy = new Select(sortByDropdown);
		selectSortBy.selectByVisibleText(visibleText);

	};

	public List<String> getProductNames() {

		List<String> productsListNames = new ArrayList<>();
		for (WebElement prod : productNames) {
			productsListNames.add(prod.getText().trim());

		}
		return productsListNames;

	};

	public String getProductPrice(String productName) {
		String priceXPath = "//a[text()='" + productName
				+ "']/ancestor::div[@class='product-info']//span[@class='price']";
		WebElement priceElement = driver.findElement(By.xpath(priceXPath));
		String productPrice = priceElement.getText();
		return productPrice;
	};

	public DetailProduct clickOnProductTitle(String productName) {
		WebElement productTitle = driver
				.findElement(By.xpath("//h2[@class='product-name']//a[@title='" + productName + "']"));
		waitForWebElementToAppear(productTitle);
		productTitle.click();
		return new DetailProduct(driver);
	};

	public void clickAddToCartFromList(String productName) {
		WebElement addButton = driver.findElement(By.xpath("//h2[@class='product-name']//a[@title='" + productName
				+ "']/ancestor::li//button[@title='Add to Cart']"));
		waitForWebElementToAppear(addButton);
		addButton.click();
	}

	public void addProductsToCompare(List<String> productList) {
	    for (String product : productList) {
	        try {
	            clickAddToCompareButton(product);
	            System.out.println("Producto agregado a la comparación: " + product);
	        } catch (NoSuchElementException | TimeoutException e) {
	            System.err.println("❌ No se encontró el producto para agregar a la comparación: " + product);
	        }
	    }
	}


	public void clickAddToCompareButton(String productName) {
		By addToCompareButton = By
				.xpath("//a[@title='" + productName + "']/following::a[contains(text(),'Add to Compare')]");
		waitForWebElementToAppear(addToCompareButton);
		driver.findElement(addToCompareButton).click();

	}

	public void clickCompareRedirectButton() {
		WebElement clickCompareRedirectButton = driver.findElement(By.xpath("//button[@title='Compare']"));
		waitForWebElementToAppear(clickCompareRedirectButton);
		clickCompareRedirectButton.click();
		
	}

	public void windowsHandle() {

		String maninWindow = driver.getWindowHandle();

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(maninWindow)) {
				switchToNewWindow();
				break;
			}
			;
		}
		;

	};

	public void verifyPage() {
		String heading = driver.findElement(By.tagName("h1")).getText();

		Assert.assertEquals("COMPARE PRODUCTS", heading);

	};

}
