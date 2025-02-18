package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }

    @FindBy(css= "li.items")
    List<WebElement> addedList;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkOutBtn;

    public Boolean verifyAddedProductDisplay(String productName){
        waitForElementToAppear(By.xpath("//h1[text()='My Cart']"));
        Boolean match = addedList.stream().anyMatch(i
                ->i.findElement(By.tagName("h3")).getText().equalsIgnoreCase(productName));
        return match;
    }
    public CheckOutPage goToCheckOut(){
        checkOutBtn.click();
        return new CheckOutPage(driver);
    }
}
