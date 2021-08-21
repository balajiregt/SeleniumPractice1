import org.apache.tools.ant.types.CommandlineJava;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.Reporter;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PreloginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\balajik\\git\\Practice\\Java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/");
    }

    @Test
    public void loginButton() {
        String title=driver.getTitle();
        System.out.println(title);
        driver.findElement(By.id("login2")).click();
    }

    @Test
    public void preloginTabs(){
        Boolean h1=driver.findElement(By.partialLinkText("Home")).isDisplayed();
        Boolean h2=driver.findElement(By.linkText("Contact")).isDisplayed();
        Boolean h3=driver.findElement(By.linkText("About us")).isDisplayed();
        Boolean h4=driver.findElement(By.linkText("Cart")).isDisplayed();
        Boolean h5=driver.findElement(By.linkText("Log in")).isDisplayed();
        Boolean h6=driver.findElement(By.linkText("Sign up")).isDisplayed();
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        System.out.println(h5);
        System.out.println(h6);

    }

    @Test
    public void category() {

        String[] categoryvalue = {"CATEGORIES", "Phones", "Laptops", "Monitors"};
        List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='list-group']/a"));

        for(int i=0; i<categoryvalue.length; i++)
        {
            if(allLinks.get(i).getText().equalsIgnoreCase(categoryvalue[i]))
                Reporter.log(allLinks.get(i).getText()+ " Matches " + categoryvalue[i]);

            else
                Reporter.log("Didn't match");
        }
    }



    @AfterMethod
    public void teardown(){
    driver.close();
    }


}
