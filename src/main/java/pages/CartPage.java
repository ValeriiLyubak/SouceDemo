package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {

    private By cartItems = By.xpath("//div[@class='inventory_item_name']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));

        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }

    public void proceedToCheckout() {
        By checkoutButton = By.xpath("//button[@id='checkout']");
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}


