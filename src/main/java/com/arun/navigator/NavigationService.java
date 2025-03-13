package com.arun.navigator;

import com.arun.navigator.model.Probe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class NavigationService {

    private final Probe probe;
    public NavigationService(Probe probe) {
        this.probe = probe;
    }

    public String navigate(String command) throws Exception {
        return switch (command) {
            case "F" -> probe.moveForward();
            case "B" -> probe.moveBackward();
            case "L" -> probe.turnLeft();
            case "R" -> probe.turnRight();
            default -> throw new Exception("Unsupported Action");
        };
    }

    public ArrayList<String> getLogs() {
        return probe.getCommandExecuted();
    }
}
