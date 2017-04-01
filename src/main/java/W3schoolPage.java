import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by blazar on 30.03.17.
 */
public class W3schoolPage {
    WebDriver driver;

    public W3schoolPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "customers")
    public WebElement dropDown;

    String cityNameFieldXpath = "//tr[./td/b[.='City']]/td[@valign]";


    public void selectOptionFromDropdown(String option, Select dropDownSelect) {
        dropDownSelect.selectByVisibleText(option);
    }

    public WebElement waitFluentlyForElementByXpath(String xpath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xpath));
            }
        });
        return foo;

    }
}