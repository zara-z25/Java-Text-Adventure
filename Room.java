package org.uob.a1;

public class Room {
    private String name;
    private String description;
    private char symbol;
    private Position position;

    public Room(String name, String description, char symbol, Position position){
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
    }//constructor

    public String getName(){
        return name;
    }//getname
    
    public String getDescription(){
        return description;
    }//getdescription

    public char getSymbol(){
        return symbol;
    }//getsymbol

    public Position getPosition(){
        return position;
    }//getposition

    public String toString(){
        return name +"\n"+ description;
    }
}