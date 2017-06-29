
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Elton
 */
public class TestePaginaConverterValores {

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
    public void testCelsiusParaFahrenheit() throws Exception {
        driver.get(baseUrl + "/Entrega01/");
        new Select(driver.findElement(By.name("tipoConversao"))).selectByVisibleText("Celsius para Fahrenheit");
        driver.findElement(By.name("valor")).clear();
        driver.findElement(By.name("valor")).sendKeys("100");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        assertEquals("O resultado da conversão foi: 212", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void testFahrenheitParaCelsius() throws Exception {
        driver.get(baseUrl + "/Entrega01/");
        new Select(driver.findElement(By.name("tipoConversao"))).selectByVisibleText("Fahrenheit para Celsius");
        driver.findElement(By.name("valor")).clear();
        driver.findElement(By.name("valor")).sendKeys("212");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        assertEquals("O resultado da conversão foi: 100", driver.findElement(By.cssSelector("h1")).getText());
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
