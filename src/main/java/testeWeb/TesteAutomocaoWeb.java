package testeWeb;

import PadraoPageObject.ElementosPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TesteAutomocaoWeb {
   private  WebDriver driver;
   private ElementosPage elementosPage;
    @Before
        public void setUp(){
             System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\Projetos\\chromeDriver\\chromedriver.exe");
             driver = new ChromeDriver();
             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             elementosPage = new ElementosPage(driver);
        }
        @After
        public void tearDown(){
            if(driver != null){
                driver.quit();
            }
        }
        @Test
        public void testeBuscarProdutoSucesso() {
            elementosPage.abrir();
            elementosPage.preencherCampoBusca("Teclado gamer");
            elementosPage.clicarBuscar();
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
    public void testBtnPesquisaNaoPrecionadoInvalido() {
         elementosPage.abrir();
         String textoCampoBusca =  elementosPage.preencherCampoBusca("teclado");
         String url = driver.getCurrentUrl();
         assertEquals(url,"https://www.amazon.com.br/ref=nav_logo");
        }
    @Test
    public void testSelecionarProdutoEComprar() {
       elementosPage.abrir();
       elementosPage.preencherCampoBusca("teclado gamer");
       elementosPage.clicarBuscar();
       elementosPage.clicandoProduto();

        // adicionando produto ao carrinho
       elementosPage.adicionandoProdutoNoCarrinho();
       //  contando mais cinco segundos
       elementosPage.cliqueParairParaCarrinho();
       elementosPage.cliqueFecharPedido();
       WebElement login = driver.findElement(By.className("a-section"));

       assertTrue(login.getText().contains("Fazer login"));
    }
        @Test
    public void testProdutoNaoEncontradoInvalido() {
        elementosPage.abrir();
        elementosPage.preencherCampoBusca("ergbkdfjbgi5-789rbg4595ygrg");
        elementosPage.clicarBuscar();

        WebElement mensagemNaoEncontrado = driver.findElement(By.cssSelector(".a-row"));
        assertTrue(mensagemNaoEncontrado.isDisplayed());
        assertEquals("Nenhum resultado para ergbkdfjbgi5-789rbg4595ygrg.", mensagemNaoEncontrado.getText());
        driver.close();
    }
    @Test
    public void testCliqueNoCarrinhoSucesso() {
        elementosPage.abrir();
        elementosPage.clicarCarrinho();
        String urlCarrinho = driver.getCurrentUrl();
        assertEquals(urlCarrinho,"https://www.amazon.com.br/gp/cart/view.html?ref_=nav_cart");
        driver.close();
    }
    @Test
    public void testErroConexao() {
        elementosPage.abrir();
        elementosPage.preencherCampoBusca("monitor");
        elementosPage.clicarBuscar();
        try {
            WebElement resultadoBusca = driver.findElement(By.cssSelector(".a-section.a-spacing-base"));
        } catch (WebDriverException e) {
            assertEquals("Falha na conexão. Verifique sua conexão de rede.", e.getMessage());
        }
    }
    @Test
    public void testURLEncontradaSucesso(){
        elementosPage.abrir();
        String url = driver.getCurrentUrl();
        assertEquals(url,"https://www.amazon.com.br/ref=nav_logo");
        driver.close();
    }
    @Test
    public void testCarrinhoSemProdutoInvalido() {
        elementosPage.abrir();
        elementosPage.clicarCarrinho();
        WebElement mensagemCarrinhoZerado = driver.findElement(By.cssSelector(".a-row"));
        assertTrue(mensagemCarrinhoZerado.isDisplayed());
        assertEquals("Seu carrinho da Amazon está vazio\n" +
                "Compre ofertas do dia\n" +
                "Faça login na sua conta\n" +
                "Inscreva-se agora", mensagemCarrinhoZerado.getText());

        driver.close();
    }
}