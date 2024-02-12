package co.com.falabella.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MoveMouseAndClick implements Interaction {
    private int x;
    private int y;

    public MoveMouseAndClick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static MoveMouseAndClick at(int x, int y) {
        return new MoveMouseAndClick(x, y);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + "," + y + ")");
        js.executeScript("document.elementFromPoint(" + x + "," + y + ").click()");
    }
}
