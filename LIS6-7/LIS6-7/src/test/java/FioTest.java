import com.codeborne.selenide.Condition;
import  org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class FioTest {
        String site = "https://hadson-rest.ru/menu";

        @Test

        public void OpenSiteAboutUs() {
            clearBrowserCookies();
            $x("//a[@href='/onas']").click();
            sleep(5000);
        }

        @Test
        public void OpenSiteBanket() {
            clearBrowserCookies();
            $x("//a[@href='/banquets']").click();
            sleep(5000);
        }

        @Test
        public void OpenSiteDelivery() {
            clearBrowserCookies();
            $x("//a[@href='/delivery']").click();
            sleep(7000);
        }

        @Test
        public void OpenDelivery() {
            clearBrowserCookies();
            open(site);
            $x("//a[@href='/delivery']").click();
            sleep(5000);
            $x("//div[@class='node widget-button widget css24']").click();
            sleep(5000);
        }

        @Test
        public void AddItem() {
            clearBrowserCookies();
            OpenDelivery();
            $x("//i[@class='fas fa-cart-arrow-down']").click();
            sleep(2000);
            $x("//div[@class='swal-button-container']").click();
            sleep(5000);
        }

        @Test
        public void OpenBasket() {
            clearBrowserCookies();
            $x("//i[@class='fas fa-shopping-cart']").click();
            sleep(5000);
        }

        @Test
        public void OpenBasketFromDelivery() {
            clearBrowserCookies();
            $x("//a[@href='/delivery']").click();
            sleep(5000);
            $x("//div[@class='node widget-button widget css24']").click();
            sleep(5000);
            $x("//i[@class='fas fa-cart-arrow-down']").click();
            sleep(2000);
            $x("//div[@class='swal-content']").click();
            sleep(5000);
        }

        @Test
        public void PlusItemFromBasket() {
            clearBrowserCookies();
            OpenDelivery();
            $x("//i[@class='fas fa-cart-arrow-down']").click();
            sleep(2000);
            $x("//div[@class='swal-button-container']").click();
            sleep(2000);
            OpenBasket();
            $x("//button[@data-role='increaseamount']").click();
            sleep(5000);
        }

        @Test
        public void MinusItemFromBasket() {
            clearBrowserCookies();
            OpenBasket();
            $x("//button[@data-role='decreaseamount']").click();
            sleep(5000);
        }

        @Test
        public void DeleteAllItemFromBasket() {
            clearBrowserCookies();
            OpenDelivery();
            $x("//i[@class='fas fa-cart-arrow-down']").click();
            sleep(2000);
            $x("//div[@class='swal-button-container']").click();
            sleep(2000);
            OpenBasket();
            $x("//button[@data-action='js']").click();
            sleep(5000);
        }

        @Test
        public void SwitchDeliveryMethod(){
            clearBrowserCookies();
            $x("//i[@class='fas fa-cart-arrow-down']").click();
            sleep(2000);
            $x("//div[@class='swal-button-container']").click();
            sleep(5000);
            OpenBasket();
            $x("//div[@class='radio']").click();
            sleep(5000);
            $x("//input[@autocomplete='name']").setValue("Александр");
            $x("//input[@autocomplete='tel']").setValue("89124373635");
            sleep(3000);
        }

        @Test
        public void OrderDelivery(){
            clearBrowserCookies();
            open(site);
            OpenBasket();
            $x("//button[@data-action='modal']").click();
            sleep(5000);
        }

        @Test
        public void SendFeedback(){
            $x("//a[@href='/review']").scrollTo();
            sleep(3000);
            $x("//a[@href='/review']").click();
            sleep(2000);
            $x("//input[@autocomplete='name']").setValue("Александр");
            sleep(1000);
            $x("//input[@autocomplete='tel']").setValue("89124373635");
            sleep(1000);
            $x("//input[@autocomplete='email']").setValue("abcd@mail.ru");
            sleep(1000);
            $x("//textarea[@il-action='listen']").setValue("Все замечательно!");
            sleep(3000);

        }

        @Test
        public void TestGoogle(){
        open("https://www.google.ru/");
        $x("//textarea[@name='q']").setValue("Кодин Александр Андреевич").pressEnter();
        sleep(5000);
        $x("//div[@id='result-stats']").shouldBe(Condition.visible);
    }
}
