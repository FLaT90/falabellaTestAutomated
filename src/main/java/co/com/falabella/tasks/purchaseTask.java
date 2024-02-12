package co.com.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.falabella.userinterfaces.FalabellaPage.*;
import static co.com.falabella.userinterfaces.FalabellaPage.BTN_ADD_PRODUCT;

public class purchaseTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.wasAbleTo(Click.on(BTN_CONTINUE_PURCHASE),
                Enter.theValue("perezjefersonjdpc@hotmail.com").into(TXT_EMAIL),
                Click.on(BTN_CONTINUE_PURCHASE),
                Enter.theValue("Prueba12345@").into(TXT_PASSWORD));


    }

    /* public static SearchProductTask withData(List<DataSession> dataSessions) {
         return Tasks.instrumented(SearchProductTask.class, dataSessions);
     }*/
    public static purchaseTask purchase() {
        return Tasks.instrumented(purchaseTask.class);
    }
}
