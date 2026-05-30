package Testng_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Form_Test {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    TakesScreenshot tc;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test(priority = 1, groups = "Smoke")
    public void f() {

        js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Umesh Das");
        driver.findElement(By.id("email")).sendKeys("umesh@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("1234567809");
        driver.findElement(By.id("textarea")).sendKeys("SBP,Odisha");

        js.executeScript("window.scrollBy(0,500)");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("male"))).click();

        WebElement days = driver.findElement(By.xpath("//*[@id='Blog1']/div[1]"));
        days.findElement(By.id("monday")).click();
        days.findElement(By.id("saturday")).click();

        // Country dropdown
        WebElement country = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("country")));
        country.click();
        country.sendKeys("Ind");
        country.sendKeys(Keys.ENTER);

        // Colors dropdown
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='animals']/option[7]"))).click();

        // Datepicker 1
        wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='ui-datepicker-div']/div/a[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]"))).click();

        js.executeScript("window.scrollBy(0,700)");

        // Datepicker 2
        wait.until(ExpectedConditions.elementToBeClickable(By.id("txtDate"))).click();

        WebElement yr = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ui-datepicker-year")));
        WebElement mt = driver.findElement(
                By.xpath("//select[@class='ui-datepicker-month']"));

        Select sel = new Select(yr);
        sel.selectByIndex(10);

        Select sel1 = new Select(mt);
        sel1.selectByValue("3");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[3]"))).click();

        // Upload files
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("singleFileInput")))
                .sendKeys("C:\\Users\\umesh\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-05-12 124527.png");

        driver.findElement(By.xpath("//*[@id='singleFileForm']/button")).click();

        driver.findElement(By.id("multipleFilesInput")).sendKeys(
                "C:\\Users\\umesh\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-05-12 124527.png\n" +
                "C:\\Users\\umesh\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-05-11 161932.png");

        driver.findElement(By.xpath("//*[@id='multipleFilesForm']/button")).click();

        Actions ac = new Actions(driver);

        // Double click
        WebElement dc = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='HTML10']/div[1]/button")));
        ac.doubleClick(dc).perform();

        // Drag and Drop
        WebElement sr = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("draggable")));
        WebElement tg = driver.findElement(By.id("droppable"));

        ac.dragAndDrop(sr, tg).perform();

        js.executeScript("window.scrollBy(0,600)");

        // Slider
        WebElement ls = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]")));
        ac.dragAndDropBy(ls, 100, 0).perform();

        // Combo dropdown
        WebElement drpd = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("comboBox")));
        drpd.click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='option'])[87]"))).click();

        ///////////////////////

        js.executeScript("window.scrollBy(0,-1250)");

        // Alert
        wait.until(ExpectedConditions.elementToBeClickable(By.id("alertBtn"))).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        // Confirm Alert
        wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmBtn"))).click();
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();

        // Prompt Alert
        wait.until(ExpectedConditions.elementToBeClickable(By.id("promptBtn"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//      alert.sendKeys("Harry Potter");
        alert.accept();

        // Mouse hover
        WebElement mh = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@class='dropbtn']")));
        ac.moveToElement(mh).perform();
    }

    @Test(priority = 2, groups = "Regression")
    public void fn() throws InterruptedException, IOException {

//        String parent = driver.getWindowHandle();
//
//        // New tab
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//*[@id='HTML4']/div[1]/button"))).click();
//
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//
//        driver.switchTo().window(tabs.get(1));
//        driver.close();
//
//        driver.switchTo().window(parent);
//
//        // Popup window
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("PopUp"))).click();
//
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//        for (String win : driver.getWindowHandles()) {
//
//            if (!win.equals(parent)) {
//
//                driver.switchTo().window(win);
//                driver.close();
//            }
//        }
//
//        driver.switchTo().window(parent);
    	
		//original tab
		String parent = driver.getWindowHandle();

		
		driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/button")).click();

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

	
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);

		driver.close();
	
		driver.switchTo().window(parent);

		driver.findElement(By.id("PopUp")).click();
		Thread.sleep(3000);

	
		for(String win : driver.getWindowHandles()) {
		    if(!win.equals(parent)) {
		        driver.switchTo().window(win);
		        driver.close();
		    }
		}

		
		driver.switchTo().window(parent);
		
		Thread.sleep(1000);
		tc = (TakesScreenshot)driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("Output.png");
		FileHandler.copy(src,dest);
    	
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {

        System.out.println("Successfully done");
        driver.close();
    }
}