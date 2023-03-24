package demoblaze_site;

import com.shaft.driver.SHAFT;
import com.shaft.dsl.gui.Button;
import com.shaft.dsl.gui.Element;
import com.shaft.dsl.gui.Label;
import com.shaft.dsl.gui.Link;
import demoblaze_site.models.Categories;
import demoblaze_site.models.LoginForm;
import demoblaze_site.models.PlaceOrderForm;
import demoblaze_site.models.SignUpForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Demoblaze {
    public static String url="https://www.demoblaze.com/";
    public Link login = new Link(By.id("login2"));
    public Link signUp= new Link(By.id("signin2"));
    public Link logOut= new Link(By.id("logout2"));
    public Link cart= new Link(By.linkText("Cart"));
    public Link deleteCartItem= new Link(By.linkText("Delete"));
    public Button placeOrderButton= new Button(By.xpath("//button[contains(text(),'Place Order')]"));
    public Label welcomeMsg = new Label(By.id("nameofuser"));

    public By allItemsLocator=  By.xpath("//*[@id='tbodyid']/div");
    public Link firstItem = new Link(By.xpath("(//*[@id='tbodyid']/div)[1]"));

    public Button addToCart= new Button(By.linkText("Add to cart"));

    //Forms
    public SignUpForm signUpForm= new SignUpForm();
    public LoginForm loginForm= new LoginForm();
    public PlaceOrderForm placeOrderForm= new PlaceOrderForm();
    //Catrgories
    public Categories categories= new Categories();
    public Demoblaze(WebDriver driver) {
        Element.setDriver(driver);
    }
   public void login(String username,String password)
   {
        login.click();
        loginForm.username.type(username );
        loginForm.password.type(password);
        loginForm.submit.click();
   }
   public void signUp(String username,String password)
   {
       signUp.click();
       signUpForm.username.type(username);
       signUpForm.password.type(password);
       signUpForm.submit.click();
   }
}
