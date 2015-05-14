package pl.test.allegro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(id = "main-search-text")
    private WebElement inputItemName;

    @FindBy(xpath = "//form[@id='main-search']/input[@type='submit']")
    private WebElement submitButton;

    private final String itemToFind = "gitara";

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver(FirefoxDriverConf.getFirefoxProfileConfiguration());
        PageFactory.initElements(driver, this);
    }

    @Test
    public void test() {

        Page page = new Page(driver);

        page.navigateTo(driver, baseUrl);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean searchItem(final Page page, final String itemToFind) {

        if (page.isElementPresent(inputItemName)) {
            page.insertStrings(inputItemName, itemToFind);
            page.clickButtonElement(submitButton);

            System.out.println("1. Wyszukiwanie na allegro przedmiotu zdefiniowanego jako parametr funkcji - OK");

            return true;
        }

        return false;
    }
}
