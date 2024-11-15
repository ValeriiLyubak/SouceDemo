import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CheckoutOverviewPage;
import pages.OrderConfirmationPage;

import static org.testng.Assert.assertEquals;

@Feature("Заказ")
public class OrderTest extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private OrderConfirmationPage orderConfirmationPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    @Test
    @Feature("Заказ")
    @Story("Выполнить заказ")
    public void testOrder() {
        logger.info("=== Начинаем тест: Заказ ===");

        loginPage.inputLoginField();
        loginPage.inputPasswordField();
        loginPage.clickLoginButton();

        mainPage.addProductToCart(1);
        mainPage.addProductToCart(2);

        mainPage.goToCart();

        cartPage.proceedToCheckout();

        checkoutPage.fillInUserData("Иван", "Ивонов", "12345");
        checkoutPage.proceedToNextStep();

        checkoutOverviewPage.finishOrder();

        String confirmationMessage = orderConfirmationPage.getConfirmationMessage();
        assertEquals(confirmationMessage, "Thank you for your order!", "Сообщение подтверждения заказа не совпадает");

        logger.info("=== Тест пройден: Заказ ===");
    }
}

