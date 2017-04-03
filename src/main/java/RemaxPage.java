import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by blazar on 01.04.17.
 */
public class RemaxPage {
    WebDriver driver;
    WebDriverWait wait;

    public RemaxPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    By region = By.className("regionLink");

    public void selectLocation(String location) {
        By province = By.xpath(String.format("//div[@id='regionSelector']//a[.='%s']", location));
        Actions ac = new Actions(driver);
        ac.moveToElement(wait.until(ExpectedConditions.presenceOfElementLocated(region)));
        ac.click(wait.until(ExpectedConditions.presenceOfElementLocated(province)));
        ac.build().perform();
    }

    public String getAddressOfSelectedProperty(int propertyNumber) {
        By propertyAddress = By.xpath(String.format("//dd[@class='propertyAddress'][%d]", propertyNumber));
        return wait.until(ExpectedConditions.presenceOfElementLocated(propertyAddress)).getText();
    }

    public void selectProperty(int propertyNumber) {
        By selectedPropertyImage = By.xpath(String.format("//dd[@class='propertyAddress'][%d]/../../../dt", propertyNumber));
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedPropertyImage)).click();
    }

    By headerPropertyAddress = By.xpath("//h1[@itemprop='streetAddress']");

    public String getTheAddressOfPropertyFromHeader() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(headerPropertyAddress)).getText();
    }
}
