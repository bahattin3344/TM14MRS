package Utility;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver; // SingletonDriver method
    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemleri(){

        Logger logger= Logger.getLogger(""); // output yapılan logları al.
        logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

        driver = new ChromeDriver(); // jenkins deyken : sen head olmadan yani hafızada çalış
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       loginTesti();

    }
    public static void loginTesti() {

        driver.get("https://openmrs.org/");
        Actions aksiyonlar = new Actions(driver);
        MyFunc.Bekle(2);
        WebElement demo = driver.findElement(By.xpath("//a[@class='zak-button']"));
        aksiyonlar.moveToElement(demo).click().build().perform();
        MyFunc.Bekle(1);


        WebElement openMrs2 = driver.findElement(By.xpath("//a[@href='#openmrs2']"));
        aksiyonlar.moveToElement(openMrs2).click().build().perform();
        MyFunc.Bekle(1);


        WebElement open = driver.findElement(By.xpath("//a[@href='https://demo.openmrs.org/openmrs/login.htm']"));
        aksiyonlar.moveToElement(open).click().build().perform();
        MyFunc.Bekle(1);


        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("admin");
        MyFunc.Bekle(1);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Admin123");
        MyFunc.Bekle(1);

        WebElement location = driver.findElement(By.id("Inpatient Ward"));
        aksiyonlar.moveToElement(location).click().build().perform();
        MyFunc.Bekle(1);

        WebElement logIn = driver.findElement(By.id("loginButton"));
        aksiyonlar.moveToElement(logIn).click().build().perform();
        MyFunc.Bekle(1);


    }


  //  @AfterClass
   // public void bitisIslemleri(){ // tearDown
    //    MyFunc.Bekle(5);
     //   driver.quit();
   // }

}
