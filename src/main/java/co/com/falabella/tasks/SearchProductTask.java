package co.com.falabella.tasks;

import co.com.falabella.models.DataSession;
import co.com.falabella.utils.Constants;
import co.com.falabella.utils.ExcelUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static co.com.falabella.userinterfaces.FalabellaPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchProductTask implements Task {

    //private List<DataSession> dataSessions;

   // public SearchProductTask(List<DataSession> dataSessions) {
     //   this.dataSessions = dataSessions;
    //}
   private final WebDriver driver;

    public SearchProductTask(WebDriver driver) {
        this.driver = driver;
    }
    static ExcelUtils excelUtils = new ExcelUtils();
    static String excelFilePath = Constants.PATH_TEST_DATA + Constants.FILE_TEST_DATA;
    @Override
    public <T extends Actor> void performAs(T actor) {
      //  driver.navigate().refresh();
        try {

            excelUtils.setExcelFile(excelFilePath, Constants.SHEET_TEST_DATA);

        } catch (IOException e) {
            e.printStackTrace();
        }

        actor.wasAbleTo(Click.on(TXT_PRODUCTS));
        actor.attemptsTo(Enter.theValue(excelUtils.getCellData(1, 0)).into(TXT_PRODUCTS));
        actor.wasAbleTo(Click.on(BTN_SHARE),
        //Click.on(BTN_CLOSED_COOKIES),
                Click.on(BTN_PRODUCT),
                validateAndClick(actor, BTN_HELP_ONLINE),
                Click.on(BTN_ADD_PRODUCT),
                Click.on(BTN_GO_CART));

    }
   /* private static Task validateAndClick(Actor actor, Target target) {
        return Task.where("{0} attempts to click on #target if it's visible",
                WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(target)
        );
    }*/
   private static Task validateAndClick(Actor actor, Target target) {
       return Task.where("{0} attempts to click on #target if it's visible",
               WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds(),
               Click.on(target)


       );
   }

    public static SearchProductTask withData() {
        return Tasks.instrumented(SearchProductTask.class);
    }
    }




