package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {

	public WebDriver driver;
	public Helpers(WebDriver driver) {
	    this.driver = driver;
	}


	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		Path reportsDir = Path.of(System.getProperty("user.dir"), "reports");
		if (!Files.exists(reportsDir))
			Files.createDirectories(reportsDir);

		File source = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String stamp = java.time.LocalDateTime.now()
				.format(java.time.format.DateTimeFormatter
						.ofPattern("yyyyMMdd_HHmmss"));
		File dest = reportsDir.resolve(testCaseName + "-" + stamp + ".png")
				.toFile();
		
		FileUtils.copyFile(source, dest);
		System.out.println("Screenshot guardado en: " + dest.getAbsolutePath());
		return dest.getAbsolutePath();
	}
}
