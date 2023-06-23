package PadraoPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementosPage {
    private WebDriver driver;

    private By camposDeBusca = By.id("twotabsearchtextbox");
    private By botaoPesquisar = By.id("nav-search-submit-button");
    private By resultadoBusca = By.cssSelector(".a-section.a-spacing-base");
    private By mensagemNaoEncontrado = By.cssSelector(".a-row");
    private By btnCarrinho =  By.id("nav-cart");
    public ElementosPage(WebDriver driver) {
        this.driver = driver;
    }
    public void abrir() {
        driver.get("https://www.amazon.com.br/ref=nav_logo");
    }
    public void preencherCampoBusca(String texto) {
        WebElement caixaDeBusca = driver.findElement(camposDeBusca);
        caixaDeBusca.sendKeys(texto);
    }
    public void clicarBuscar() {
        driver.findElement(botaoPesquisar).click();
    }
    public void clicarCarrinho(){
        driver.findElement(By.id("nav-cart")).click();
    }
}

