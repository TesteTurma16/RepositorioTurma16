package page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class produtosPage {

    WebDriver driver;
/*
* Inicialização de broswer
* */
    public produtosPage(WebDriver driver) {
        this.driver = driver;

    }



    /*
     * Elementos de Tela
     * */
    private WebElement produtoSelecionado() {
        return driver.findElement(By.xpath("//button[text()='Add to cart']"));
    }

    private WebElement carrinhoDeCompras() {
        return driver.findElement(By.xpath("//a[@class='shopping_cart_link'][contains(.,'1')]"));

    }

    private WebElement btnCheckout() {
        return driver.findElement(By.id("checkout"));
    }

    private WebElement cpFirsName() {
        return driver.findElement(By.id("first-name"));
    }

    private WebElement cpLastName() {
        return driver.findElement(By.id("last-name"));
    }

    private WebElement cpPostalCode() {
        return driver.findElement(By.id("postal-code"));
    }

    private WebElement btnContinue() {
        return driver.findElement(By.id("continue"));
    }

    private WebElement btnFinish() {
        return driver.findElement(By.id("finish"));
    }



    /*
     * Metodos
     * */
    public void produto(){
        produtoSelecionado().click();
    }

    public void carrinho(){
        carrinhoDeCompras().click();
    }

    public void checkout() {
        btnCheckout().click();
    }

    public void firstName() {
        cpFirsName().sendKeys("Matheus argolo");
    }

    public void LastName() {
        cpLastName().sendKeys("Matheus argolo");
    }

    public void postalCode() {
        cpPostalCode().sendKeys("04444589");
    }

    public void continuar() {
        btnContinue().click();
    }

    public void finish() {
        btnFinish().click();
        String TextoElemento = driver.findElement(By.xpath("//h2[@class='complete-header'][contains(.,'THANK YOU FOR YOUR ORDER')]")).getText();
        assertEquals("THANK YOU FOR YOUR ORDER", TextoElemento);
    }

    /*
     * Metodo de print
     * */
    public void screnShoot(String nome) throws IOException {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./src/evidencia/" + nome + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

}
