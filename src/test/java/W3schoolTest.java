import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by blazar on 30.03.17.
 */
public class W3schoolTest {

    private static WebDriver driver;

    @BeforeClass
    public static void initializeWebDriver() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void checkCityForWolskiZajazd() throws InterruptedException {
        driver.get("https://www.w3schools.com/xml/ajax_database.asp");
        driver.manage().window().maximize();
        W3schoolPage w3schoolPage = new W3schoolPage(driver);
        Select dropDownSelect = new Select(w3schoolPage.dropDown);
        w3schoolPage.selectOptionFromDropdown("Wolski Zajazd", dropDownSelect);
        Thread.sleep(3000);
    }
}
