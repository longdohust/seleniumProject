package pageobjecs;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends AbstractComponents {
    WebDriver driver;
    public ProductsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this );
    }

    @FindBy(css= ".col-lg-4")
    List<WebElement> productList;

    By productBy = By.cssSelector(".col-lg-4");
    By addToCart = By.cssSelector(".card-body>button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    By animation = By.cssSelector("ng-animating");

    public List<WebElement> getProductList(){
        waitForElementToAppear(productBy);
        return productList;
    }

    public WebElement getProductByName(String productName){
        WebElement product = getProductList().stream().filter(i
                ->i.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
        return product;
    }

    public void addProductToCart(String productName){
        WebElement product = getProductList().stream().filter(i
                ->i.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
        product.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(animation);
    }
}
