package PadraoPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementosPage {
    private WebDriver driver;


    private By camposDeBusca = By.id("twotabsearchtextbox");
    private By botaoPesquisar = By.id("nav-search-submit-button");
    private By resultadoBusca = By.cssSelector(".a-section.a-spacing-base");
    private By btnCarrinho =  By.id("nav-cart");
    private By mensagemErroLocator = By.cssSelector(" ");

    public ElementosPage(WebDriver driver) {
        this.driver = driver;
    }
    public void abrir() {
        driver.get("https://www.amazon.com.br/ref=nav_logo");
    }

    public String preencherCampoBusca(String texto) {
        WebElement caixaDeBusca = driver.findElement(camposDeBusca);
        caixaDeBusca.sendKeys(texto);
        caixaDeBusca.getAttribute("value");
        return texto;
    }
    public void clicarBuscar() {
        driver.findElement(botaoPesquisar).click();
    }
    public void clicarCarrinho(){
        driver.findElement(By.id("nav-cart")).click();
    }
    public void clicandoProduto(){
        driver.findElement(By.cssSelector(".a-section.a-spacing-base")).click();
    }
    public void adicionandoProdutoNoCarrinho(){
        driver.findElement(By.id("add-to-cart-button")).click();
    }
    public void cliqueParairParaCarrinho(){
        driver.findElement(By.id("sw-gtc")).click();
    }

    public void cliqueFecharPedido(){
            driver.findElement(By.name("proceedToRetailCheckout")).click();
    }
    public String obterMensagemErro() {
        WebElement mensagemErro = driver.findElement(mensagemErroLocator);
        return mensagemErro.getText();
    }
//    uso esse metodo para ver as transições dos comandos que passei.
    public void contandoCincoSegundos() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }

}

