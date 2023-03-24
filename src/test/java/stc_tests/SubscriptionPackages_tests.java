package stc_tests;

import com.shaft.driver.SHAFT;
import demoblaze_site.Demoblaze;
import io.github.shafthq.shaft.tools.io.ReportHelper;
import io.github.shafthq.shaft.tools.io.ReportManagerHelper;
import org.apache.logging.log4j.Level;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import stc_site.StcHomePage;

public class SubscriptionPackages_tests {
    StcHomePage stcHomePage;
    SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver= new SHAFT.GUI.WebDriver();
        stcHomePage= new StcHomePage(driver.getDriver());

    }
    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"sa","SAR","15","25","60"},
                {"kw","KWD","1.2","2.5","4.8"},
                {"bh","BHD","2","3","6"}

        };
    }

    @Test (dataProvider = "data-provider")
    public void testPackages(String country,String currency,String litePrice,String classicPrice,String premiumPrice)
    {   //sa  - LITE - 15 - sar -Classic - 25 - permium - 60

        stcHomePage.navigateTo(country); //kw -bh
        ReportManagerHelper.logDiscrete(stcHomePage.getPackageCurrency("lite"), Level.INFO);
        //assert package names
        Assert.assertEquals(stcHomePage.getPackageName("lite"),"LITE");
        Assert.assertEquals(stcHomePage.getPackageName("classic"),"CLASSIC");
        Assert.assertEquals(stcHomePage.getPackageName("premium"),"PREMIUM");
        //assert currency
        Assert.assertEquals(stcHomePage.getPackageCurrency("lite"),currency);
        Assert.assertEquals(stcHomePage.getPackageCurrency("classic"),currency);
        Assert.assertEquals(stcHomePage.getPackageCurrency("premium"),currency);
//assert currency
        Assert.assertEquals(stcHomePage.getPackagePrice("lite"),litePrice);
        Assert.assertEquals(stcHomePage.getPackagePrice("classic"),classicPrice);
        Assert.assertEquals(stcHomePage.getPackagePrice("premium"),premiumPrice);

    }
}
