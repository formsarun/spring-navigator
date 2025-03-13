package com.arun.navigator.model;


import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Probe {
    private int x, y;
    private Direction direction;
    private final OceanGrid grid;
    ArrayList<String> commandExecuted = new ArrayList<>();

    public Probe(int x, int y, Direction direction, OceanGrid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    private boolean isValid(int x, int y) {
        return grid.isValidPosition(x, y) && !grid.isObstaclePresent(x, y);
    }

    public String moveForward() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case NORTH:
                newY++;
                break;
            case SOUTH:
                newY--;
                break;
            case WEST:
                newX--;
                break;
            case EAST:
                newX++;
                break;
        }
        if(isValid(newX,newY)) {
          x = newX;
          y = newY;
          return logPosition(x,y, newX,newY);
        } else {
            return "Obstacle detected at (" + newX + "," + newY + ")";
        }
    }

    private String logPosition(int x, int y, int newX, int newY) {
        String command = "Moved (" + newX + "," + newY + ") in direction " + direction;
        commandExecuted.add(command);
        return command;
    }
    private String logTurns(Direction start, Direction end) {
        String command = "Turned from direction " + start + " to direction " + end;
        commandExecuted.add(command);
        return command;
    }

    public String moveBackward() {
        int newX = x;
        int newY = y;
        switch (direction) {
            case NORTH:
                newY--;
                break;
            case SOUTH:
                newY++;
                break;
            case WEST:
                newX++;
                break;
            case EAST:
                newX--;
                break;
        }
        if(isValid(newX,newY)) {
            x = newX;
            y = newY;
            return logPosition(x,y, newX,newY);
        } else {
            return "Obstacle detected at (" + newX + "," + newY + ")";
        }
    }

    public String turnLeft() {
        var temp = direction;
        direction = direction.turnLeft();
        return logTurns(temp, direction);
    }

    public String turnRight() {
        var temp = direction;
        direction = direction.turnRight();
        return logTurns(temp, direction);
    }
}
