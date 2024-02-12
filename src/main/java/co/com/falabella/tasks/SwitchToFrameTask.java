package co.com.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwitchToFrameTask implements Task {

    private final By iframeLocator;

    public SwitchToFrameTask(By iframeLocator) {
        this.iframeLocator = iframeLocator;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                net.serenitybdd.screenplay.actions.Switch.toFrame((WebElement) iframeLocator)
        );
    }

    public static SwitchToFrameTask withLocator(By iframeLocator) {
        return instrumented(SwitchToFrameTask.class, iframeLocator);
    }
}






