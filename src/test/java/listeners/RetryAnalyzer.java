package listeners;

import config.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final Logger LOGGER = LogManager.getLogger(RetryAnalyzer.class);

    private int retryCount;
    private final int maxRetryCount = ConfigReader.getInstance().getRetryCount();

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount >= maxRetryCount) {
            return false;
        }

        retryCount++;
        LOGGER.warn(
                "Retrying test {} - attempt {} of {}",
                result.getName(),
                retryCount,
                maxRetryCount
        );
        return true;
    }
}
