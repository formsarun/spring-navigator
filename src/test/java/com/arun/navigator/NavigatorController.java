package com.arun.navigator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NavigatorController {

    @GetMapping("/navigate/{direction}")
    public String navigateProbe(@PathVariable String direction) {
        return "";
    }
}
