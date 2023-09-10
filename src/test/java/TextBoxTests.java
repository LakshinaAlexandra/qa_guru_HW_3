import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
// Remove banner
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
//
        $("#firstName").setValue("Aleksandra");
        $("#lastName").setValue("Lak");
        $("#userEmail").setValue("AleksandraLak@example.com");
//RadioButton
        $(byText("Female")).click();
// Номер телефона
        $("#userNumber").setValue("9997776655");
// Дата
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1970")).click();
        $(".react-datepicker__day.react-datepicker__day--020").click();
// Multiple select
        $("#subjectsInput").setValue("n");
        $(byText("Hindi")).click();
        $("#subjectsInput").setValue("b");
        $(byText("Biology")).click();
// CheckBox
        $(byText("Sports")).click();
// Файл
        $("#uploadPicture").sendKeys("/Users/malekov/Desktop/Тестовые файлы/олень.jpeg");
// Адрес
        $("#currentAddress").setValue("My current address");
// Drop down list - 1
        $("#state").click();
        $(byText("Haryana")).click();
// Drop down list - 2
        $("#city").click();
        $(byText("Panipat")).click();
// Сохранение
        $("#submit").click();
// Проверки
        $(".modal-content").shouldHave(
                text("Aleksandra Lak"),
                text("AleksandraLak@example.com"),
                text("Female"),
                text("9997776655"),
                text("20 May,1970"),
                text("Hindi, Biology"),
                text("Sports"),
                text("олень.jpeg"),
                text("My current address"),
                text("Haryana Panipat"));
    }
}
