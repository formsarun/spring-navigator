package com.arun.navigator.model;


public final class OceanGrid {
    private int width = 5;
    private int height = 5;
    private int[][] obstacles = {
        { 0 ,0 ,0 ,0 ,0 },
        { 0 ,0 ,1 ,0 ,0 },
        { 0 ,0 ,1 ,0 ,0 },
        { 0 ,0 ,0 ,1 ,1 },
        { 0 ,0 ,0 ,0 ,0 }
    };

    OceanGrid() {

    }

//    public OceanGrid(int width, int height, int[][] obstacles) {
//        this.width = width;
//        this.height = height;
//        this.obstacles = obstacles;
//    }


    public boolean isObstaclePresent(int x, int y) {
         return obstacles[x][y] == 1;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= width && y >= height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getObstacles() {
        return obstacles;
    }
}
