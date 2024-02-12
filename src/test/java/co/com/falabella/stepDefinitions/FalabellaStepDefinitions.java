package co.com.falabella.stepDefinitions;

import java.util.List;

import co.com.falabella.models.DataSession;
import co.com.falabella.tasks.SearchProductTask;
import co.com.falabella.tasks.popUpsTask;
import co.com.falabella.tasks.purchaseTask;
import io.cucumber.datatable.DataTable;
import java.time.Duration;
import java.util.Set;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import static co.com.falabella.userinterfaces.FalabellaPage.ACCEPT_BUTTON;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class FalabellaStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver webDriver;
    private final Actor userAutomation = Actor.named("userAutomation");

    @Before
    public void prepareActorStage() {
        WebDriverManager.chromedriver().setup(); // Configuración del WebDriver
        OnStage.setTheStage(new OnlineCast()); // Configuración de los actores

        // Configuración de habilidades del actor
        userAutomation.can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
    }


    @Given("i enter to falabella")
    public void iEnterToFalabella() {
        userAutomation.wasAbleTo(
                Open.url("https://www.falabella.com.co/falabella-co")
        );
    }

    @And("close the popups")
    public void closeThePopups() {

        //userAutomation.wasAbleTo(popUpsTask.popUpsTask());
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(webDriver, timeout); // Tiempo máximo de espera en segundos




        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));

        WebElement shadowHost = webDriver.findElement(By.cssSelector("div.airship-html-prompt-shadow"));

        // Ejecutar script JavaScript para obtener el Shadow Root
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        Object shadowRoot = jsExecutor.executeScript("return arguments[0].shadowRoot", shadowHost);



        // Verificar si se obtuvo correctamente el Shadow Root
        if (shadowRoot instanceof WebElement) {
            WebElement shadowRootElement = (WebElement) shadowRoot;

            // Encontrar el botón dentro del Shadow Root y hacer clic en él
            WebElement buttonInsideShadowDOM = shadowRootElement.findElement(By.cssSelector("button.airship-btn-accept"));
            buttonInsideShadowDOM.click();
        } else {
            System.out.println("No se pudo obtener el Shadow Root correctamente");
        }
    }

    @When("I am looking for a producty")
    public void iAmLookingForAProduct()  {
        userAutomation.wasAbleTo(SearchProductTask.withData());


    }

    @And("valid shopping cart")
    public void validShoppingCart() {
        userAutomation.wasAbleTo(purchaseTask.purchase());
    }

    @Then("I complete the purchase")
    public void iCompleteThePurchase() {
        // Implementación para completar la compra
    }


}
