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

        $("#firstName").setValue("Aleksandra");
        $("#lastName").setValue("Lak");
        $("#userEmail").setValue("AleksandraLak@example.com");
//RadioButton
        $(byText("Female")).click();
// Номер телефона
        $("#userNumber").setValue("9997776655");
// Дата
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("May")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1970")).click();
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
        $x("(//div[contains(@class, 'css-tlfecz-indicatorContainer')])[2]").click();
        $(byText("Haryana")).click();
// Клик в пустое место
        $("#stateCity-label").click();
// Drop down list - 2
        $x("(//div[contains(@class, 'css-tlfecz-indicatorContainer')])[3]").click();
        $(byText("Panipat")).click();
// Сохранение
        $("#submit").click();
// Проверки
        $x("//tbody//tr[1]").shouldHave(text("Aleksandra Lak"));
        $x("//tbody//tr[2]").shouldHave(text("AleksandraLak@example.com"));
        $x("//tbody//tr[3]").shouldHave(text("Female"));
        $x("//tbody//tr[4]").shouldHave(text("9997776655"));
        $x("//tbody//tr[5]").shouldHave(text("20 May,1970"));
        $x("//tbody//tr[6]").shouldHave(text("Hindi, Biology"));
        $x("//tbody//tr[7]").shouldHave(text("Sports"));
        $x("//tbody//tr[8]").shouldHave(text("олень.jpeg"));
        $x("//tbody//tr[9]").shouldHave(text("My current address"));
        $x("//tbody//tr[10]").shouldHave(text("Haryana Panipat"));
    }
}
