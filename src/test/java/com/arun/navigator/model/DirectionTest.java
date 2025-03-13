package com.arun.navigator.model;

import org.junit.jupiter.api.Test;

public class DirectionTest {

    @Test
    public void testTurnLeft() {
        Direction direction = Direction.NORTH;
        assert direction.turnLeft() == Direction.WEST;
        direction = Direction.WEST;
        assert direction.turnLeft() == Direction.SOUTH;
        direction = Direction.SOUTH;
        assert direction.turnLeft() == Direction.EAST;
        direction = Direction.EAST;
        assert direction.turnLeft() == Direction.NORTH;
    }

    @Test
    public void testTurnRight() {
        Direction direction = Direction.NORTH;
        assert direction.turnRight() == Direction.EAST;
    }
}
