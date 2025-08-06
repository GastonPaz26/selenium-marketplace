package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import AbstractComponents.AbstractComponent;

public class BaseTest {

	// Initialise variable driver de tipo Webdriver
	public WebDriver driver;
	public AbstractComponent landingPage;

	// Creo un metodo para inicializar el driver parametrizado en GlobalData
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();

		// Leemos el archivo Globaldata
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//resources//GlobalData.properties");

		// Cargamos el archivo a nuestras propiedades
		prop.load(fis);

		// Validamos que exista la propiedad Browser - En caso de ya existir la
		// utilizamos, en caso contrario se setea la misma
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		// Determinamos que driver se encuentra parametrizado
		if (browserName.contains("chrome")) {

			// ChromeOption es una clase de selenium que me permite manejar argumentos de
			// chrome
			ChromeOptions options = new ChromeOptions();
			// Procede a descargar la version de chrome que se adapte a mi cliente
			WebDriverManager.chromedriver().setup();

			// Si en el nombre del browser contiene headless, se correra el test sin abrir
			// una ventana del navegador (util para CI/CD)
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));// full screen

		}
		// Validamos si es Firefox
		else if (browserName.equalsIgnoreCase("Firefox")) {

			FirefoxOptions options = new FirefoxOptions();

			// Setup automático del driver
			WebDriverManager.firefoxdriver().setup();
			options.setProfile(new FirefoxProfile());
			options.addPreference("security.insecure_field_warning.contextual.enabled", false);
			options.addPreference("security.warn_entering_secure", false);
			options.addPreference("security.warn_entering_weak", false);
			options.addPreference("security.warn_leaving_secure", false);
			options.addPreference("security.warn_viewing_mixed", false);
			options.addPreference("security.warn_submit_insecure", false); 
			


			// Modo headless si se especifica
			if (browserName.contains("headless")) {
				options.addArguments("--headless");
			}

			// Inicializa el driver con las opciones
			driver = new FirefoxDriver(options);

			// Seguridad extra: setear el tamaño manualmente también
			driver.manage().window().setSize(new Dimension(1440, 900));
		} else if (browserName.contains("edge")) {
			EdgeOptions options = new EdgeOptions();

			// Setup automático del driver
			WebDriverManager.edgedriver().setup();

			// Modo headless si se especifica
			if (browserName.contains("headless")) {
				options.addArguments("headless"); // en Edge no lleva "--"
				options.addArguments("disable-gpu"); // opcional para headless más estable
			}

			// Tamaño de ventana como argumento
			options.addArguments("window-size=1440,900");

			// Inicializa el driver
			driver = new EdgeDriver(options);

			// Seguridad extra: setear tamaño manual
			driver.manage().window().setSize(new Dimension(1440, 900));
		}

		// Tiempo de espera general
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		String path = filePath;
		String jsonContent = FileUtils.readFileToString(new File(path),
				StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}

	@BeforeMethod
	public AbstractComponent launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new AbstractComponent(driver);
		landingPage.goToLandingPage();
		return landingPage;
	};
	 @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();  // Limpieza final por si no se cerró antes
	        }
	    }
	 
}
