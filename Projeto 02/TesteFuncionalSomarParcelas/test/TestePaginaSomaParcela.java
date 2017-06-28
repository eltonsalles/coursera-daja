import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 *
 * @author Elton
 */
public class TestePaginaSomaParcela {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        // Setado essa propriedade porque os testes estão sendo execudados com o firefox 46 (32bits)
        System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");

        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception {
        driver.get(baseUrl + "/SomarParcelas/");
        driver.findElement(By.name("p1")).clear();
        driver.findElement(By.name("p1")).sendKeys("12");
        driver.findElement(By.name("p2")).clear();
        driver.findElement(By.name("p2")).sendKeys("33");
        driver.findElement(By.name("Calcular")).click();
        assertEquals("O resultado da soma é: 45", driver.findElement(By.cssSelector("h1")).getText());
    }
    
    @Test
    public void test2() throws Exception {
        driver.get(baseUrl + "/SomarParcelas/");
        driver.findElement(By.name("p1")).clear();
        driver.findElement(By.name("p1")).sendKeys("10");
        driver.findElement(By.name("p2")).clear();
        driver.findElement(By.name("p2")).sendKeys("10");
        driver.findElement(By.name("Calcular")).click();
        assertEquals("O resultado da soma é: 20", driver.findElement(By.cssSelector("h1")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
