package Tamella_Bushra;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HastaKayit extends BaseDriver{

    @Test(groups = {"Regression"})
    public void hKayitTesti(){


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



        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");


        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");


        WebElement location = driver.findElement(By.id("Inpatient Ward"));
        aksiyonlar.moveToElement(location).click().build().perform();


        WebElement logIn = driver.findElement(By.id("loginButton"));
        aksiyonlar.moveToElement(logIn).click().build().perform();


        WebElement registerP = driver.findElement(By.xpath("//i[@class='icon-user']"));
        aksiyonlar.moveToElement(registerP).click().build().perform();


        WebElement name = driver.findElement(By.name("givenName"));
        name.sendKeys("Yaşar");


        WebElement fName = driver.findElement(By.name("familyName"));
        fName.sendKeys("Yaşamaz");


        WebElement next = driver.findElement(By.id("next-button"));
        aksiyonlar.moveToElement(next).click().build().perform();


       WebElement gender = driver.findElement(By.xpath("//select[@id='gender-field']"));
        Select c = new Select(gender);
        c.selectByVisibleText("Male");
        MyFunc.Bekle(2);

        WebElement next2 = driver.findElement(By.id("next-button"));
        aksiyonlar.moveToElement(next2).click().build().perform();


        WebElement day = driver.findElement(By.name("birthdateDay"));
        day.sendKeys("11");

        WebElement month = driver.findElement(By.id("birthdateMonth-field"));
        Select m = new Select(month);
        m.selectByVisibleText("November");

        WebElement year = driver.findElement(By.name("birthdateYear"));
        year.sendKeys("2000");


        WebElement next3 = driver.findElement(By.id("next-button"));
        aksiyonlar.moveToElement(next3).click().build().perform();
        MyFunc.Bekle(2);

        WebElement address1 = driver.findElement(By.id("address1"));
        address1.sendKeys("Fevzi Çakmak Mah.");

        WebElement address2 = driver.findElement(By.id("address2"));
        address2.sendKeys("Sevgi Sok.");

        WebElement city = driver.findElement(By.id("cityVillage"));
        city.sendKeys("Ankara");

        WebElement state = driver.findElement(By.id("stateProvince"));
        state.sendKeys("Çankaya");

        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys("Türkiye");

        WebElement code = driver.findElement(By.id("postalCode"));
        code.sendKeys("111111");

        WebElement next4 = driver.findElement(By.id("next-button"));
        aksiyonlar.moveToElement(next4).click().build().perform();

        WebElement phone = driver.findElement(By.name("phoneNumber"));
        phone.sendKeys("+905051231212");
        MyFunc.Bekle(2);

        WebElement next5 = driver.findElement(By.id("next-button"));
        aksiyonlar.moveToElement(next5).click().build().perform();

        WebElement relatives = driver.findElement(By.id("relationship_type"));
        Select r = new Select(relatives);
        r.selectByVisibleText("Parent");

        WebElement pName = driver.findElement(By.cssSelector("input[ng-model='relationship.name']"));
        pName.sendKeys("Fatma");
        MyFunc.Bekle(2);

        WebElement next6 = driver.findElement(By.id("next-button"));
        aksiyonlar.moveToElement(next6).click().build().perform();

        WebElement submit = driver.findElement(By.id("submit"));
        aksiyonlar.moveToElement(submit).click().build().perform();


        WebElement onaylama1=driver.findElement(By.xpath("//span[@class='PersonName-givenName']"));
        Assert.assertTrue(onaylama1.getText().contains("Yaşar"));
        MyFunc.Bekle(2);


        WebElement onaylama2=driver.findElement(By.xpath("//div[@class='float-sm-right']"));
        Assert.assertTrue(onaylama2.getText().contains("Patient ID"));
        MyFunc.Bekle(2);





    }
}
