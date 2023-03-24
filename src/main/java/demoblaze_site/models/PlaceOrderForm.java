package demoblaze_site.models;

import com.shaft.dsl.gui.Button;
import com.shaft.dsl.gui.Label;
import com.shaft.dsl.gui.TextBox;
import org.openqa.selenium.By;

public class PlaceOrderForm {

    public TextBox name= new TextBox(By.id("name"));
    public TextBox country= new TextBox(By.id("country"));
    public TextBox city= new TextBox(By.id("city"));;
    public TextBox card= new TextBox(By.id("card"));;
    public TextBox month= new TextBox(By.id("month"));;
    public TextBox year= new TextBox(By.id("year"));;
    public Button purchase= new Button(By.xpath("//button[text()='Purchase']"));;
    public Label successMsg= new Label(By.xpath("//div[contains(@class,'sa-success')]/../h2"));

    public void fill(String name,String country,String city,String card,String month,String year) {
        this.name.type(name);
        this.country.type(country);
        this.city.type(city);
        this.card.type(card);
        this.month.type(month);
        this.year.type(year);
       purchase.click();
    }
}
