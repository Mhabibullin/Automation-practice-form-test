package guru.qa.pages;


import com.codeborne.selenide.SelenideElement;
import guru.qa.components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {


    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";

    private SelenideElement modal = $("[role=dialog]");
    public SelenideElement finalTable = $(".modal-body");
    private Calendar calendar = new Calendar();

    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").val(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        $("#lastName").val(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        $("#userEmail").val(email);
        return this;
    }

    public RegistrationPage selectGenger(String gender) {
//        $("[name=gender][value=" + gender + "]").parent().click();

        $(format("[name=gender][value=%s]", gender)).parent().click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);

        return this;

    }

    public RegistrationPage typePhone(String phone) {
        $("#userNumber").val(phone);

        return this;
    }

    public RegistrationPage subjectsInput(String subjects) {
        $("#subjectsInput").setValue("Art").pressEnter();

        return this;
    }

    public RegistrationPage hobbies(String hobbies) {
        $(byText("Sports")).click();

        return this;
    }

    public RegistrationPage uploadPicture(String file) {
        $("#uploadPicture").uploadFromClasspath("1.jpg");

        return this;
    }

    public RegistrationPage currentAddress(String address) {
        $("#currentAddress").val(address);

        return this;
    }

    public RegistrationPage stateAndCity(String stateAndCity) {
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        return this;
    }

    public void submit() {
        $(byText("Submit")).scrollIntoView(true).click();

    }

    public void checkResultsTitle() {
        modal.$(".modal-title").shouldHave(text(RESULTS_TITLE));
    }

    public void checkResultsValue(String value) {
        modal.$(".table-responsive").shouldHave(text(value));
    }
}