package Tamella_Bushra;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HataliGiris extends BaseDriver{


    @Test(groups = {"Smoke Test"})
        public void hataliGirisTest(){


            Actions aksiyonlar=new Actions(driver);

            driver.get("https://openmrs.org/");
            WebElement demo=driver.findElement(By.xpath("//a[@class='zak-button']"));
            aksiyonlar.moveToElement(demo).click().build().perform();
            MyFunc.Bekle(2);


            WebElement openMrs2=driver.findElement(By.xpath("//a[@href='#openmrs2']"));
            aksiyonlar.moveToElement(openMrs2).click().build().perform();
            MyFunc.Bekle(2);


            WebElement open=driver.findElement(By.xpath("//a[@href='https://demo.openmrs.org/openmrs/login.htm']"));
            aksiyonlar.moveToElement(open).click().build().perform();
            MyFunc.Bekle(2);


            WebElement username=driver.findElement(By.name("username"));
            username.sendKeys("bushra");
            MyFunc.Bekle(2);

            WebElement password=driver.findElement(By.name("password"));
            password.sendKeys("122345");
            MyFunc.Bekle(2);

            WebElement logInB=driver.findElement(By.id("loginButton"));
            aksiyonlar.moveToElement(logInB).click().build().perform();
            MyFunc.Bekle(2);

            WebElement onaylama=driver.findElement(By.id("sessionLocationError"));
            Assert.assertTrue(onaylama.getText().contains("You must choose a location!"));
            MyFunc.Bekle(2);

            WebElement location=driver.findElement(By.id("Inpatient Ward"));
            aksiyonlar.moveToElement(location).click().build().perform();
            MyFunc.Bekle(2);

            WebElement logIn2=driver.findElement(By.id("loginButton"));
            aksiyonlar.moveToElement(logIn2).click().build().perform();
            MyFunc.Bekle(2);

            WebElement onaylama2=driver.findElement(By.id("error-message"));
            Assert.assertTrue(onaylama2.getText().contains("Invalid username/password. Please try again."));
            MyFunc.Bekle(2);


            WebElement username2=driver.findElement(By.name("username"));
            username2.sendKeys("admin");
            MyFunc.Bekle(2);

            WebElement password2=driver.findElement(By.name("password"));
            password2.sendKeys("Admin123");
            MyFunc.Bekle(2);

            WebElement location2=driver.findElement(By.id("Inpatient Ward"));
            aksiyonlar.moveToElement(location2).click().build().perform();
            MyFunc.Bekle(2);

            WebElement logIn3=driver.findElement(By.id("loginButton"));
            aksiyonlar.moveToElement(logIn3).click().build().perform();
            MyFunc.Bekle(2);

        }
    }
