import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by blazar on 01.04.17.
 */
public class RemaxMainPage {
    WebDriver driver;
    WebDriverWait wait;

    public RemaxMainPage(WebDriver driver, WebDriverWait wait) {
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

    public void selectPropertyByAddress(String address) {
        By propertyImightLike = By.xpath(String.format("//dd[@class='propertyAddress' and . ='%s']/../../../dt", address));
        wait.until(ExpectedConditions.presenceOfElementLocated(propertyImightLike)).click();
    }



}
