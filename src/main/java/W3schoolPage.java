import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    public void selectOptionFromDropdown(String option, Select dropDownSelect) {
        dropDownSelect.selectByVisibleText(option);
    }
}