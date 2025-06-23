package practicesGuru66.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import practicesGuru99.AbstractComponents.AbstractComponent;

public class ComparePopupPage extends AbstractComponent {
	WebDriver driver;

	public ComparePopupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};

	private By title = By.cssSelector("div.page-title h1");

	public String getHeading() {
		return getText(title);
	};

	public String getProductName(By locator) {
		
		By productLocator = By.xpath("//h2/a[@title='" + productTitle + "']");
		return getText(locator);
	}

	public void comparePareducts(List<String> ProductList) {
		
		List<String> actualTitles = new ArrayList<>();

		for (String product : ProductList) {
			String productName = getProductName(title);
			actualTitles.add(productName);

			System.out.println(product); // imprime cada producto
		}

	};

}
