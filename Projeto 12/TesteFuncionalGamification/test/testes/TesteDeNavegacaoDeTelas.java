package testes;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Elton
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteDeNavegacaoDeTelas {

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
        // Testa o login
        driver.get(baseUrl + "/Gamification/login");
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("glebson");
        driver.findElement(By.name("senha")).clear();
        driver.findElement(By.name("senha")).sendKeys("123");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        assertEquals("Tópicos", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void test2() throws Exception {
        // Testa a página do ranking
        driver.get(baseUrl + "/Gamification/topico");
        driver.findElement(By.linkText("Ranking")).click();
        assertEquals("Ranking", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void test3() throws Exception {
        // Testa a exibição do tópico 1
        driver.get(baseUrl + "/Gamification/topico");
        driver.findElement(By.linkText("Topico 1")).click();
        assertEquals("Título: Topico 1 - tópico criado por Paulo Jr", driver.findElement(By.cssSelector("h3")).getText());
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
