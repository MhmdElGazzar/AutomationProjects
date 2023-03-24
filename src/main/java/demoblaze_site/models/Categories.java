package demoblaze_site.models;

import com.shaft.dsl.gui.Link;
import org.openqa.selenium.By;

public class Categories {
    public Link phones = new Link(By.linkText("Phones"));
    public Link laptops = new Link(By.linkText("Laptops"));
    public Link monitors = new Link(By.linkText("Monitors"));


}
