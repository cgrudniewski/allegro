package pl.test.allegro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    @FindBy(id = "main-breadcrumb-search-hits")
    private WebElement searchHits;

    @FindBy(xpath = "//section[@id='featured-offers']/article")
    private List<WebElement> singlePageItemList;

    @FindBy(xpath = "//label[@for='offerBuy4']/a/span/span")
    private WebElement nrOfNewItems;

    @FindBy(xpath = "//label[@for='offerBuy5']/a/span/span")
    private WebElement nrOfUsedItems;

    @FindBy(xpath = "//select[@id='state']/option[@value='7']")
    private WebElement mazowieckieState;

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

        if (!searchItem(page, itemToFind)) {
            Assert.assertTrue(false);
        }

        System.out.println("2. Raportowanie w logu:");

        if (page.isElementPresent(searchHits)) {
            System.out.println("\tIlo\u015bci wyszukanych przedmiot\u00f3w og\u00f3\u0142em: " + searchHits.getText());
        } else {
            Assert.assertTrue(false);
        }

        if (singlePageItemList != null) {
            System.out.println("\tIlo\u015b\u0107 wy\u015bwietlanych przedmiot\u00f3w na pierwszej stronie: " + singlePageItemList.size());
        } else {
            Assert.assertTrue(false);
        }

        if (page.isElementPresent(nrOfNewItems) && page.isElementPresent(nrOfUsedItems)) {
            System.out.println("\tIlo\u015b\u0107 przedmiot\u00f3w nowych: " + nrOfNewItems.getText() + " i u\u017cywanych: " + nrOfUsedItems.getText());
        } else {
            Assert.assertTrue(false);
        }

        if (page.isElementPresent(mazowieckieState)) {
            page.clickButtonElement(mazowieckieState);
        } else {
            Assert.assertTrue(false);
        }

        System.out.println("3. Po zaraportowaniu powy\u017cszych parametr\u00f3w wy\u015bwietlenie wszystkich element\u00f3w z lokalizacji: z mazowieckiego - OK");

        Assert.assertTrue(true);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        //driver.quit();
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
