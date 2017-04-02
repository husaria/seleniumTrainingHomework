import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.PortableServer.THREAD_POLICY_ID;
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
        RemaxMainPage remaxMainPage = new RemaxMainPage(driver, wait);
        remaxMainPage.selectLocation("Manitoba");
        remaxMainPage.selectPropertyByAddress("1521 10th Street");
        Thread.sleep(3000);
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
}
