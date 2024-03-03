package tests.web;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import utils.Helpers;

import static io.qameta.allure.Allure.step;

@Feature("Home page testing")
@Tag("web")
public class HomePageTests extends TestBase {
    HomePage homePage = new HomePage();

    @Test
    @DisplayName("Проверка страницы Окей магазина")
    @Story("Проверка загрузки главной страницы")
    void checkHomePageTitleTest() {
        step("Откроем главную", () -> {
            homePage.openPage("https://www.okeydostavka.ru/msk");
        });
        step("Проверим Header страницы", () -> {
            Helpers.verifyPageTitle("Доставка продуктов на дом в Москве за 90 минут - заказать в ОКЕЙ");
        });
    }

    @Test
    @DisplayName("Проверим поиск")
    @Story("Заполним строку поиска запросом и найдем что-то")
    void SearchTest() {
        step("Откроем гланвую", () -> {
            homePage.openPage("https://www.okeydostavka.ru/msk");
        });
        step("Нажмем на кнопку поиска", () -> {
            homePage.clickSearch();
        });
        step("Проверим что что-то нашло", () -> {
            homePage.verifyText();
        });
    }
}
