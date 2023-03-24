package demoblaze_site.models;

import com.shaft.dsl.gui.Button;
import com.shaft.dsl.gui.TextBox;
import org.openqa.selenium.By;

public abstract class Form {
    public TextBox username;
    public TextBox password;
    public Button submit;
    public  Form(String form,String submitButtonText) {
        this.username =new TextBox(By.id(form+"username"));
        this.password =new TextBox(By.id(form+"password"));
        this.submit = new Button(By.xpath("//button[contains(text(),'"+submitButtonText+"')]"));;
    }
}
