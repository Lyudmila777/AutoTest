package workpages;

import org.openqa.selenium.By;
import pages.BasePage;


public class Auth_Page extends BasePage {
    String pageURL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";

    private static final By USERNAME_LOCATOR = By.name ("username");
    private static final By PASSWORD_LOCATOR = By.name ("password");
    private static final By EYE_ICON_LOCATOR = By.xpath ("//*[@class='eye-icon']");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.id ("login-button");
    private static final By CODE_LOCATOR = By.id ("otp-code");
    private static final By CODE_BUTTON_LOCATOR = By.id ("login-otp-button");
    private static final By ERROR_MESSAGE = By.xpath ("//div[@class = 'alert alert-error']");
    private static final By EXIT_BUTTON = By.id ("//*[@class='icon-close']");
//    private static final By LOCALIZATION_ENG_BUTTON = By.xpath ("//a[@class='btn btn-text btn-toggle']");
//    private static final By ERROR_ENG_MESSAGE = By.id ("bank-overview");

    public void openAuth_Page() {

        openUrl (pageURL);
    }

    public Auth_Page insertLogin(String login) {

        type (USERNAME_LOCATOR, login);
        return this;
    }

    public Auth_Page insertPassword(String password) {

        type (PASSWORD_LOCATOR, password);
        return this;
    }

    public void clickEyeIcon() {
        click (EYE_ICON_LOCATOR);
    }

    public void clickSignInButton() {

        click (SIGN_IN_BUTTON_LOCATOR);
    }

    public Auth_Page insertCode(String code) {

        type (CODE_LOCATOR, code);
        return this;
    }

//    public void clickLocalizationButton() {
//
//        click (LOCALIZATION_ENG_BUTTON);
//    }
//    public String getLocalizationEngMessage() {
//
//        return getElementText (ERROR_ENG_MESSAGE);
//    }
    public void clickCodeInButton() {

        click (CODE_BUTTON_LOCATOR);
    }

    public String getErrorMessage() {

        return getElementText (ERROR_MESSAGE);
    }

    public Main_Page fullAuth(String login, String password, String code) {
        insertLogin (login);
        insertPassword (password);
        clickSignInButton ();
        insertCode (code);
        clickCodeInButton ();

        return new Main_Page ();
    }

    public Main_Page fullAuthWithEye(String login, String password, String code) {
        insertLogin (login);
        insertPassword (password);
        clickEyeIcon ();
        clickSignInButton ();
        insertCode (code);
        clickCodeInButton ();

        return new Main_Page ();
    }

    public Main_Page notfullAuth(String login, String password) {
        insertLogin (login);
        insertPassword (password);
        clickSignInButton ();

        return new Main_Page ();
    }

    public Main_Page emptyAuth(String login) {
        insertLogin (login);
        clickSignInButton ();

        return new Main_Page ();
    }

//    public Main_Page localizationButton() {
//        clickLocalizationButton ();
//        return new Main_Page ();
//    }

}


