package listeners;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import untils.ScreenshotUtils;

public class TestListener implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        if (instance instanceof BaseTest baseTest && baseTest.getDriver() != null) {
            try {
                String path = ScreenshotUtils.captureScreenshot(
                        baseTest.getDriver(),
                        result.getMethod().getMethodName()
                );
                LOGGER.error("FAILED: {}. Screenshot: {}", result.getName(), path);
            } catch (RuntimeException exception) {
                LOGGER.error("FAILED: {}. Screenshot capture also failed", result.getName(), exception);
            }
        } else {
            LOGGER.error("FAILED: {}", result.getName());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("PASSED: {}", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("SKIPPED {}", result.getName());
    }
}
