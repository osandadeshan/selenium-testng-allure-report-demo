package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.driver.DriverFactory;

import static util.PropertyFileReader.getProperty;
import static util.driver.DriverHolder.getDriver;
import static util.driver.DriverHolder.setDriver;

public class BaseTest {

    @BeforeMethod
    public void before() {
        setDriver(DriverFactory.getNewDriverInstance(getProperty("browser")));
        getDriver().manage().window().maximize();
        getDriver().get(getProperty("application_url"));
    }

    @AfterMethod
    public void after() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
