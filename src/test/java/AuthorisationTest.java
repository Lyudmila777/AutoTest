import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import workpages.Auth_Page;
import workpages.Main_Page;


public class AuthorisationTest extends Base_Test {
    Auth_Page auth_Page;
    Main_Page main_Page;


    @BeforeEach
    public void setUp() {
        auth_Page = new Auth_Page ();
        auth_Page.openAuth_Page ();

    }

    @Test
    public void validAuthTest() {
        main_Page = auth_Page.fullAuth ("", "", "");
        String userName = main_Page.getUserName ();
        Assertions.assertEquals ("Hello World!", userName);
    }
    @Test
    public void validAuthWithEyeTest() {
        main_Page = auth_Page.fullAuthWithEye ("", "", "");
        String userName = main_Page.getUserName ();
        Assertions.assertEquals ("Hello World!", userName);
    }
    @Test
    public void invalidAuthTest() {
        main_Page = auth_Page.notfullAuth ("", "демо");

        String warningText = auth_Page.getErrorMessage ();
        Assertions.assertEquals ("Неверные данные пользователя (осталось 2 попытки)", warningText);
    }


    @Test()
    public void invalidEmptyAuthTest() {
        main_Page = auth_Page.emptyAuth ("demo");

        String warningText = auth_Page.getErrorMessage ();
        Assertions.assertEquals ("Неверные данные пользователя (осталось 2 попытки)", warningText);

    }

}

