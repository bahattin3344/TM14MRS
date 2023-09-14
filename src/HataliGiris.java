import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HataliGiris {


    @Test(groups = {"Smoke Test"},dataProvider = "UserData")
        public void hataliGirisTest(String username, String password){
            WebDriver driver=new ChromeDriver();
            Actions aksiyonlar=new Actions(driver);

            driver.get("https://openmrs.org/");
            WebElement demo=driver.findElement(By.xpath("//a[@class='zak-button']"));
            aksiyonlar.moveToElement(demo).click().build().perform();
            MyFunc.Bekle(1);


            WebElement openMrs2=driver.findElement(By.xpath("//a[@href='#openmrs2']"));
            aksiyonlar.moveToElement(openMrs2).click().build().perform();
            MyFunc.Bekle(1);


            WebElement open=driver.findElement(By.xpath("//a[@href='https://demo.openmrs.org/openmrs/login.htm']"));
            aksiyonlar.moveToElement(open).click().build().perform();
            MyFunc.Bekle(1);


            WebElement username1=driver.findElement(By.name("username"));
            username1.sendKeys(username+ Keys.ENTER);


            WebElement password1=driver.findElement(By.name("password"));
            password1.sendKeys(password+Keys.ENTER);


            WebElement logInB=driver.findElement(By.id("loginButton"));
            aksiyonlar.moveToElement(logInB).click().build().perform();


            WebElement onaylama=driver.findElement(By.id("sessionLocationError"));
            Assert.assertTrue(onaylama.getText().contains("You must choose a location!"));
            MyFunc.Bekle(1);

            WebElement location=driver.findElement(By.id("Inpatient Ward"));
            aksiyonlar.moveToElement(location).click().build().perform();
            MyFunc.Bekle(1);

            WebElement logIn2=driver.findElement(By.id("loginButton"));
            aksiyonlar.moveToElement(logIn2).click().build().perform();


            WebElement onaylama2=driver.findElement(By.id("error-message"));
            Assert.assertTrue(onaylama2.getText().contains("Invalid username/password. Please try again."));
            MyFunc.Bekle(1);
           driver.quit();
        }

    @DataProvider
    public Object[][] UserData(){
        Object[][] data={
                {"bushra","11111"},
                {"tamella", "11111"},
                {"bilgehan","11111"},
                {"deniz", "11111"},
                {"bilal","11111"},
                {"hakan","11111"}
        };

        return data;
    }

    }
