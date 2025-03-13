package com.arun.navigator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OceanGridTest {

    OceanGrid subject;
    @BeforeEach
    void setUp() {

        int[][] obstacles = {
                { 0 ,0 ,0 ,0 ,0 },
                { 0 ,0 ,1 ,0 ,0 },
                { 0 ,0 ,1 ,0 ,0 },
                { 0 ,0 ,0 ,1 ,1 },
                { 0 ,0 ,0 ,0 ,0 }
        };
        subject = new OceanGrid();
    }
//
//    @Test
//    public void checkIfPositionIsObstacle() {
//        assertTrue(subject.isObstaclePresent(2, 2));
//        assertTrue(subject.isObstaclePresent(4, 3));
//        assertFalse(subject.isObstaclePresent(1, 1));
//    }
}