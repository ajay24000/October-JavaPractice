package com.Exercise2;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

@RestController
public class LeetcodeController {

    @RequestMapping("/leetcode")
    public String scrapping() throws IOException, InterruptedException {

        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(true);

        HtmlPage page = client.getPage("https://leetcode.com/playground/new/empty");
        Thread.sleep(3000);
        DomElement element = page.getFirstByXPath(".//button[@id='langMenu']");
        element.click();

        HtmlUnitDriver driver = new HtmlUnitDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://leetcode.com/playground/new/empty");
        System.out.println(driver.getTitle());

//        WebElement langDropdown = driver.findElement(By.xpath("//*[@id='langMenu']"));  ////*[@id="langMenu"]
//        langDropdown.click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@id='langMenu']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@id='langMenu']"))).click();


        WebElement java = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[1]/div[1]/div[2]/span/div/ul/div[2]"));
        java.click();

        WebElement textArea = driver.findElement(By.className("CodeMirror-lines"));
        wait.until(ExpectedConditions.visibilityOf(textArea));
        // Actions

        Actions actions = new Actions(driver);
        actions.moveToElement(textArea).click().build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();


        String code = getCodeFromFile("C://Users//U6074525//IdeaProjects//Exercise-2//src//main//java//com//Exercise2//Example.java");
        actions.sendKeys(code).build().perform();


        WebElement run = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div/div[1]/div[1]/div[1]/button")));
        run.click();

        Thread.sleep(5000);

        WebElement output = driver.findElement(By.xpath("//*[@id='output']/div[2]/div"));
        String result = output.getText();

        return result;
    }

    private static String getCodeFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        return new String(Files.readAllBytes(path));
    }

}

