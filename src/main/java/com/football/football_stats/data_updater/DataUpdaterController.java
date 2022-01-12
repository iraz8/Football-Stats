package com.football.football_stats.data_updater;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataUpdaterController {
    @GetMapping("/update/all")
    public String updateAll() {
        return "Hello world!";
    }
}
