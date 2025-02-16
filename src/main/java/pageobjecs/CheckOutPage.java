package pageobjecs;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage extends AbstractComponents {
    WebDriver driver;
    public CheckOutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }

    @FindBy(xpath= "//div[text()='CVV Code ']/following-sibling::input")
    WebElement cvvCodeInput;

    @FindBy(xpath = "//div[text()='Name on Card ']/following-sibling::input")
    WebElement nameInput;

    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countryInput;

    @FindBy(xpath = "//a[text()='Place Order ']")
    WebElement placeOrderBtn;

    By vietName =  By.xpath("//button/span[text()=' Vietnam']");

    public void fillCvvCode(String code){
        cvvCodeInput.sendKeys(code);
    }

    public void fillName(String name){
        nameInput.sendKeys(name);
    }

    public void fillCountry(String country){
        countryInput.click();
        countryInput.sendKeys(country);
        waitForElementToAppear(vietName);
        driver.findElement(vietName).click();

    }

    public ConfirmationPage placeOrder(){
        placeOrderBtn.click();
        return new ConfirmationPage(driver);
    }

}
