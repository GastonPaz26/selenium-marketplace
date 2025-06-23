package practicesGuru66.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practicesGuru99.AbstractComponents.AbstractComponent;

public class DetailProduct extends AbstractComponent {
	WebDriver driver;

	public DetailProduct(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	};

	@FindBy(css = "span.price")
	WebElement productPrice;

	public String getProductPrice() {
		waitForWebElementToAppear(productPrice);
		String price = productPrice.getText().trim();
		return price;

	};
}
