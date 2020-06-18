package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestExecutor {

    private static final String SUITE_DIR = "suites/";
    private static final Logger LOG = LogManager.getLogger(TestExecutor.class.getName());

    @Test(testName = "TEST EXECUTOR")
    public void execute() {
        try (Stream<Path> walk = Files.walk(Paths.get(SUITE_DIR))) {
            List<String> suites = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            TestNG testNg = new TestNG();
            testNg.setSuiteThreadPoolSize(suites.size());
            testNg.setTestSuites(suites);
            testNg.run();
        } catch (IOException e) {
            LOG.error("fail to load test suite conf", e);
        }
    }
}