package guru.qa.tests;


import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;


public class FirstTestWithPageObjects {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.numerify("##########");
    String address = faker.address().fullAddress();

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGenger("Other")
                .typePhone(phone)
                .setDateOfBirth("28", "July", "2005")
                .subjectsInput("Art")
                .hobbies("Sport")
                .uploadPicture("1.jpg")
                .currentAddress(address)
                .stateAndCity("NCR, Delhi");
        registrationPage.submit();

        registrationPage.finalTable.shouldHave(text(firstName + " " + lastName))
                .shouldHave(text(email))
                .shouldHave(text("Other"))
                .shouldHave(text(phone))
                .shouldHave(text("28 July,2005"))
                .shouldHave(text("Arts"))
                .shouldHave(text("Sports"))
                .shouldHave(text("1.jpg"))
                .shouldHave(text(address))
                .shouldHave(text("NCR Delhi"));


    }

}


