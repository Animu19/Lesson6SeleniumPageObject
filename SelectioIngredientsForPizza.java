package org.example.Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

public class SelectioIngredientsForPizza extends BasePage{


    public SelectioIngredientsForPizza(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@data-testid, \"size\")]")
    private List<WebElement> SizePizzaList;

    @FindBy(xpath = "//*[contains(@data-testid, \"dough\")]")
    private List<WebElement> TestoSizeList;

    @FindBy(xpath = "(//button[@data-selected='false'])")
    private List<WebElement> IngredientsList;

    @FindBy(xpath = "//button[@data-size='big']")
    private WebElement ButtonAddToCart;


    public SelectioIngredientsForPizza SelectSizePizza(String SizePizza)
    {
        SizePizzaList.stream().filter(d->d.getText()
                        .contains(SizePizza))
                            .findFirst()
                                .get()
                                    .click();
    return new SelectioIngredientsForPizza(driver);
    }

    public SelectioIngredientsForPizza SelectTestoSize(String TestoSize)
    {
        TestoSizeList.stream().filter(d->d.getText()
                        .contains(TestoSize))
                            .findFirst()
                                .get()
                                    .click();
    return new SelectioIngredientsForPizza(driver);
    }

    public SelectioIngredientsForPizza SelectIngredients(String IngredientsName)
    {
        IngredientsList.stream().filter(d->d.getText()
                    .contains(IngredientsName))
                        .findFirst()
                            .get()
                                .click();
    return new SelectioIngredientsForPizza(driver);
    }

public MainPage ButtonAddToCart()
{
       ButtonAddToCart.click();
return new MainPage(driver);
}



}
