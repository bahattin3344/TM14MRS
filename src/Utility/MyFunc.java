package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class MyFunc {

    public static void Bekle(int sn){

        try {
            Thread.sleep(sn*1000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    // Çoğu yerde aynı mesaj doğrulaması kullanıldığı için bu bölümü
    // ortak fonksiyonların yer aldığı MyFunc a taşındı.





}
