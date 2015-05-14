package pl.test.allegro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * Created by Czarek on 2015-05-14.
 */
public class Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Page(final WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public Page navigateTo(final WebDriver driver, final String baseUrl) {
        driver.get(baseUrl);
        return new Page(driver);
    }

    public boolean isElementPresent(final WebElement element) {

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            return false;
        }
        return true;
    }

    public void insertStrings(final WebElement element, final String string) {
        element.clear();
        element.click();
        element.sendKeys(string);
    }

    public Page clickButtonElement(final WebElement element) {
        element.click();
        return new Page(driver);
    }

}
