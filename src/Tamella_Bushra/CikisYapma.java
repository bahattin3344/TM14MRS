package Tamella_Bushra;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utility.BaseDriver.driver;

public class CikisYapma extends BaseDriver {


    @Test(groups = {"Smoke Test"})
    public void cikisTesti(){


        Actions aksiyonlar = new Actions(driver);

        driver.get("https://openmrs.org/");

        WebElement demo = driver.findElement(By.xpath("//a[@class='zak-button']"));
        aksiyonlar.moveToElement(demo).click().build().perform();
        MyFunc.Bekle(2);


        WebElement openMrs2 = driver.findElement(By.xpath("//a[@href='#openmrs2']"));
        aksiyonlar.moveToElement(openMrs2).click().build().perform();
        MyFunc.Bekle(2);


        WebElement open = driver.findElement(By.xpath("//a[@href='https://demo.openmrs.org/openmrs/login.htm']"));
        aksiyonlar.moveToElement(open).click().build().perform();
        MyFunc.Bekle(2);


        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        MyFunc.Bekle(2);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");
        MyFunc.Bekle(2);

        WebElement location = driver.findElement(By.id("Inpatient Ward"));
        aksiyonlar.moveToElement(location).click().build().perform();
        MyFunc.Bekle(2);

        WebElement logIn = driver.findElement(By.id("loginButton"));
        aksiyonlar.moveToElement(logIn).click().build().perform();
        MyFunc.Bekle(2);

        WebElement logOut= driver.findElement(By.xpath("//a[@href='/openmrs/appui/header/logout.action?successUrl=openmrs']"));
        aksiyonlar.moveToElement(logOut).click().build().perform();
        MyFunc.Bekle(2);



    }
}
