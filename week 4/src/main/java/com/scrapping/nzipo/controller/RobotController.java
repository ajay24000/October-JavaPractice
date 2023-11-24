package com.scrapping.nzipo.controller;

import com.scrapping.nzipo.entities.Binder;
import com.scrapping.nzipo.service.NzService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class RobotController {

    @Autowired
    private final NzService nzService;

    @RequestMapping("/complaintRobot")
    public Binder scrap() throws IOException, InterruptedException {
        return nzService.scrapping();
    }
}
