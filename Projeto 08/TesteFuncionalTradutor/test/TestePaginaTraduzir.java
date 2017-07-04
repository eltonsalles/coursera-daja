import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Elton
 */
public class TestePaginaTraduzir {

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
    public void testE1() throws Exception {
        driver.get(baseUrl + "/Tradutor/");
        driver.findElement(By.name("palavra")).clear();
        driver.findElement(By.name("palavra")).sendKeys("caixa");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        assertEquals("A tradução da palavra caixa é cashier", driver.findElement(By.xpath("//h4[3]")).getText());
    }

    @Test
    public void testE2() throws Exception {
        driver.get(baseUrl + "/Tradutor/");
        driver.findElement(By.name("palavra")).clear();
        driver.findElement(By.name("palavra")).sendKeys("dog");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        assertEquals("A tradução da palavra dog é cachorro", driver.findElement(By.xpath("//h4[3]")).getText());
    }

    @Test
    public void testE3() throws Exception {
        driver.get(baseUrl + "/Tradutor/");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        assertEquals("Informe uma palavra!", driver.findElement(By.cssSelector("h4")).getText());
    }

    @Test
    public void testE4() throws Exception {
        driver.get(baseUrl + "/Tradutor/");
        driver.findElement(By.name("palavra")).clear();
        driver.findElement(By.name("palavra")).sendKeys("mulher");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        assertEquals("A tradução da palavra mulher não foi encontrada!", driver.findElement(By.xpath("//h4[2]")).getText());
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
