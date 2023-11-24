package com.week4exercise2.Exercise24;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.impl.nio.ExpandableBuffer;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

@RestController
public class LeetcodeController {

    @RequestMapping("/leetcodeEditor")
    public String scrappingEditing() throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://leetcode.com/playground/new/empty");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("langMenu"))).click();

        WebElement java = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[1]/div[1]/div[2]/span/div/ul/div[2]"));
        java.click();

        WebElement textArea = driver.findElement(By.className("CodeMirror-lines"));
        wait.until(ExpectedConditions.visibilityOf(textArea));

        Actions actions = new Actions(driver);
        actions.moveToElement(textArea).click().build().perform();
        actions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .build()
                .perform();

        String code = getCodeFromFile("C://Users//U6074525//IdeaProjects//Exercise-2//src//main//java//com//Exercise2//Example.java");

        actions.sendKeys(code).build().perform();

        WebElement runButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='app']/div/div/div/div[1]/div[1]/div[1]/button")));
        runButton.click();

        Thread.sleep(5000);

        WebElement output = driver.findElement(By.xpath("//*[@id='output']/div[2]/div"));
        String result = output.getText();

        return result;
    }


    private String getCodeFromFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        List<String> lines = Files.readAllLines(path);
        String newCode = String.join("",lines);

        return newCode;
    }
}
