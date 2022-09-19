package org.example.Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Я не смог найти к чему можно быдло бы привязаться, что бы в списке были только пиццы
    //Мне кажется, что в такой ситуации нужно просто просить программиста добавить для пиццы свой личный Идентификатор
        @FindBy(xpath ="//section[@id='pizzas']//article")
    private List<WebElement> PizzaList;


    @FindBy(xpath = "//button")
    private  WebElement ButtonSelectProduct;

    @FindBy(xpath = "//button[text()='Корзина']")
    private WebElement ButtonIntoToCart;


    public SelectioIngredientsForPizza SelectOrderByName(String productName)
    {
        PizzaList.stream().filter(d->d.getText()
                        .contains(productName))
                            .findFirst()
                                .get()
                                        .click();
        return  new SelectioIngredientsForPizza(driver);
    }

    public Cart OpenCart()
    {
        ButtonIntoToCart.click();
        return new Cart(driver);
    }



}
