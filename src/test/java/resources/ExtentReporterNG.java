package resources;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    public static ExtentReports getReportObject() {
        Path path = Paths.get(System.getProperty("user.dir"), "reports", "index.html");

        // Crea la carpeta si no existe
        File reportsDir = path.getParent().toFile();
        if (!reportsDir.exists()) {
            reportsDir.mkdirs();
        }

        ExtentSparkReporter reporter = new ExtentSparkReporter(path.toString());
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Gaston Paz");
        return extent;
    }
}
