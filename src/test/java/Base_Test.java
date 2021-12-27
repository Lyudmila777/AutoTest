import driver.DriverChrome;
import org.junit.jupiter.api.AfterEach;



public class Base_Test {
    @AfterEach
    public void TearDown() {

        DriverChrome.tearDown();
    }
}
