package AbstractComponents;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MobilePage;

public class AbstractComponent {

	WebDriver driver;

	protected WebDriverWait wait;

	public AbstractComponent(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a[href*='mobile.html']")
	WebElement mobileLink;

	@FindBy(css = "a[skip-cart]")
	WebElement cartHeaderButton;

	public MobilePage goToMobilePage() {
		mobileLink.click();
		MobilePage mobilePage = new MobilePage(driver);
		return mobilePage;
	};

	public String getTitlePage() {

		return driver.getTitle();

	};

	public void goToLandingPage() {

		// We use http instead https to hide the security pop-ups
		driver.get("http://live.techpanda.org/index.php/");
	};

	public void waitForWebElementToAppear(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForWebElementToAppear(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void switchToNewWindow() {
		String mainWindow = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}

	// Cambia a la ventana original
	public void switchToMainWindow(String mainWindowHandle) {
		driver.switchTo().window(mainWindowHandle);
	};

	// Obtiene el handle actual
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	protected String getText(By locator) {
		return waitForVisibility(locator).getText();

	}

}
