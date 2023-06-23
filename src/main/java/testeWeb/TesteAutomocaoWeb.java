package testeWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteAutomocaoWeb {

    private WebDriver driver;
        @Before
        public void setUp(){
             System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Projetos\\chromedriver.exe");
             driver = new ChromeDriver();
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        @After
        public void tearDown(){
            if(driver != null){
                driver.quit();
            }
        }
        @Test
        public void automotizandoWeb() {
            driver.get("https://www.amazon.com.br/ref=nav_logo");
             WebElement caixaDeBusca = driver.findElement(By.id("twotabsearchtextbox"));

        caixaDeBusca.sendKeys("Teclado gamer");
        driver.findElement(By.id("nav-search-submit-button")).click();

            try {
                WebElement resultadoBusca = driver.findElement(By.cssSelector(".a-section.a-spacing-base"));
                String resultado = resultadoBusca.getText().toLowerCase();

                assertTrue(resultado.contains("teclado"));
                assertTrue(resultado.contains("gamer"));

            } catch (Exception e) {
                e.printStackTrace();
                assertTrue(false);
        }
        driver.close();
    }
    public static void main( String[] args ){
        TesteAutomocaoWeb teste = new TesteAutomocaoWeb();
        teste.automotizandoWeb();
    }

}



