package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class RegisterPage extends AbstractComponent {
	
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	};

}
