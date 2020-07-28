package com.company.AdventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Location> location = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        location.put(0, new Location(0, "You are in front of the computer learning JAVA"));
        location.put(1, new Location(1, "You are standing at he end of the road in front of a building"));
        location.put(2, new Location(2, "You are standing at the top of a hill"));
        location.put(3, new Location(3, "You are inside of a building, a well build house for vacation"));
        location.put(4, new Location(4, "You are under the historical bridge"));
        location.put(5, new Location(5, "You are in the forest"));

        int loc = 1 ;
        while (true){

            if (location.containsKey(loc)){
                System.out.println(location.get(loc).getDescription());
            }
            else {
                System.out.println("Location "+loc+" doesn't exist in the map");
            }
            if (loc == 99 ){
                break;
            }
            System.out.println("Enter the new location");
            loc = scanner.nextInt();
        }
    }
}
