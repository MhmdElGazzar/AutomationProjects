package demoblaze_tests;
import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import demoblaze_site.Demoblaze;
import org.openqa.selenium.By;
import org.testng.annotations.*;


public class TestScenarios {
    Demoblaze demoblaze;
    SHAFT.GUI.WebDriver driver;
    String usernamedata="dragon2023";
    String passworddata="12121212";
    @BeforeMethod
    public void setup()
    {
        driver= new SHAFT.GUI.WebDriver();
        demoblaze= new Demoblaze(driver.getDriver());
        driver.browser().navigateToURL(Demoblaze.url);
    }
    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void testASuccessfulSignUp()
    {    Faker faker= new Faker();
        demoblaze.signUp(faker.name().fullName(),passworddata);
        String alertText =driver.alert().getAlertText();
        System.out.println(alertText);
        SHAFT.Validations.assertThat().object(alertText).contains("Sign up successful.");
    }
    @Test
    public void testSuccessfulLogin()
    {
        demoblaze.login(usernamedata,passworddata);
        demoblaze.logOut.shouldExist();
        demoblaze.welcomeMsg.shouldHaveText("Welcome "+usernamedata);
    }

    @Test
    public void testCategoriesHasItems()
    {

        int itemCount;
        demoblaze.categories.phones.click();
        itemCount = driver.getDriver().findElements(demoblaze.allItemsLocator).size();
        SHAFT.Validations.verifyThat().number(itemCount).isGreaterThan(0).perform();
        demoblaze.categories.laptops.click();
        itemCount = driver.getDriver().findElements(demoblaze.allItemsLocator).size();
        SHAFT.Validations.verifyThat().number(itemCount).isGreaterThan(0).perform();
        demoblaze.categories.monitors.click();
        itemCount = driver.getDriver().findElements(demoblaze.allItemsLocator).size();
        SHAFT.Validations.verifyThat().number(itemCount).isGreaterThan(0).perform();
    }
    @Test
    public void testInsertingAndRemoveItemToCart() throws InterruptedException {

        demoblaze.firstItem.click();
        demoblaze.addToCart.click();
        String alertText =driver.alert().getAlertText();
        System.out.println(alertText);
        SHAFT.Validations.assertThat().object(alertText).contains("Product added.");
        demoblaze.cart.click();
        demoblaze.deleteCartItem.click();
        boolean exist = demoblaze.deleteCartItem.isDisplayed();
        SHAFT.Validations.assertThat().object(exist).isFalse();

    }
    @Test
    public void testcheckout() {
        demoblaze.firstItem.click();
        demoblaze.addToCart.click();
        demoblaze.cart.click();
        demoblaze.placeOrderButton.click();
        demoblaze.placeOrderForm.fill("mhmd","egy","cairo","12345678910123","August","2023");
        demoblaze.placeOrderForm.successMsg.shouldHaveText("Thank you for your purchase!");

    }
}
