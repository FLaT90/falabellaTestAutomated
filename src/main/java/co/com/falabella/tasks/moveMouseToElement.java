package co.com.falabella.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollToBy;

public class moveMouseToElement implements Task {
    private int x;
    private int y;

    public moveMouseToElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + "," + y + ")");
    }

    public static Performable at(int x, int y) {
        return Task.where("{0} moves the mouse to coordinates (" + x + "," + y + ")",
                new moveMouseToElement(x, y));
    }
}
