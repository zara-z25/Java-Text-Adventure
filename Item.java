package org.uob.a1;
public class Item {
    
    private String name;
    private String description;
    private String use;
    private int value;

    public Item(String name, String description, String use, int value) {

        this.name = name;
        this.description = description;
        this.use = use;
        this.value = value;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }
    public String getUse() {
        return use;
    }
    
    public int getValue() {
        return value;
    }

    
}