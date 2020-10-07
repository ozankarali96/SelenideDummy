package org.example;

import com.codeborne.selenide.CollectionCondition;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author  Ozan Karali
 * @since 07.10.2020
 */

public class TrendyolTest {

    @Test
    public void testUI() throws Exception {

        open("https://www.trendyol.com/");

        $(By.className("fancybox-item")).click();

        $(By.className("search-box")).setValue("bilgisayar").pressEnter();

        $$(By.className("p-card-wrppr")).shouldHave(size(24)); //This is give us array of results
        $$(By.className("p-card-img")).shouldHave(CollectionCondition.sizeGreaterThan(0));

        $(By.className("p-card-wrppr"), 4).click();

        $(By.className("add-to-bs-tx")).click();
        $(By.className("add-to-bs-tx-sc")).shouldHave(text("Sepete Eklendi"));
        Assert.assertEquals("Sepete Eklendi",$(By.className("add-to-bs-tx-sc")).getText());

    }
}
