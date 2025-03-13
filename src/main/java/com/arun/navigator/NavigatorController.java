package com.arun.navigator;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@ControllerAdvice
public class NavigatorController {

    final NavigationService navigationService;

    public NavigatorController(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    @GetMapping("/navigate/{direction}")
    public String navigateProbe(@PathVariable String direction) throws Exception {
        return navigationService.navigate(direction);
    }

    @GetMapping("/logs")
    public ArrayList<String> getLogs() {
        return navigationService.getLogs();
    }

    @ExceptionHandler
    public ErrorResponse handleException(Exception e) {
        if (e.getMessage().equals("Unsupported Action")) {
            return new ErrorResponse("Unsupported Action");
        }
        return new ErrorResponse("Unknown Error");
    }
    record ErrorResponse(String message) {}


}
