package org.uob.a1;

public class Position {
    public int x;
    public int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }//position constructor

    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }
}