package example;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {
    @Test
    @DisplayName("Проверяем, что при поиске в google открывается страница с результатами")
    public void userCanSearch() {
        open("https://google.com");
        $("[name=q]").val("Selenide").pressEnter();
        $("#search").shouldBe(visible);
    }

    @Test
    @DisplayName("Добавляем дело в список, зачеркиваем и удаляем из списка")
    public void toDoList() {
        SelenideElement toDoListItem = $$("li").find(text("срочное дело"));
        open("https://webdriveruniversity.com/To-Do-List/index.html");
        // добавляем дело в туду лист
        $("#container input").val("срочное дело").pressEnter();
        // вычеркиваем дело
        toDoListItem.click();
        $(".completed").shouldHave(text("срочное дело"));
        // удаляем дело из туду листа: наводимся на дело в списке которое надо удалить и кликаем по иконке корзины
        toDoListItem.$(".fa-trash").hover().click();
        toDoListItem.shouldNotBe(exist);
    }
}
