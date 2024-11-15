import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

@Feature("Авторизация")
@Story("Авторизация пользователя")
public class AuthorizationTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    @Feature("Авторизация")
    @Story("Авторизация пользователя")
    public void testAuthorization() {
        logger.info("=== Начинаем тест: авторизация ===");
        loginPage.inputLoginField();
        loginPage.inputPasswordField();
        loginPage.clickLoginButton();

        assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Авторизация не пройдена");
        logger.info("=== Тест пройден: авторизация ===");
    }
}
