package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Feature/",
        glue = "steps",
        tags = "@testSwagLabs",
        plugin = { "pretty", "html:target/report.html" },
        monochrome = true,
        snippets = SnippetType.CAMELCASE
)

public class executar {

    public static WebDriver driver;

    @BeforeClass
    public static void start (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Iniciou");

    }
    @AfterClass
    public static void stop() throws InterruptedException {
        Thread.sleep(40000000);
        driver.quit();

    }
}