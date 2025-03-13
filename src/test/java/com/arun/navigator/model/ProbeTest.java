package com.arun.navigator.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeTest {

    private OceanGrid grid;
    private Probe probe;

    @BeforeEach
    public void setUp() {
        grid = new OceanGrid();
        probe = new Probe(0, 0, Direction.NORTH, grid);
    }

    @Test
    void testProbeInitialization() {
        assertEquals(0, probe.getX());
        assertEquals(0, probe.getY());
        assertEquals(Direction.NORTH, probe.getDirection());
    }

    @Test
    void testMoveForward() {
        String result = probe.moveForward();
        assertEquals("Moved (0,1) in direction NORTH", result);
        assertEquals(0, probe.getX());
        assertEquals(1, probe.getY());
    }

    @Test
    void testMoveBackward() {
        probe.moveForward(); // Move to (0,1)
        String result = probe.moveBackward();
        assertEquals("Moved (0,0) in direction NORTH", result);
        assertEquals(0, probe.getX());
        assertEquals(0, probe.getY());
    }

    @Test
    void testTurnLeft() {
        String result = probe.turnLeft();
        assertEquals("Turned from direction NORTH to direction WEST", result);
        assertEquals(Direction.WEST, probe.getDirection());
    }

    @Test
    void testTurnRight() {
        String result = probe.turnRight();
        assertEquals("Turned from direction NORTH to direction EAST", result);
        assertEquals(Direction.EAST, probe.getDirection());
    }

    @Test
    void testObstacleDetection() {
        probe = new Probe(1, 1, Direction.NORTH, grid); // Position (1,1) has an obstacle at (1,2)
        String result = probe.moveForward();
        assertEquals("Obstacle detected at (1,2)", result);
        assertEquals(1, probe.getX());
        assertEquals(1, probe.getY());
    }

    @Test
    void testBoundaryConditions() {
        probe = new Probe(0, 0, Direction.SOUTH, grid); // Moving south from (0,0) is out of bounds
        String result = probe.moveForward();
        assertEquals("Obstacle detected at (0,-1)", result);
        assertEquals(0, probe.getX());
        assertEquals(0, probe.getY());
    }
}