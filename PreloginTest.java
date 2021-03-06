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

        driver.manage().deleteAllCookies();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void cart() {    //to validate the cart value in the prelogin screen; then assert it

        driver.findElement(By.linkText("Cart")).click();
        String cartvalue= driver.findElement(By.xpath("//th[text()='x']")).getText();
        Assert.assertEquals(cartvalue,"x");
    }

    @Test(priority = 1)
    public void preloginTabs(){ //to validate the expected tabs available in the prelogin screen; change the return type of object from boolean to string.
        String websitename=driver.findElement(By.xpath("//nav[@id='narvbarx']/a[1]")).getText();
        Reporter.log(websitename);

        Boolean h1=driver.findElement(By.partialLinkText("Home")).isDisplayed();
        String str1 = String.valueOf(h1);
        Assert.assertTrue(h1);
        Boolean h2=driver.findElement(By.linkText("Contact")).isDisplayed();
        String str2 = String.valueOf(h2);
        Assert.assertTrue(h2);
        Boolean h3=driver.findElement(By.linkText("About us")).isDisplayed();
        String str3 = String.valueOf(h3);
        Assert.assertTrue(h3);
        Boolean h4=driver.findElement(By.linkText("Cart")).isDisplayed();
        String str4 = String.valueOf(h4);
        Assert.assertTrue(h4);
        Boolean h5=driver.findElement(By.linkText("Log in")).isDisplayed();
        String str5 = String.valueOf(h5);
        Assert.assertTrue(h5);
        Boolean h6=driver.findElement(By.linkText("Sign up")).isDisplayed();
        String str6 = String.valueOf(h6);
        Assert.assertTrue(h6);

        Reporter.log("The heading 1 is displayed: " + str1);
        Reporter.log("The heading 2 is displayed: " + str2);
        Reporter.log("The heading 3 is displayed: " + str3);
        Reporter.log("The heading 4 is displayed: " + str4);
        Reporter.log("The heading 5 is displayed: " + str5);
        Reporter.log("The heading 6 is displayed: " + str6);

    }

    @Test(priority = 3)
    public void category() { //to validate the available category list (using findElements method); then iterate the captured list against the provided category values; then assert it

        String[] categoryvalue = {"CATEGORIES","Phones", "Laptops","Monitors"};
        int categoryvaluecount=categoryvalue.length;


        List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='list-group']/a"));
        int alllinkscount=allLinks.size();

        for(int i=0; i<categoryvalue.length; i++)
        {
            if(allLinks.get(i).getText().equalsIgnoreCase(categoryvalue[i]))
                Reporter.log(allLinks.get(i).getText()+ " Matches " + categoryvalue[i]);

            else
                Reporter.log("Didn't match");
        }

        for(int i=0; i<categoryvalue.length; i++){
            Assert.assertEquals(categoryvalue[i], allLinks.get(i).getText());   //asserting the extectedstring vs actualstring values
        }

        Assert.assertEquals(alllinkscount,categoryvaluecount); //asserting the count value. [Since if expectedlist count is greateer than the actual, we cant validate that]

    }

    @AfterMethod
    public void teardown(){
    driver.close();
    }


}
