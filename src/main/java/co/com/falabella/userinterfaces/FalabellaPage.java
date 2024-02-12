package co.com.falabella.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FalabellaPage {
   // public static final Target POP_UP_OFERTS = Target.the("POP UP OFERTS").located(By.className("airship-btn airship-btn-accept"));
    public static final Target POP_UP_OFERTS = Target.the("Accept offer button").locatedBy("data-airship-trigger-accept");
    public static final Target ACCEPT_BUTTON = Target.the("Accept button").located(By.cssSelector(".airship-btn.airship-btn-accept"));
    //public static final Target ACCEPT_BUTTON = Target.the("Accept button").located(By.cssSelector("airship-btn airship-btn-accept"));
    public static final Target TXT_PRODUCTS = Target.the("Input products").located(By.className("SearchBar-module_searchBar__Input__1kPKS"));
    public static final Target BTN_SHARE = Target.the("BTN SHARE").located(By.className("SearchBar-module_searchIcon__FS7b4"));
    public static final Target BTN_CLOSED_COOKIES = Target.the("BTN CLOSED COOKIES").located(By.className("//div[@id='testId-close-cookies-btn']"));

    public static final Target BTN_PRODUCT = Target.the("BTN IPHONE").locatedBy("//b[@id='testId-pod-displaySubTitle-prod13430667']");

 public static final Target BTN_ADD_PRODUCT = Target.the("BTN ADD PRODUCT").locatedBy("//button[@id='add-to-cart-button']");
 public static final Target BTN_HELP_ONLINE = Target.the("BTN HELP ONLINE").located(By.className("//*[@id='asesorOnlineDesktopContainer']/button/img"));
    public static final Target BTN_GO_CART = Target.the("BTN GO CART").locatedBy("//a[@id='linkButton']");
    public static final Target BTN_CONTINUE_PURCHASE = Target.the("BTN CONTINUE PURCHASE").locatedBy("//button[@class='chakra-button css-lwxwlj']");
    public static final Target TXT_EMAIL = Target.the("TXT EMAIL").locatedBy("//input[@id='testId-Input-email']");
    public static final Target BTN_CONTINUOUS_PAYMENT = Target.the("BTN CONTINUOUS PAYMENT").locatedBy("//button[@class='chakra-button css-1qn6b4c']");
    public static final Target BTN_WITHDRAW_ORDER = Target.the("BTN WITHDRAW ORDEr").locatedBy("(//div[@class='jsx-1143844172 container priority'])[1]");
 public static final Target TXT_PASSWORD = Target.the("TXT PASSWORD").locatedBy("//input[@id='loginWizard-delivery-groups-login-form-password-input']");
 public static final Target BTN_GO_PURCHASE = Target.the("BTN GO PURCHASE").locatedBy("//button[@class='chakra-button go-to-payment-button css-1qn6b4c']");
public static final Target DIV_TARGETS = Target.the("DIV TARGETS").locatedBy("//div[@class='jsx-1790677081 container priority payment-options']");
 public static final Target BTN_LOGIN = Target.the("BTN LOGIN").located(By.xpath("//button[contains(text(),'Enviar')]"));


}
