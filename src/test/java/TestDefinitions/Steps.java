package TestDefinitions;

import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjecs.*;

import java.io.IOException;

public class Steps extends BaseTest {
    public LandingPage landingPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce page")
    public void landOnEcommercePage() throws IOException {
        landingPage=  runApplication();
    }

    @Given("^Logged in with the username (.+) and password (.+)$")
    public void login(String username, String password){
        productsPage = landingPage.loginApplication(username,password);
    }

    @When("^Adding product (.+) to Cart$")
    public void addProductToCart(String productName){
        productsPage.addProductToCart(productName);
    }

    @And("^Checkout (.+) and submit the order$")
    public void checkOutProduct(String productName){
        cartPage = productsPage.goToCart();
        Assert.assertTrue(cartPage.verifyAddedProductDisplay(productName));
        checkOutPage = cartPage.goToCheckOut();
        checkOutPage.fillCvvCode("123");
        checkOutPage.fillName("Do Kim Long");
        checkOutPage.fillCountry("Viet");
        confirmationPage = checkOutPage.placeOrder();
    }

    @Then("{string} message is displayed")
    public void messageShowAndConfirm(String message){
        Assert.assertEquals(confirmationPage.getConfirmationMessage(),message);
    }
}
