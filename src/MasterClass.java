import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MasterClass extends BaseDriver {


    @Test(groups = {"Smoke Test"})
    public void T1CikisTesti() {

        WebElement logOut = driver.findElement(By.cssSelector("li.nav-item.logout > a"));
        logOut.click();
        MyFunc.Bekle(1);
    }


    @Test(groups = {"Regression"})
    public void T3KayitTesti() {

        for (int i = 0; i < 2; i++) {

            WebElement registerP = driver.findElement(By.xpath("//i[@class='icon-user']"));
            driverAksiyon.moveToElement(registerP).click().build().perform();


            WebElement name = driver.findElement(By.name("givenName"));
            name.sendKeys("Yaşar");


            WebElement fName = driver.findElement(By.name("familyName"));
            fName.sendKeys("Yaşamaz");


            WebElement next = driver.findElement(By.id("next-button"));
            driverAksiyon.moveToElement(next).click().build().perform();


            WebElement gender = driver.findElement(By.xpath("//select[@id='gender-field']"));
            Select c = new Select(gender);
            c.selectByVisibleText("Male");
            MyFunc.Bekle(2);

            WebElement next2 = driver.findElement(By.id("next-button"));
            driverAksiyon.moveToElement(next2).click().build().perform();


            WebElement day = driver.findElement(By.name("birthdateDay"));
            day.sendKeys("11");

            WebElement month = driver.findElement(By.id("birthdateMonth-field"));
            Select m = new Select(month);
            m.selectByVisibleText("November");

            WebElement year = driver.findElement(By.name("birthdateYear"));
            year.sendKeys("2000");


            WebElement next3 = driver.findElement(By.id("next-button"));
            driverAksiyon.moveToElement(next3).click().build().perform();
         //   MyFunc.Bekle(2);

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
            driverAksiyon.moveToElement(next4).click().build().perform();

            WebElement phone = driver.findElement(By.name("phoneNumber"));
            phone.sendKeys("+905051231212");
         //   MyFunc.Bekle(2);

            WebElement next5 = driver.findElement(By.id("next-button"));
            driverAksiyon.moveToElement(next5).click().build().perform();

            WebElement relatives = driver.findElement(By.id("relationship_type"));
            Select r = new Select(relatives);
            r.selectByVisibleText("Parent");

            WebElement pName = driver.findElement(By.cssSelector("input[ng-model='relationship.name']"));
            pName.sendKeys("Fatma");
        //    MyFunc.Bekle(2);

            WebElement next6 = driver.findElement(By.id("next-button"));
            driverAksiyon.moveToElement(next6).click().build().perform();

            WebElement submit = driver.findElement(By.id("submit"));
            driverAksiyon.moveToElement(submit).click().build().perform();


            WebElement onaylama1 = driver.findElement(By.xpath("//span[@class='PersonName-givenName']"));
            Assert.assertTrue(onaylama1.getText().contains("Yaşar"));
         //   MyFunc.Bekle(2);


            WebElement onaylama2 = driver.findElement(By.xpath("//div[@class='float-sm-right']"));
            Assert.assertTrue(onaylama2.getText().contains("Patient ID"));
            MyFunc.Bekle(2);
            driver.navigate().back();
            driver.navigate().back();

        }

    }

    @Test(groups = {"Smoke"})
    public void T2M14MRS_5() {

        loginTesti();
        WebElement myAccountHover = driver.findElement(By.cssSelector("[class='icon-caret-down appui-icon-caret-down link']"));
        Action aksiyon = driverAksiyon.moveToElement(myAccountHover).build();
        aksiyon.perform();
        MyFunc.Bekle(2);
     // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user-account-menu > li > a")));
        WebElement myAccountLink = driver.findElement(By.cssSelector("#user-account-menu"));
        myAccountLink.click();
        Assert.assertTrue(driver.findElement(By.className("icon-lock")).isEnabled(), "Şifremi değiştir bulunamadı...");
        Assert.assertTrue(driver.findElement(By.className("icon-cog")).isEnabled(), "My Language bulunamadı...");
        driver.navigate().back();
    }

    @Test(groups = {"PatientManagement"})
    public void T4M14MRS_6() {


        WebElement findPatientRecordButton = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientRecordButton.click();

        WebElement searchBox = driver.findElement(By.cssSelector("[placeholder = 'Search by ID or Name']"));
        searchBox.sendKeys("Yaşar Yaşamaz");

        MyFunc.Bekle(5);

        WebElement patient = driver.findElement(By.xpath("//tr[@class='odd']/td"));
        driverAksiyon.moveToElement(patient).click(patient).build().perform();

        List<WebElement> recentVisits = driver.findElements(By.xpath("//div[@class='info-body']/visitbyencountertype/ul/li"));

        for (WebElement e : recentVisits) {
            System.out.println(e.getText());
        }
        driver.navigate().back();

        driver.navigate().back();
    }

    @Test(groups = {"PatientManagement"})
    public void T5M14MRS_6_Negative() {

        WebElement findPatientRecordButton = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientRecordButton.click();

        WebElement searchBox = driver.findElement(By.cssSelector("[placeholder = 'Search by ID or Name']"));
        searchBox.sendKeys("mesut komiser");

        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='No matching records found']")).getText().contains("No matching"));
        MyFunc.Bekle(1);
        driver.navigate().back();
    }

    @Test(groups = {"Smoke", "PatientManagement"})
    public void T6HSilme() {

        WebElement hKaydı = driver.findElement(By.cssSelector("[id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        hKaydı.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='form-control']")));
        WebElement arama = driver.findElement(By.cssSelector("[class='form-control']"));
        arama.sendKeys("John Green");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='odd'")));
        WebElement hasta = driver.findElement(By.cssSelector("[class='odd'"));
        hasta.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#org\\.openmrs\\.module\\.coreapps\\.deletePatient div > div.col-11.col-lg-10")));
        WebElement delete = driver.findElement(By.cssSelector("#org\\.openmrs\\.module\\.coreapps\\.deletePatient div > div.col-11.col-lg-10"));
        delete.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='delete-reason']")));
        WebElement deleteReason = driver.findElement(By.cssSelector("[id='delete-reason']"));
        deleteReason.sendKeys("YES");
        MyFunc.Bekle(1);
        WebElement btn = driver.findElement(By.cssSelector("#delete-patient-creation-dialog div.dialog-content > button.confirm.right"));
        btn.click();
        MyFunc.Bekle(1);
        WebElement back=driver.findElement(By.cssSelector("[class='icon-home small']"));
        back.click();
    }
    @Test (groups = {"Regression", "PatientManagement"})
    public void T7M14MRS_8(){



        WebElement findPatientRecordButton = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientRecordButton.click();

        List<WebElement> patientsList = driver.findElements(By.xpath("//tbody[@role='alert']/tr"));
        WebElement totalPatient = driver.findElement(By.id("patient-search-results-table_info"));

        Assert.assertTrue(totalPatient.getText().contains(String.valueOf(patientsList.size())));
        driver.navigate().back();
    }



    @Test(groups = {"Regression", "PatientManagement"})
    public void T8Birlestirme() {

        WebElement data = driver.findElement(By.cssSelector("[id='coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension']"));
        data.click();
      //  MyFunc.Bekle(2);
        WebElement merge = driver.findElement(By.cssSelector("[id='coreapps-mergePatientsHomepageLink-app']"));
        merge.click();
      //  MyFunc.Bekle(2);
        WebElement h1 = driver.findElement(By.cssSelector("[id='patient1-text']"));
        h1.sendKeys("100RH2");
        WebElement h2 = driver.findElement(By.cssSelector("[id='patient2-text']"));
        h2.sendKeys("100RLV"+Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='confirm-button']")));
        WebElement btn = driver.findElement(By.cssSelector("[id='confirm-button']"));
        btn.click();

        WebElement firstH = driver.findElement(By.cssSelector("[id='first-patient']"));
        firstH.click();
        WebElement confirmBtn = driver.findElement(By.cssSelector("[id='confirm-button']"));
        confirmBtn.click();
        MyFunc.Bekle(3);

        WebElement back=driver.findElement(By.cssSelector("[class='icon-home small']"));
        back.click();

    }

    @Test(groups = {"Regression", "Appointment"})
    public void T9Saat() {

        WebElement app = driver.findElement(By.cssSelector("[id='appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension']"));
        app.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='appointmentschedulingui-manageAppointments-app']")));
        WebElement manage = driver.findElement(By.cssSelector("[id='appointmentschedulingui-manageAppointments-app']"));
        manage.click();
        WebElement search = driver.findElement(By.cssSelector("[class='form-control']"));
        search.sendKeys("Yaşar Yaşamaz");
        MyFunc.Bekle(1);
        WebElement hBtn = driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr[1]"));
        hBtn.click();
        MyFunc.Bekle(1);
        WebElement hata = driver.findElement(By.cssSelector("#error-message > div > div.text > i"));
        MyFunc.Bekle(1);
        WebElement back=driver.findElement(By.cssSelector("[class='icon-home small']"));
        back.click();

    }


}