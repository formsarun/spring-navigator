package com.arun.navigator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public final class OceanGrid {
    private final int width = 5;
    private final int height = 5;
    private final int[][] obstacles = {
        { 0 ,0 ,0 ,0 ,0 },
        { 0 ,0 ,1 ,0 ,0 },
        { 0 ,0 ,1 ,0 ,0 },
        { 0 ,0 ,0 ,1 ,1 },
        { 0 ,0 ,0 ,0 ,0 }
    };


    public boolean isObstaclePresent(int x, int y) {
         return obstacles[x][y] == 1;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width &&  y >= 0 && y < height;
    }

}
