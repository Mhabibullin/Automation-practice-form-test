package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FirstTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("Ivan@Petrov.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("8922222222");

        $("#subjectsInput").setValue("Art").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("Moscow, Lenina 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $(byText("Submit")).scrollIntoView(true).click();

        $(".modal-body").shouldHave(Condition.text("Ivan Petrov"));
        $(".modal-body").shouldHave(Condition.text("Ivan@Petrov.com"));
        $(".modal-body").shouldHave(Condition.text("Male"));
        $(".modal-body").shouldHave(Condition.text("8922222222"));
        $(".modal-body").shouldHave(Condition.text("05 June,1988"));
        $(".modal-body").shouldHave(Condition.text("Arts"));
        $(".modal-body").shouldHave(Condition.text("Sports"));
        $(".modal-body").shouldHave(Condition.text("1.jpg"));
        $(".modal-body").shouldHave(Condition.text("Moscow, Lenina 1"));
        $(".modal-body").shouldHave(Condition.text("NCR Delhi"));

    }

}

