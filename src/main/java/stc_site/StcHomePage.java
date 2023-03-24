package stc_site;

import com.shaft.dsl.gui.Element;
import com.shaft.dsl.gui.Label;
import com.shaft.dsl.gui.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StcHomePage {
    WebDriver webDriver;
    public static String url="https://subscribe.stctv.com/";
    //packages -lite-classic-premium
    public Label lite = new Label(By.id("name-lite"));
    public Label classic = new Label(By.id("name-classic"));
    public Label premium = new Label(By.id("name-premium"));
    public Label price= new Label(By.id("currency-lite"));
    public Link signUp= new Link(By.id("signin2"));
    public Link logOut= new Link(By.id("logout2"));
    public Link cart= new Link(By.linkText("Cart"));
    public Link deleteCartItem= new Link(By.linkText("Delete"));
    public StcHomePage(WebDriver driver) {
        Element.setDriver(driver);
        webDriver=driver;
    }
    public void navigateTo(String country)
    {
        webDriver.navigate().to(StcHomePage.url+country+"-en");

    }
    public String getPackageName(String packageName)
    {
      return new Label(By.id("name-"+packageName)).getText();

    }
    public String getPackagePrice(String packageName)
    {By.xpath("//*[@id='currency-"+packageName+"']/b");

        return new Label(By.xpath("//*[@id='currency-"+packageName+"']/b")).getText();
    }
    public String getPackageCurrency(String packageName)
    {
          String value = new Label(By.xpath("//*[@id='currency-"+packageName+"']/i")).getText();
        return value.split("/")[0];
    }

}
