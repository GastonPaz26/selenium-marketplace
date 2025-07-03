package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ComparePopupPage extends AbstractComponent {
	WebDriver driver;

	public ComparePopupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};

	private By title = By.cssSelector("div.page-title h1");

	@FindBy(xpath = "//h2[@class='product-name']/a")
	private List<WebElement> productNames;

	public String getHeading() {
		switchToNewWindow();
		return getText(title);
	};

	
	
	public List<String> getAllProductNames() {
		switchToNewWindow();

		List<String> names = new ArrayList<>();
		for (WebElement product : productNames) {
			// Obtengo el texto visible de cada producto
			names.add(product.getText().toString().toLowerCase().trim());
		}
		return names;
		
	}
	
	

}
