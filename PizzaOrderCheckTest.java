package org.example.Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PizzaOrderCheckTest {

    WebDriver driver;

    @BeforeAll
    static void  registerDriver()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser()
    {
        driver=new ChromeDriver();
        driver.get("https://dodopizza.ru/moscow");
        driver.manage().window().fullscreen();
    }

    @AfterEach
    void killbrowser()
    {
        driver.quit();
    }

@Test
@DisplayName("Проверка добавления заказаной пиццы в корзину")
    void OrderPizzaAndCheckCart () {
    new MainPage(driver).SelectOrderByName("Пепперони фреш")
            .SelectSizePizza("Маленькая")
                .SelectTestoSize("Традиционное")
                    .SelectIngredients("Ветчина")
                        .SelectIngredients("Свежие томаты")
                            .ButtonAddToCart()
                                    .OpenCart()
                                        .CheckOrderInCart("Пепперони фреш");



}


}
