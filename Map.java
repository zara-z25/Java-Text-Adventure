package org.uob.a1;

public class Map{


    private int width;
    private int height; 
    private char[][] map;
    private String mapString = "";
    final private char EMPTY = '.';

    
    public Map(int width, int height){
        this.width = width;
        this.height = height;
        map = new char[height][width];
        for (int i =0; i<height; i++){
            for (int j = 0; j<width; j++){
                map[i][j] = EMPTY;
            }
        }
    }//constructor

    public void placeRoom(Position position, char symbol){
        int x = position.getX();
        int y = position.getY();
        map[x][y] = symbol;
    }//placeRoom

    public char getRoom(int x, int y){
        return map[x][y];
    }//getRoom


    public String display(){
        for (int i =0; i<height; i++){
            for (int j = 0; j<width; j++){
                mapString += map[i][j];
            }
             mapString += "\n";
        }
        return mapString;
    }//display



}