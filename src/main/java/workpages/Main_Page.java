package workpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Main_Page extends BasePage {

    private static final By USER_NAME_LOCATOR = By.id ("user-greeting");//Hello World!
    private static final By OVERVIEW_BUTTON = By.id ("bank-overview");
    private static final By ACCOUNTS_BUTTON = By.id ("accounts-index");
    private static final By PAYMENTS_BUTTON = By.id ("payments-form");
    private static final By CARDS_BUTTON = By.id ("cards-overview-index");
    private static final By DEPOSITS_BUTTON = By.id ("deposits-index");
    private static final By LOANS_BUTTON = By.id ("loans-index");
    private static final By CURRENCY_BUTTON = By.id ("externaltraderoom-index");
    private static final By INCURANCE_BUTTON = By.xpath ("//a[@class='dropdown-toggle']");


    public String getUserName() {

        return getElementText (USER_NAME_LOCATOR);
    }

    public OverviewPage getOverview() {
        click (OVERVIEW_BUTTON);
        return new OverviewPage ();
    }

    public AccountsPage getAccounts() {
        click (ACCOUNTS_BUTTON);
        return new AccountsPage ();
    }

    public PaymentsPage getPayments() {
        click (PAYMENTS_BUTTON);
        return new PaymentsPage ();
    }

    public CardsPage getCards() {
        click (CARDS_BUTTON);
        return new CardsPage ();
    }

    public DepositsPage getDeposits() {
        click (DEPOSITS_BUTTON);
        return new DepositsPage ();
    }

    public LoansPage getLoans() {
        click (LOANS_BUTTON);
        return new LoansPage ();
    }

    public CurrencyPage getCurrency() {
        click (CURRENCY_BUTTON);
        return new CurrencyPage ();
    }

    public IncurancePage getIncurance() {
        click (INCURANCE_BUTTON);
        return new IncurancePage ();
    }
}
