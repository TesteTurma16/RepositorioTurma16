package steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import page.loginPage;
import page.produtosPage;
import runner.executar;

import java.io.IOException;

import static runner.executar.driver;

public class test extends executar {

    loginPage login = new loginPage(driver);
    produtosPage produtos = new produtosPage(driver);

    @Dado("que estou logado no site")
    public void queEstouLogadoNoSite()  {
     login.acessarAplicacao();
     login.nomeUsuario();
     login.senhaUsuario();
     login.btnLogar();
    }

    @Quando("selecionar o produto")
    public void selecionarOProduto() {
        produtos.produto();
    }

    @Quando("adicionar ao carrinho ]")
    public void adicionarAoCarrinho() {
        produtos.carrinho();
        produtos.checkout();
    }

    @Quando("preecher os dados de entrega")
    public void preecherOsDadosDeEntrega() {
        produtos.firstName();
        produtos.LastName();
        produtos.postalCode();
        produtos.continuar();
    }

    @Entao("realizo a compra com sucesso")
    public void realizoACompraComSucesso() throws IOException {
        produtos.finish();
        produtos.screnShoot("CT-Compra com sucesso");
    }

}