import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjecs.CartPage;
import pageobjecs.CheckOutPage;
import pageobjecs.ConfirmationPage;
import pageobjecs.ProductsPage;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends  BaseTest{
    @Test (groups = "Invalid")
    public void test1() throws IOException {

        String productName = "ZARA COAT 3";

        //Login
        landingPage.loginApplication("longdo.hust@gmail.com", "@long1010");
        Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");


    }
}
