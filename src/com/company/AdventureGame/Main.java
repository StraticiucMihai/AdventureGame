package com.company.AdventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
* Allow players to type full words , or phases , them to move to the correct direction based on their input
* The player should be able to type phases such as "Go West", "run South", or just "East"
* Single letter command should also be available [n s w e]
* If the destination cant be reached then the player should remain in the same location
* */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Location> location = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        /*Initialize locations*/
        location.put(0, new Location(0, "You are in front of the computer learning JAVA"));
        location.put(1, new Location(1, "You are standing at he end of the road in front of a building"));
        location.put(2, new Location(2, "You are standing at the top of a hill"));
        location.put(3, new Location(3, "You are inside of a building, a well build house for vacation"));
        location.put(4, new Location(4, "You are under the historical bridge"));
        location.put(5, new Location(5, "You are in the forest"));

        /*Add exit from all locations*/
        /*Location 1*/
        location.get(1).addExits("w", 2);
        location.get(1).addExits("e", 3);
        location.get(1).addExits("n", 5);
        location.get(1).addExits("s", 4);
        location.get(1).addExits("q", 0);
        /*Location 2*/
        location.get(2).addExits("n", 5);
        location.get(2).addExits("e", 1);
        /*Location 3*/
        location.get(3).addExits("w", 1);
        /*Location 4*/
        location.get(4).addExits("n", 1);
        location.get(4).addExits("w", 2);
        /*Location 5*/
        location.get(5).addExits("w", 2);
        location.get(5).addExits("s", 1);

        int loc = 1 ;
        while (true){
            /*Is a copy of exits from the Location class*/
            Map<String, Integer>  exits = location.get(loc).getExits();
            Map<String, String> vocabulary = new HashMap<String, String>();
            vocabulary.put("quit", "q");
            vocabulary.put("north", "n");
            vocabulary.put("south", "s");
            vocabulary.put("west", "w");
            vocabulary.put("east", "e");

            if (location.get(loc).getLocationID() == 0 ){
                System.out.println("Good Bey");
                break;
            }

            if (location.containsKey(loc)){
                System.out.println("LocationID: "+location.get(loc).getLocationID() + location.get(loc).getDescription());
            }
            else {
                System.out.println("Location "+loc+" doesn't exist in the map");
            }
            /*Print available directions*/
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()){
                System.out.print(exit +" , ");
            }
            System.out.println();
            /*Enter Direction*/
            System.out.println("Enter the direction");
            String direction = scanner.nextLine().toLowerCase();
//            for (String components : inputText){
//                System.out.println(components);
//            }
//            String direction = null; /*Default value of direction*/
//            if (inputText.length == 1){
//                direction = inputText[0].substring(0,1); /*Even if input text is split in 1 word we use inputText[0] because split method return a string of strings  */
//                /*Case when user enter a word [north , east, south or west ]  or enter the direction using a single letter [n s w e ] */
//            }
//            else if (inputText.length == 2){
//                /*enter 2 words where the second is the actual direction to follow. In this case the first word doesn't meter*/
//                 String temp =  inputText[1];
//                 direction = temp.substring(0,1);/*Splitting string and extract te first letter*/
//            }
//            System.out.println(direction);
            /*Corner case of this implementation consist in the fact that if in the string from the user there are 2 or more words used as a key in the vocabulary
            * only the first one in the split string is used EX (quit north  only quit will be taken into account)  */
            if(direction.length() >1){
                String[] words = direction.split(" ");
                for (String word: words){
                    if (vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }


            if (exits.containsKey(direction)){
                loc = exits.get(direction);
            }
            else {
                System.out.println("You can't go to that direction.");
            }

        }
    }
}
