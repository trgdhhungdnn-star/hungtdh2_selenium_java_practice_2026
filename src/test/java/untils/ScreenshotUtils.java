package untils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtils {
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    private ScreenshotUtils() {
    }

    public static String captureScreenshot(WebDriver driver, String testName) {
        String safeTestName = testName.replaceAll("[^a-zA-Z0-9._-]", "_");
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
        Path screenshotDirectory = Path.of("reports", "screenshots");
        Path destination = screenshotDirectory.resolve(safeTestName + "_" + timestamp + ".png");

        try {
            Files.createDirectories(screenshotDirectory);
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            return destination.toString();
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot capture screenshot for: " + testName, exception);
        }
    }
}
