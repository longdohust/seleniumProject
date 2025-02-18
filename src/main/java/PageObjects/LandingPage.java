package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
    WebDriver driver;
    public LandingPage( WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(css = ".toast-message")
    WebElement errorMessage;

    public ProductsPage loginApplication(String email, String password){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }
    public String getErrorMessage(){
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }
}
