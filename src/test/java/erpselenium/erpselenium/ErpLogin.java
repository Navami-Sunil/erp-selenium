package erpselenium.erpselenium;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErpLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        try {
            driver.manage().window().maximize();
            driver.get("https://erp.people10.com/#login");

            WebElement googleLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Google']")));
            googleLogin.click();

            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
            emailField.sendKeys("");
            WebElement nextButtonEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
            nextButtonEmail.click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Passwd']")));
            passwordField.sendKeys("");
            WebElement nextButtonPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
            nextButtonPassword.click();

            WebElement projectsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Projects')]")));
            projectsTab.click();

            WebElement timesheetLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href=\"#List/Timesheet\"])[2]")));
            timesheetLink.click();

            WebElement primaryActionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-sm primary-action']")));
            primaryActionButton.click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[@data-fieldname=\"activity_type\"])[2]")).click();
            driver.findElement(By.xpath("//input[@class=\"input-with-feedback form-control bold input-sm\"]")).sendKeys("internal");
            Thread.sleep(5000);
            WebElement element = driver.findElement(By.xpath("//strong[text()='GEN - Internal Training']"));
            Thread.sleep(2000);
            element.click();
            WebElement fromTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-fieldname='from_time']")));
            fromTimeInput.click();
            Thread.sleep(3000);
            LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
            currentTime = currentTime.minusHours(8);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedTime = currentTime.format(formatter);
            WebElement timeInput = driver.findElement(By.xpath("//input[@data-fieldname='from_time']"));
            timeInput.sendKeys(formattedTime);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@placeholder=\"Hrs\"]")).click();
            driver.findElement(By.xpath("//input[@placeholder=\"Hrs\"]")).sendKeys("8");

            Thread.sleep(500);
            driver.findElement(By.xpath("//input[@placeholder=\"Project\"]")).click();
            driver.findElement(By.xpath("//input[@placeholder=\"Project\"]")).sendKeys("vortex");
            Thread.sleep(2000);
            WebElement project = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='AGT - Vortex']")));
            Thread.sleep(2000);
            project.click();

            driver.findElement(By.xpath("//span[@data-label=\"Save\"]")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//a[@href=\"#List/Timesheet\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@data-value=\"100\"]")).click();
            Thread.sleep(2000);

            LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDateTime.format(dateFormatter);

            String dynamicXPath = String.format("//a[@data-filter='start_date,=,%s']", formattedDate);
            WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));

            if (dateElement.isDisplayed()) {
                System.out.println("ERP timesheet for today is successfully saved");
            }
           
            Thread.sleep(3000);
        } finally {
            driver.quit();
        }
    }
}






































































//package erpselenium.erpselenium;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.util.TimeZone;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class ErpLogin {
//
//    public static void main(String[] args) throws InterruptedException {
//  
//        WebDriver driver = new ChromeDriver();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100)); 
//
//        try {
//            driver.manage().window().maximize();
//            driver.get("https://erp.people10.com/#login");
//
//            WebElement googleLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Google']")));
//            googleLogin.click();
//
//            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
//            emailField.sendKeys("");
//            WebElement nextButtonEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
//            nextButtonEmail.click();
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Passwd']")));
//            passwordField.sendKeys("");
//            WebElement nextButtonPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
//            nextButtonPassword.click();
//       
//            
// 
//            WebElement projectsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Projects')]")));
//            projectsTab.click();
//
//            
//            WebElement timesheetLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href=\"#List/Timesheet\"])[2]")));
//            timesheetLink.click();
//
//            WebElement primaryActionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-sm primary-action']")));
//            primaryActionButton.click();
//            
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("(//div[@data-fieldname=\"activity_type\"])[2]")).click();
// 	       driver.findElement(By.xpath("//input[@class=\"input-with-feedback form-control bold input-sm\"]")).sendKeys("internal");
// 	       Thread.sleep(5000);
// 	       WebElement element = driver.findElement(By.xpath("//strong[text()='GEN - Internal Training']"));
// 	       Thread.sleep(2000);
//            element.click();
//            WebElement fromTimeInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-fieldname='from_time']")));
//            fromTimeInput.click();
//            Thread.sleep(3000);
//            LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
//            currentTime = currentTime.minusHours(8); 
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//            String formattedTime = currentTime.format(formatter);
//            WebElement timeInput = driver.findElement(By.xpath("//input[@data-fieldname='from_time']")); 
//            timeInput.sendKeys(formattedTime);
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//input[@placeholder=\"Hrs\"]")).click();
//            driver.findElement(By.xpath("//input[@placeholder=\"Hrs\"]")).sendKeys("8");
//            
//            
//            Thread.sleep(500);
//            driver.findElement(By.xpath("//input[@placeholder=\"Project\"]")).click();
//            driver.findElement(By.xpath("//input[@placeholder=\"Project\"]")).sendKeys("vortex");
//            Thread.sleep(2000);
//            WebElement project = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[text()='AGT - Vortex']")));
//            Thread.sleep(2000);
//            project.click();
//            
//            driver.findElement(By.xpath("//span[@data-label=\"Save\"]")).click();
//            Thread.sleep(5000);
//            
//            driver.findElement(By.xpath("//a[@href=\"#List/Timesheet\"]")).click();
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//button[@data-value=\"100\"]")).click();
//            Thread.sleep(2000);
//            
//            
//        } finally {
//            driver.quit();
//        }
//    }
//}
