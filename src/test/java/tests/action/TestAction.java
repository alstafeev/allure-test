package tests.action;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAction {

    @Test(testName = "OPEN URL")
    @Parameters({"url", "browser", "environment"})
    public void openUrl(String url, String browser, String environment) {

        System.out.println(url);
        System.out.println(browser);
        System.out.println(environment);

        Assert.assertTrue(true);
    }

}
