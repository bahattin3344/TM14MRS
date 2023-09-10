import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bilgehan extends BaseDriver {

    @Test
    public void TM14MRS_5(){
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        Actions driverAksiyon = new Actions(driver);

        WebElement usernameBox = driver.findElement(By.name("username"));
        usernameBox.sendKeys("admin");

        WebElement laboratoryLink = driver.findElement(By.id("Laboratory"));
        laboratoryLink.click();

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("Admin123", Keys.ENTER);

        WebElement myAccountHover = driver.findElement(By.xpath("//li[@class='nav-item identifier']"));
        Action aksiyon = driverAksiyon.moveToElement(myAccountHover).build();
        aksiyon.perform();

        WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
        myAccountLink.click();

        Assert.assertTrue(driver.findElement(By.className("icon-lock")).isEnabled(), "Şifremi değiştir bulunamadı...");
        Assert.assertTrue(driver.findElement(By.className("icon-cog")).isEnabled(), "My Language bulunamadı...");

    }

    @Test
    public void TM14MRS_6(){
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        Actions driverAksiyon = new Actions(driver);

        WebElement usernameBox = driver.findElement(By.name("username"));
        usernameBox.sendKeys("admin");

        WebElement laboratoryLink = driver.findElement(By.id("Laboratory"));
        laboratoryLink.click();

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("Admin123", Keys.ENTER);

        WebElement findPatientRecordButton = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        findPatientRecordButton.click();

        WebElement searchBox = driver.findElement(By.cssSelector("[placeholder = 'Search by ID or Name']"));
        searchBox.sendKeys("rohit sharma");

        WebElement patient = driver.findElement(By.xpath("//tr[@class='odd']/td"));
        driverAksiyon.moveToElement(patient).click(patient).build().perform();
    }
}
