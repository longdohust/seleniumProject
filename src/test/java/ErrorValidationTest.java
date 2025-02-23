import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationTest extends  BaseTest{
    @Test (groups = "Invalid")
    public void test1() throws IOException {

        String productName = "ZARA COAT 3";

        //Login
        landingPage.loginApplication("longdo.hust@gmail.com", "@long1010");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
    }
}
