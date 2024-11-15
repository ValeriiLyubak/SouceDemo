import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

@Feature("Корзина")
public class AddProductsToCartTest extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private CartPage cartPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    @Feature("Корзина")
    @Story("Добавление товаров в корзину")
    public void testAddToCart() {
        logger.info("=== Начинаем тест: добавление в корзину ===");
        loginPage.inputLoginField();
        loginPage.inputPasswordField();
        loginPage.clickLoginButton();

        mainPage.addProductToCart(1);
        mainPage.addProductToCart(2);

        mainPage.goToCart();

        int cartItemCount = cartPage.getCartItemCount();
        assertEquals(cartItemCount, 2, "Количество товаров в корзине не верно");

        logger.info("=== Тест пройден: добавление в корзину ===");
    }
}
