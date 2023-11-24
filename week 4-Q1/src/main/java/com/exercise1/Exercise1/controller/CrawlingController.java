package com.exercise1.Exercise1.controller;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CrawlingController {

    @RequestMapping("/scrap")
    public Map<String, List<String>> scrapping() throws IOException {
        try (final WebClient client = new WebClient()) {
            client.getOptions().setJavaScriptEnabled(false);
            client.getOptions().setCssEnabled(false);

            HtmlPage homepage = client.getPage("https://clarivate.com/");
            client.waitForBackgroundJavaScript(1000);
            System.out.println(homepage.getTitleText());

            HtmlAnchor element = homepage.getFirstByXPath(".//*[@id='menu-item-7']//a");
            HtmlPage productAndServices = element.click();

            HtmlDivision listItem = homepage.getFirstByXPath(".//*[@id='menu-item-7']//div");
            HtmlDivision obj = listItem.getFirstByXPath(".//div[@class='row justify-content-end']");
            List<HtmlDivision> nestedDivs = obj.getByXPath(".//div[@class='subnav-col border-left']");

           // List<HtmlAnchor> title = obj.getByXPath(".//*[@id='menu-item-7']//div//div//div//div//div//div//p//a");
           // List<HtmlAnchor> subtitle = obj.getByXPath(".//*[@id='menu-item-7']//div//div//div//div//div//div//div//p//a");

            Map<String, List<String>> responseData = new HashMap<>();

            responseData.put("dropdownOptions", getDropdownText(nestedDivs));

            return responseData;
        }
    }

    public List<String> getDropdownText(List<HtmlDivision> options) {
        String[] dropdownText = new String[options.size()];

        for (int i = 0; i < options.size(); i++) {
            dropdownText[i] = options.get(i).getTextContent();
            if(dropdownText[i].contains("arrow_forward")) {
                dropdownText[i] = dropdownText[i].replace("arrow_forward", " -> ");
            }
        }
        return List.of(dropdownText);
    }
}



