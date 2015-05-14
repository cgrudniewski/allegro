package pl.test.allegro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * Created by Czarek on 2015-05-14.
 */
public class AllegroTest {

    private WebDriver driver;
    private String baseUrl = "http://allegro.pl";

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver(FirefoxDriverConf.getFirefoxProfileConfiguration());
        PageFactory.initElements(driver, this);
    }

    @Test
    public void test() {
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
