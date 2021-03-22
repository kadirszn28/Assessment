package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    public static void switchWindowByTitle(WebDriver driver, String targetTitle) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getTitle().equals(targetTitle)) {
                driver.switchTo().window(id);
            }

        }

    }

    public static void switchWindowByUrl(WebDriver driver, String url) {

        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!driver.getCurrentUrl().equals(url)) {
                driver.switchTo().window(id);
            }
        }
    }

    public static void closeWindows(WebDriver driver, String parentId) {
        Set<String> ids = driver.getWindowHandles();
        for (String id : ids) {
            if (!id.equals(parentId)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    // Create a method for fluent wait
    public static WebElement fluentWait(WebDriver driver, long totalSec, long pollingSecond, By locator) {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(totalSec))
                .pollingEvery(Duration.ofSeconds(pollingSecond))
                .ignoring(RuntimeException.class);

        return wait.until(driver1 -> driver1.findElement((locator)));


    }

    public static WebElement visibilityOf(WebDriver driver, int timeInSec, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeInSec);

        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static WebElement visibilityOfElementLocated(WebDriver driver, int timeSec, By locator) {

        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String takeScreenShot() {
        // First we cast driver to takeScreenshot
        // then we get the screenShot as FILE
        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        // WE need the destination to store all my screenshots
        // System.getProperty("user.dir") it will give the project location
        // /Users/yusufaycicek/IdeaProjects/CucumberBatch4
        // String destination=System.getProperty("user.dir")+"\\Screenshot\\" for windows
        // System.currentTimeMillis() helps us to give unique name for my screenShot
        String destination = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
        File des = new File(destination);

        try {
            // copyFile will get the file from source and store to the destination
            FileUtils.copyFile(src, des);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;

    }

    //"MM/dd/yyyy"
    public static String todaysDate(String formatType) {

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatType);

        return formatter.format(today);

    }

    public static void switchFrameByIndex(WebDriver driver, int index) {

        driver.switchTo().frame(index);

    }

    public static void switchFrameByElement(WebDriver driver, By locator) {

        driver.switchTo().frame(driver.findElement(locator));

    }

    public static void switchFrameByWebElement(WebDriver driver, int element) {

        driver.switchTo().frame(element);

    }

    public static List<String> getTextOfElement(List<WebElement> lists) {

        List<String> texts = new ArrayList<>();
        for (WebElement list : lists) {
            texts.add(list.getText().trim());

        }
        return texts;
    }


    public static void selectByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }

    public static void hoverOver(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

}
