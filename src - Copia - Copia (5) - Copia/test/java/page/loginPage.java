package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
    WebDriver driver;


    public loginPage(WebDriver driver) {
        this.driver = driver;

    }


    /*
     * Elementos de Tela
     * */
   private WebElement cpUsario() {
        return driver.findElement(By.id("user-name"));
   }
    private WebElement cpSenha() {
        return driver.findElement(By.id("password"));
    }

    private WebElement btnLogin() {
        return driver.findElement(By.id("login-button"));
    }



    /*
     * Metodos
     * */
    public void acessarAplicacao() {
        driver.get("https://www.saucedemo.com/");
    }

    public void nomeUsuario () {
        cpUsario().sendKeys("performance_glitch_user");
    }

    public void senhaUsuario ()  {
        cpSenha().sendKeys("secret_sauce");
    }

    public void btnLogar () {
        btnLogin().click();
    }

}