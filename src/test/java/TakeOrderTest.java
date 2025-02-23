import TestComponents.BaseTest;
import TestComponents.RetryTestFail;

import com.sun.source.tree.WhileLoopTree;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TakeOrderTest extends  BaseTest{
    @Test (groups = "Valid", dataProvider = "getData3", retryAnalyzer = RetryTestFail.class)
    public void test1(HashMap<String,String> input) throws IOException {
        //Login
        ProductsPage productsPage = landingPage.loginApplication(input.get("email"), input.get("password"));

        //Add product to cart
        List<WebElement> listItem = productsPage.getProductList();
        productsPage.addProductToCart(input.get("product"));

        //Go to cart page and check out
        CartPage cartPage =  productsPage.goToCart();
        Assert.assertTrue(cartPage.verifyAddedProductDisplay(input.get("product")));
        CheckOutPage checkOutPage = cartPage.goToCheckOut();

        // Fill information to order
        checkOutPage.fillCvvCode("123");
        checkOutPage.fillName("Do Kim Long");
        checkOutPage.fillCountry("Viet");
        ConfirmationPage confirmationPage = checkOutPage.placeOrder();

        //Verify order successfully
        Assert.assertEquals(confirmationPage.getConfirmationMessage(),"THANKYOU FOR THE ORDER.");

    }

    @DataProvider
    public Object[][] getData1(){
        return new Object[][]{
                {"longdo.hust@gmail.com", "@Long1010", "ZARA COAT 3"},
                {"longdo.hust@gmail.com", "@Long1010", "ZARA COAT 3"}
        };
    }

    @DataProvider
    public Object[][] getData2(){
        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("email", "longdo.hust@gmail.com");
        map1.put("password", "@Long1010");
        map1.put("product", "ZARA COAT 3");

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("email", "longdo.hust@gmail.com");
        map2.put("password", "@Long1010");
        map2.put("product", "ZARA COAT 3");

        return new Object[][]{{map1}, {map2}};
    }

    @DataProvider
    public Object[][] getData3() throws IOException {
        List<HashMap<String,String>> data = getDataToHashmap(
                System.getProperty("user.dir")+"\\src\\test\\java\\Data\\order.json");
        int size = data.size();
        Object[][] returnData = new Object[size][1];
        for (int i = 0; i < size; i++){
            returnData[i][0] = data.get(i);
        }
        return returnData;
    }

}
