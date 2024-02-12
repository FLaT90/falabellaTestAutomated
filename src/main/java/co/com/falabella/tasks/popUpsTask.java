package co.com.falabella.tasks;

import co.com.falabella.interactions.MoveMouseAndClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


import static co.com.falabella.userinterfaces.FalabellaPage.*;
import static com.ibm.dtfj.javacore.parser.j9.section.classloader.ClassLoaderPatternMatchers.shadow;

public class popUpsTask implements Task {

    private final WebDriver driver;

    public popUpsTask(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        driver.navigate().refresh();

     /*   WebElement frame = driver.findElement(By.xpath("//iframe"));

        //Actions actions = new Actions(actor.usingAbilityTo(BrowseTheWeb.class).getDriver());
        //actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
       if (frame != null) {
            Switch.toFrame(frame);


            if(the(ACCEPT_BUTTON).answeredBy(actor).isCurrentlyVisible()){

                actor.attemptsTo(
                        Click.on(ACCEPT_BUTTON)
                );
            }
           Switch.toDefaultContext();
        }



       // the(ACCEPT_BUTTON).shouldBe(visible()).click();

       // Switch.toFrame(frame);
            //actor.attemptsTo(Click.on(ACCEPT_BUTTON).)

       // MoveMouse.to(ACCEPT_BUTTON).andThen(Actions::doubleClick);

        //actor.attemptsTo(Click.on(ACCEPT_BUTTON));
        //Switch.toDefaultContext();
       /* actor.attemptsTo(
                SwitchToFrameTask.withLocator(By.tagName("iframe")),
                Click.on(By.cssSelector("button[data-airship-trigger-accept='']"))
        );*/


       // actor.attemptsTo(Click.on(POP_UP_OFERTS));


    }


    public static popUpsTask popUpsTask() {
        return Tasks.instrumented(popUpsTask.class);
    }
}
