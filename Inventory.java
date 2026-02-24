package org.uob.a1;

public class Inventory {
        final int MAX_ITEMS = 10;
    private int current_items=0;
    private int index;
    private String[] inventory;

    public Inventory (){
        inventory = new String[MAX_ITEMS];
    }

    public void addItem(String item){
        if (current_items<MAX_ITEMS){
        inventory[current_items] = item;
        current_items += 1;
        // System.out.println(item +" Taken!");
        }
        else
        {
            System.out.println("You cannot take the item. Inventory is full. Drop something to take this item.");
        }
    }//add item
    
    public int hasItem(String itemName){
        for (int i= 0; i<MAX_ITEMS; i++){
            if(inventory[i] != null){
                if (inventory[i].equals(itemName) )
                    return i;}
            
        }
        return -1;
    }//has item

    public void removeItem(String itemName){
        for (int i= 0; i<MAX_ITEMS; i++){
            if(inventory[i] != null){
                if (inventory[i].equals(itemName) ){
                    inventory[i] = null;
                    // System.out.println(itemName + " has been dropped.");
                    break;
                }
                // else{
                    // System.out.println(itemName + " not found.");}
            }// external if
            }
    }

    public String displayInventory(){
        String inventoryString = "";
        for (int i = 0; i < MAX_ITEMS; i++){
            if (inventory[i]==null)
                continue;
            else{
                inventoryString += inventory[i];
                inventoryString += " ";}
            
        }
        return inventoryString;
    }
    
}