package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By addBackpackBuotton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

    private By addBikeLightButton = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");

    private By cartIcon = By.xpath("//div[@id='shopping_cart_container']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(int productNumber) {
        if (productNumber == 1) {
            driver.findElement(addBackpackBuotton).click();
        } else if (productNumber == 2) {
            driver.findElement(addBikeLightButton).click();
        }
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}

