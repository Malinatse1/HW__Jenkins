package pages.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),

    subjectContainer =$x(".//*[@id='subjectsContainer']"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadFileBtn = $x("//input[@id='uploadPicture']"),
            currentAdressInput= $("#currentAddress"),
            stateCityWrapper= $("#stateCity-wrapper"),
            stateDropdown= $("#state"),
            cityDropdown= $("#city"),
            submitBtn=   $("#submit"),



    dateOfBirthInput = $("#dateOfBirthInput");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
//        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }


    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value).click();

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;

    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectContainer.click();
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(new ByText(value)).click();

        return this;
    }
    public RegistrationPage setUploadFile(String value) {
        uploadFileBtn.uploadFile(new File(value));

        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAdressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateCityWrapper.scrollTo();
        stateDropdown.click();
        stateCityWrapper.$(new ByText(value)).click();

        return this;
    }
    public RegistrationPage setCity(String value) {
        cityDropdown.click();
        cityDropdown.$(new ByText(value)).click();

        return this;
    }
    public RegistrationPage setSubmit() {
        submitBtn.click();
        return this;
    }
}
