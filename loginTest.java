import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//import java.lang.reflect.Array;
//import java.util.Iterator;
//import java.util.List;
// java.util.concurrent.TimeUnit;

    public class loginTest {
        WebDriver driver;

        @BeforeMethod
        public void setup(){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\balajik\\git\\Practice\\Java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
            driver=new FirefoxDriver();

            driver.manage().deleteAllCookies();
            driver.get("https://www.demoblaze.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }

        @Test(priority = 2)
        public void home() {    //to validate the cart value in the prelogin screen; then assert it

            String title=driver.getTitle();
            System.out.println(title);
            Assert.assertEquals(title,"Store");

        }


}
