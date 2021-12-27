import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workpages.*;

public class OpenPagesTest extends Base_Test{
    Auth_Page auth_Page;
    Main_Page main_Page;
    OverviewPage overviewPage;
    AccountsPage accountsPage;
    PaymentsPage paymentsPage;
    CardsPage cardsPage;
    DepositsPage depositsPage;
    LoansPage loansPage;
    CurrencyPage currencyPage;
    IncurancePage incurancePage;

    @BeforeEach
    public void  setup(){
        auth_Page = new Auth_Page ();
        auth_Page.openAuth_Page ();
        main_Page = auth_Page.fullAuth ("","","");
    }
    @Test
public  void  getOverview(){
        overviewPage = main_Page.getOverview ();
    }

    @Test
    public  void  getAccounts(){
        accountsPage = main_Page.getAccounts ();
    }

    @Test
    public  void  getPayments(){
        paymentsPage = main_Page.getPayments ();
    }
    @Test
    public  void  getCards(){
        cardsPage = main_Page.getCards ();
    }
    @Test
    public  void  getDeposits(){
        depositsPage = main_Page.getDeposits ();
    }
    @Test
    public  void  getLoans(){
        loansPage = main_Page.getLoans ();
    }
    @Test
    public  void  getCurrency(){
        currencyPage = main_Page.getCurrency ();
    }
    @Test
    public  void  getIncurance(){
        incurancePage = main_Page.getIncurance ();
    }
}