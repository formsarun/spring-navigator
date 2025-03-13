package com.arun.navigator.model;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction turnLeft() {
        return values()[((ordinal() +3) % 4)];
    }

    public Direction turnRight() {
        return values()[((ordinal() +1) % 4)];
    }
}
