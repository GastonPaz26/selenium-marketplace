package practicesGuru66.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import practicesGuru99.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	WebElement qtyButton;
	String productName;
	WebElement updateButton;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	};

	public WebElement waitForSuccessMsgToLoad(String produtName) {
		By successMsgBy = By.xpath("//span[normalize-space()='" + produtName + " was added to your shopping cart.']");
		waitForElementToAppear(successMsgBy);
		WebElement successMsg = driver.findElement(successMsgBy);
		return successMsg;

	};

	public WebElement waitForUpdateButton(String productName) {
		By updateButtonLocator = By.xpath("//h2[@class='product-name']//a[normalize-space(text())='" + productName
				+ "']/ancestor::tr//button[@name='update_cart_action']");

		waitForElementToAppear(updateButtonLocator);
		updateButton = driver.findElement(updateButtonLocator);
		return updateButton;
	}

	public void initializeElements(String productName) {
		waitForSuccessMsgToLoad(productName);
		String xpath = "//h2[@class='product-name']//a[normalize-space(text())='" + productName
				+ "']/ancestor::tr//input[@class='input-text qty']";

		qtyButton = driver.findElement(By.xpath(xpath));

	}

	public void setQuantity(String quantity) {

		qtyButton.clear();
		qtyButton.sendKeys(quantity);

	};

	public void clickUpdateButton(String productName) {
		updateButton.click();
	};

	public void checkQuantityExceedsLimitMessage(String productName) {
		By xpath = By.xpath("//h2[@class='product-name']//a[normalize-space(text())='" + productName
				+ "']/ancestor::tr//p[@class='item-msg error']");
		String exceedsLimitMsg = driver.findElement(xpath).getText();

		if (exceedsLimitMsg.matches("The maximum quantity allowed for purchase is \\d+\\.")) {
			System.out.println("Texto válido");
		} else {
			System.out.println("Texto Invalido");
		}

		;

	};

	public void assignInvalidQuantity(String productName, String newQty) {
		waitForSuccessMsgToLoad(productName);
		initializeElements(productName);
		setQuantity(newQty);
		waitForUpdateButton(productName);
		clickUpdateButton(productName);
		checkQuantityExceedsLimitMessage(productName);
	};
}
