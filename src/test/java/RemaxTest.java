import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by blazar on 01.04.17.
 */
public class RemaxTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void initializeWebdriver() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void checkIfCorrectPropertyIsSelected() throws InterruptedException {
        driver.get("https://www.remax.ca/");
        driver.manage().window().maximize();
        RemaxPage remaxPage = new RemaxPage(driver, wait);
        String location = "Manitoba";
        int noOfPropertyOnSlider = 2;
        remaxPage.selectLocation(location);
        String addressFromSlider = remaxPage.getAddressOfSelectedProperty(noOfPropertyOnSlider - 1);
        remaxPage.selectProperty(noOfPropertyOnSlider - 1);
        String fullAddressOfSelectedProperty = remaxPage.getTheAddressOfPropertyFromHeader();
        System.out.println(String.format("Address on selection slider: %s", addressFromSlider));
        System.out.println(String.format("Address on property's page: %s", fullAddressOfSelectedProperty));
        Assert.assertTrue(
                "Address on selection page is different than on property's page!",
                fullAddressOfSelectedProperty.contains(addressFromSlider)
                );
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
}
