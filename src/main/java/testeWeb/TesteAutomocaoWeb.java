package testeWeb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;





public class TesteAutomocaoWeb {

     WebDriver driver;

    @Before
        public void setUp(){
             System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Projetos\\chromeDriver\\chromedriver.exe");
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

        public void testeBuscarProdutoSucesso() {
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
    @Test
    public void testProdutoNaoEncontradoInvalido() {
        driver.get("https://www.amazon.com.br/ref=nav_logo");

        WebElement caixaDeBusca = driver.findElement(By.id("twotabsearchtextbox"));
        caixaDeBusca.sendKeys("ergbkdfjbgi5-789rbg4595ygrg");

        driver.findElement(By.id("nav-search-submit-button")).click();

        WebElement mensagemNaoEncontrado = driver.findElement(By.cssSelector(".a-row"));
        assertTrue(mensagemNaoEncontrado.isDisplayed());
        assertEquals("Nenhum resultado para ergbkdfjbgi5-789rbg4595ygrg.", mensagemNaoEncontrado.getText());

        driver.close();
    }
    @Test
    public void testeURLSucesso(){
        driver.get("https://www.amazon.com.br/ref=nav_logo");
        String url = driver.getCurrentUrl();
        assertEquals(url,"https://www.amazon.com.br/ref=nav_logo");

        driver.close();
    }


}

