package com.arun.navigator;

import com.arun.navigator.model.Probe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class NavigationServiceTest {

    @Mock
    private Probe probe;

    @InjectMocks
    private NavigationService navigationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testNavigateForward() throws Exception {
        when(probe.moveForward()).thenReturn("Moved (1,1) in direction NORTH");
        String result = navigationService.navigate("F");
        assertEquals("Moved (1,1) in direction NORTH", result);
    }

    @Test
    public void testNavigateBackward() throws Exception {
        when(probe.moveBackward()).thenReturn("Moved (0,0) in direction SOUTH");
        String result = navigationService.navigate("B");
        assertEquals("Moved (0,0) in direction SOUTH", result);
    }

    @Test
    public void testTurnLeft() throws Exception {
        when(probe.turnLeft()).thenReturn("Turned from direction NORTH to direction WEST");
        String result = navigationService.navigate("L");
        assertEquals("Turned from direction NORTH to direction WEST", result);
    }

    @Test
    public void testTurnRight() throws Exception {
        when(probe.turnRight()).thenReturn("Turned from direction NORTH to direction EAST");
        String result = navigationService.navigate("R");
        assertEquals("Turned from direction NORTH to direction EAST", result);
    }
}
