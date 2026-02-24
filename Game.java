package org.uob.a1;

import java.util.Scanner; 

public class Game {  

public static final String reset = "\u001B[0m";
public static final String red = "\u001B[31m";
public static final String green = "\u001B[32m";
public static final String yellow = "\u001B[33m";
public static final String blue = "\u001B[34m";
public static final String purple = "\u001B[35m";
public static final String cyan = "\u001B[36m";
public static final String white = "\u001B[37m";
public static final String bold = "\033[0;1m";
    
static Map map = new Map(6,6);
static Map mapToShow = new Map(6,6);
public static Position player = new Position(3,3);
public static Scanner inputDevice = new Scanner(System.in);
public static Inventory inventory = new Inventory();
public static Score score = new Score(100);

    static  Room garden = new Room("Garden", "You are in a sunlit garden.\nHuge flowers tower above soft turf.\nThe air is warm and still.\nTo the south, a narrow passage.\nTo the north, trees and a white Sphinx.\nTo the west, tall buildings.", 'G', new Position(3,3));
  static  Room narrowPassageWay = new Room("Narrow Passage Way", "A dim, narrow passageway.\nWalls close and overgrown.\nShadows flicker on the floor.\nTo the south, the lawn opens.", 'N', new Position(4,3));
  static  Room lawn = new Room("Lawn", "A smooth, green lawn stretches around.\nThe rustle of leaves is the only sound.\nTo the west stands a grand hall.\nYou can rest here.",'L', new Position(5,3));
  static  Room hall = new Room("Hall", "A vast hall with high ceilings.\nStone tables hold colorful fruits.\nCushions are scattered on the floor.\nA peaceful place to rest.",'H', new Position(5,2)); 
  static  Room building1 = new Room("Building", "A tall, imposing building.\nWindows glimmer faintly.\nYou cannot enter.\nStones are scattered nearby.", 'B', new Position(3,2));
  static  Room building2 = new Room("Building", "Another tall building.\nWalls rise high and forbidding.\nEntry is impossible.\nSome stones lie nearby.", 'B', new Position(3,1));
  static  Room square = new Room("Square","A shaded grove with swaying trees.\nSome bear fruits.\nAt the center stands a white Sphinx.", 'S',new Position(2,3));
  static  Room bronzeRoom = new Room("Bronze Room","A dim bronze chamber.\nMorlocks lurk in shadow.\nOnly a weapon can protect you.\nThe Time Machine is here.", 'X', new Position(1,4));
  static  Room forest1 = new Room("Forest", "A dense, shadowy forest.\nTwigs and dry wood litter the floor.\nTo the east lies the Bronze Room.", 'F',new Position(1,3));
  static  Room forest2 = new Room("Forest", "The forest thickens overhead.\nDry wood covers the ground.\nTo the north is the museum.", 'F',new Position(1,2));
   static Room museum = new Room("Museum", "A quiet, dusty museum.\nBroken displays hide relics.\nYou can find:\n- a small matchbox\n- a tin of camphor\n- a pouch of sulphur\n- a bow\n- a heavy iron bar\n- arrows", 'M', new Position(0,2));
  static  Room hillTop = new Room("Hill","You stand atop a steep hill.\nWind tugs at your clothes.\nThe slope is too steep to descend.\nYou can look over the landscape.", '^', new Position(1,1));


     //item objects
     
     static    Item tree = new Item("Tree","A towering, ancient tree with thick bark and sprawling branches that invite both awe and curiosity.", "You scramble up the tree, branches creaking under your weight.", 10);
    static Item stone = new Item("Stone", "Small, smooth stones scattered across the ground near the buildings. Some are heavy enough to be thrown.", "You throw the stone! It misses the goal.", 5);
       static   Item matchbox = new Item("Matchbox", "A small, worn matchbox containing a few matches.", "A quick strike and the match flares, startling nearby Morlocks.", 10);
      static    Item camphorTin =new Item("Camphor Tin", "A small tin filled with fragrant white camphor. It has a strong, sharp smell.", "You burn some camphor, and a cloud of smoke sends the Morlocks scattering.", 5);
        static  Item sulphurPouch = new Item("Sulphur Pouch", "A small leather pouch filled with yellow sulphur powder. It smells faintly of brimstone.", "Mixing with other materials to create fire.", 5);
    static Item ironBar = new Item("Iron Bar", "A cold, heavy bar of rusted iron", "You wedge it against the bronze door; it creaks open.", 10);
    static Item fruits = new Item("Fruits", "A vibrant assortment of fruits laid on stone tables, glistening in the light.", "You eat some fruits; energy surges through you.", 10);
    static Item timeMachine = new Item("Time Machine", "A complex, bronze contraption with gleaming levers and dials, partly covered in dust.", "You activate it — the world blurs and you’re back in your own time. You have won the game!" , 100);
    static Item bow = new Item("Bow", "A handmade wooden bow, simple but well-crafted. The wood bends smoothly and the string hums faintly when drawn.", "You notch a stone and release it, sending it flying toward the Morlocks.", 50);
    static Item arrows = new Item("Arrows","A bundle of sharp, wooden arrows with feathered fletching. They’re perfectly balanced for your bow.","You fire an arrow; it hits the Morlock dead-on!", 20);
     
     
static{
     
     map.placeRoom(new Position(0,2), 'M');
     map.placeRoom(new Position(1,1), '^');
     map.placeRoom(new Position(1,2), '1');
     map.placeRoom(new Position(1,3), '1');
     map.placeRoom(new Position(1,4), 'X');
     map.placeRoom(new Position(2,3), 'S');
     map.placeRoom(new Position(3,1), 'B');
     map.placeRoom(new Position(3,2), 'B');
     map.placeRoom(new Position(5,2), 'H');
     map.placeRoom(new Position(5,3), 'L');
     map.placeRoom(new Position(4,3), 'N');
     map.placeRoom(new Position(3,3), 'G');

}


public static void askDirection(){
        String question2 = "Which direction would you like to go?";
        System.out.println(question2);
        String direction = inputDevice.nextLine();
        direction = direction.toLowerCase();
        if (direction.equals("north"))
        goNorth( player);
        else if (direction.equals("south"))
        goSouth( player);
        else if (direction.equals("east"))
        goEast( player);
        else if (direction.equals("west"))
        goWest( player);
        else
        System.out.println("invalid direction.");
    }

public static void goNorth(Position object){
    int x = object.getX();
    if (x>=0 && x <4){
    x -= 1;
    object.setX(x);
    setMap(player);
    System.out.println("You have moved towards North.");}
    else
    System.out.println("You cannot move in that direction.");
    
}
public static void goSouth(Position object){
    int x = object.getX();
    if (x>=0 && x <4){
    x += 1;
    object.setX(x);
    setMap(player);
    System.out.println("You have moved towards South.");
    }
    else
    System.out.println("You cannot move in that direction.");
    
}

public static void goEast (Position object){
    int y = object.getY();
    if (y>=0 && y <4){
    y += 1;
    object.setY(y);
    setMap(player);
    System.out.println("You have moved towards East.");}
    else
    System.out.println("You cannot move in that direction.");

}
public static void goWest(Position object){
    int y = object.getY();
    if (y>=0 && y <4){
    y -= 1;
    object.setY(y);
    setMap(player);
    System.out.println("You have moved towards West.");}
    else
    System.out.println("You cannot move in that direction.");
}
    public static String displayCommands(){
        String string = "go – Move north, south, east, or west.\nlook – Look around your current location.\ninventory – Check what you are carrying.\ntake <item> –Pick up an item in the room.\ndrop <item> – Drop an item from your inventory.\nuse <item> – Use an item you are holding.\nmap – View the areas you’ve discovered.\nhelp – Display this list of commands again.\npuzzle – Display this list of puzzles to solve to win the game.\nquit – Exit the game.";
        return string;
    }

    public static String puzzles(){
        String string = "Objective: Recover the time machine.\n\nSurvival tips: If you see morlocks, kill them.\nEat food to stay alive.\nCollect useful materials to craft weapons or light matches — morlocks fear fire.";
        return string;
    }

    public static String use(){
        String string = "What do you want to use?";
        System.out.println(string);
        inventory.displayInventory();
        String thing = inputDevice.nextLine().toLowerCase();
        if (inventory.hasItem(thing)>-1){
            if (thing.equals( tree.getName().toLowerCase())){
            inventory.removeItem("tree");
            return tree.getUse();
        }
        else if (thing.equals( stone.getName().toLowerCase())){
            inventory.removeItem("stone");
            return stone.getUse();
        }
        else if (thing.equals( matchbox.getName().toLowerCase())){
            inventory.removeItem("matchbox");
            return matchbox.getUse();
        }else if (thing.equals(camphorTin.getName().toLowerCase())){
            inventory.removeItem("camphorTin");
            return camphorTin.getUse();
        }else if (thing.equals( sulphurPouch.getName().toLowerCase())){
            inventory.removeItem("sulphurPouch");
            return sulphurPouch.getUse();
        }
        else if (thing.equals( ironBar.getName().toLowerCase())){
            inventory.removeItem("ironBar");
            return ironBar.getUse();
        }
        else if (thing.equals( fruits.getName().toLowerCase())){
            inventory.removeItem("fruits");
            return fruits.getUse();
        }
        else if (thing.equals( timeMachine.getName().toLowerCase())){
            inventory.removeItem("timeMachine");
            
            return timeMachine.getUse().toLowerCase();
            
        }
        else if (thing.equals( bow.getName().toLowerCase())){
            System.out.println("What do you want to use it with?");
        inventory.displayInventory();
        String useItWith = inputDevice.nextLine();
            useItWith =useItWith.toLowerCase();
            System.out.println("Do you want to kill the morlocks with it?");
        inventory.displayInventory();
        String input2 = inputDevice.nextLine();
            input2 =input2.toLowerCase();
            if (useItWith.equals("yes")){
                return arrows.getUse();
            }
            else 
                return arrows.getUse();
        }
        else{
        return "";
    }}
        else {
           return "The item is not in your inventory!";
        }
        // System.out.println(item.getUse());
        // inventory.removeItem(item);
    }
    public static String lookObject(){
        String string = "What do you want to know more about?";
        System.out.println(string);
        inventory.displayInventory();
        String thing = inputDevice.nextLine();
        thing.toLowerCase();
        if (thing.equals( tree.getName())){
        return tree.getDescription();
    }
    else if (thing.equals(stone.getName())){
        return stone.getDescription();
    }
    else if (thing.equals( matchbox.getName())){
        return matchbox.getDescription();
    }else if (thing.equals( camphorTin.getName())){
        return camphorTin.getDescription();
    }else if (thing.equals( sulphurPouch.getName())){
        return sulphurPouch.getDescription();
    }
    else if (thing.equals(ironBar.getName())){
        return ironBar.getDescription();
    }
    else if (thing.equals( fruits.getName())){
        return fruits.getDescription();
    }
    else if (thing.equals(timeMachine.getName())){
        return timeMachine.getDescription();
    }
    else if (thing.equals( bow.getName())){
        return bow.getDescription();
    }
        else if (thing.equals( arrows.getName())){
        return arrows.getDescription();
    }
    else{
    return "";
}
}
public static void setMap(Position object)
{
    int x = object.getX();
    int y = object.getY();
    // if (x == 0 && y == 0)
    {
        mapToShow.placeRoom(object, map.getRoom(x, y));
    }
}
public static String look(char symbol){
    if (symbol == garden.getSymbol()){
        return garden.getDescription();
    }
    else if (symbol == narrowPassageWay.getSymbol()){
        return narrowPassageWay.getDescription();
    }
    else if (symbol == lawn.getSymbol()){
        return lawn.getDescription();
    }
      else if (symbol == hall.getSymbol()){
        return hall.getDescription();
    }
      else if (symbol == building1.getSymbol()){
        return building1.getDescription();
    }
      else if (symbol == building2.getSymbol()){
        return building2.getDescription();
    }
      else if (symbol == square.getSymbol()){
        return square.getDescription();
    }
      else if (symbol == bronzeRoom.getSymbol()){
        return bronzeRoom.getDescription();
    }
      else if (symbol == forest1.getSymbol()){
        return forest1.getDescription();
    }
      else if (symbol == forest2.getSymbol()){
        return forest2.getDescription();
    }
      else if (symbol == museum.getSymbol()){
        return museum.getDescription();
    }
    else if (symbol == hillTop.getSymbol()){
        return hillTop.getDescription();
    }
    else {
       return "The area seems unexplorable!";
    }
    
}

 public static void main(String[] args) {
     // GameMain game = new GameMain();


     //room object
     
  
    String question = "What would you like to do?";
     

System.out.println(cyan + "You blink awake beneath a sky the color of new magic..." + reset);
inputDevice.nextLine();

System.out.println(yellow + "The year is 802,701 A.D." + reset +
    " You're standing in a garden that seems unbelievable:\n" +
    green + "Plants of unusual shapes" + reset + " grow beside crystal-like trees\n" +
    "and flowers hum quietly...\n\n");
inputDevice.nextLine();

System.out.println(red + "…But something is missing.\n\n" + reset +
    "Your" + bold + " Time Machine " + reset + "has vanished!\n" +
    "The Morlocks have taken it away.\n\n");
inputDevice.nextLine();

System.out.println("If you want to survive this strange future, you must explore the garden,\n" +
    "uncover its secrets, and reclaim what was taken.\n\n" +
    blue + "Your adventure begins now." + reset);
     

     // printing a small illustration:
     
  System.out.println(
    cyan +
    "      (\")                       _______________________ \n" +
    "      /|\\                     |  TIME MACHINE 3000(?)  |  \n" +
    "      / \\                     |________________________|  \n" +
    reset + yellow +
    "     The Traveller                  ||     ||           \n" +
    reset + cyan +
    "                                     ||_____||          \n" +
    "                                 ___/         \\___      \n" +
    green +
    "                                /                \\      \n" +
    "                               /                   \\    \n\n" + reset
);

     setMap(player);
    while (true){
        System.out.println(question);
        String userInput = inputDevice.nextLine().toLowerCase();
        
    if (userInput.equals("go")){
        score.visitRoom();
        askDirection(); 
    }
    else if (userInput.equals("look")){
        String striing = "Do you want to look at current location or the item?";
        System.out.println(striing);
        String lookAt = inputDevice.nextLine();
        lookAt.toLowerCase();
        if (lookAt.equals("location")){
         char currentLocation = map.getRoom(player.x,player.y);
        System.out.println("This is the " + look(currentLocation));   
        }
        else if (lookAt.equals("item")){
            System.out.println(lookObject());
        }
        else{
            System.out.println("Invalid command");
            continue;
        }
    }
    else if (userInput.equals("take")){
        System.out.println("What do you want to take?");
        String item = inputDevice.nextLine();
           item =  item.toLowerCase();
        inventory.addItem(item);
        score.solvePuzzle();       

}

    else if (userInput.equals("drop")){
        System.out.println("What do you want to drop?");
        inventory.displayInventory();
        String item = inputDevice.nextLine().toLowerCase();
        inventory.removeItem(item);
    }
    else if(userInput.equals("climb")){
        System.out.println("Climbing the tree. The view is breathtaking and you get 10 points. There are some fruits hanging");
        score.solvePuzzle();
    }
    else if(userInput.equals("help")){
        displayCommands();
    }
    else if(userInput.equals("puzzles")){
        displayCommands();
    }
    else if(userInput.equals("down")){
        System.out.println("You have climbed down!");
    }
    else if (userInput.equals("map")){
    System.out.println(mapToShow.display());
    }
    else if (userInput.equals("mapfull")){
    System.out.println(map.display());
    }
    else if (userInput.equals("use")){
    System.out.println(use());
    }
    else if(userInput.equals("kill")){
        System.out.println("You strike with a loud, ringing blow — the sound echoes through the chamber. The Morlock reels, injured and stunned, but it does not fall; it snarls and advances.\n" + //
                        "Do you want to:\n" + //
                        "Attack again?\n" + //
                        "Escape?");
                        String choice = inputDevice.nextLine().toLowerCase();
                        if (choice.equals("attack")){
                            System.out.println("You strike again. The Morlock falls, dead.\nYou have earned 10 points!");
                            score.solvePuzzle();
                        }
                        else
                        System.out.println("You decide to run. The Morlock lunges, but you break away");
                    }
    else if (userInput.equals("quit")){
         System.out.println("Game over\nYour score is: " + score.getScore()); 
         break;

    }
    else if (userInput.equals("score")){
        System.out.println("Your score is: " + score.getScore()); 
 }
    else if (userInput.equals("inventory")){
    System.out.println(inventory.displayInventory());    
}
        else{
            System.out.println("Invalid Command");
            continue;
        }
}
 }
  
}