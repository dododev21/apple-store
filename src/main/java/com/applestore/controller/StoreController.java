package com.applestore.controller;

import com.applestore.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        storeService.populateMainPage(model);
        return "index";
    }

    @GetMapping("/mac")
    public String mac(Model model) {
        storeService.populateSubPage(model, "mac");
        return "mac";
    }

    @GetMapping("/ipad")
    public String ipad(Model model) {
        storeService.populateSubPage(model, "ipad");
        return "ipad";
    }

    @GetMapping("/iphone")
    public String iphone(Model model) {
        storeService.populateSubPage(model, "iphone");
        return "iphone";
    }

    @GetMapping("/watch")
    public String watch(Model model) {
        storeService.populateSubPage(model, "watch");
        return "watch";
    }

    @GetMapping("/airpods")
    public String airpods(Model model) {
        storeService.populateSubPage(model, "airpods");
        return "airpods";
    }
}
