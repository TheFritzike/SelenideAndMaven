import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SwagLabs {
    @Test
    public void sauceDemoPage(){
        //variables
        SelenideElement userInput = $(By.id("user-name"));
        SelenideElement passInput = $(By.id("password"));
        SelenideElement itemName = $(By.className("inventory_item_name"));
        SelenideElement addToCartJacket = $("#add-to-cart-sauce-labs-fleece-jacket");
        SelenideElement shoppingCart = $(".shopping_cart_link");

        //open page verify title
        open("https://www.saucedemo.com/");
        $("title").has(text("Swag Labs"));

        //insert user, password and press Enter
        userInput.clear();
        userInput.val("standard_user");
        passInput.clear();
        passInput.val("secret_sauce").pressEnter();
        sleep(1000);

        //Product page and Cart
        if(itemName.has(text("Sauce Labs Fleece Jacket")))
            addToCartJacket.click();
        shoppingCart.click();
        sleep(1000);
    }
}
