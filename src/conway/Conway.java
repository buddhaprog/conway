/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conway;

import java.util.Scanner;

/**
 *
 * @author LabUser1
 */
public class Conway {

    /**
     * @param args the command line arguments
     */
    public int userStartSize;
    public int userEndSize;
    public int smallestStartSize = 1;
    public int largestEndSize = 50;

    public boolean isValidStartSize(int userStartSize) {
//        System.out.println("valid start size check");
        return !(userStartSize < this.smallestStartSize || userEndSize >= this.largestEndSize);
    }

    public boolean isValidEndSize(int userEndSize) {
//        System.out.println("valid end size check");
        return !(userEndSize <= this.smallestStartSize || userEndSize > this.largestEndSize);
    }

    public boolean isValidSize(int size) {
        //making sure size entered is within valid range
        //System.out.println("size check");
        return !(size <= 0 || size > 50);
    }

    public static void main(String[] args) {
        Conway conway = new Conway();
        boolean isValidStartSize = false;
        boolean isValidEndSize = false;
        boolean isValidSize = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Rob's version of Conway's Game of Life!");

        while (!isValidStartSize) {
            {
                System.out.println("Please Enter how many generations you want to see(between 0-50)");

                while (!sc.hasNextInt()) {
                    String input = sc.next();
                    System.out.println("Sorry " + input + " is not a valid size, please try again");
                }
                conway.userStartSize = sc.nextInt();
                System.out.println(conway.userStartSize);
                isValidStartSize = conway.isValidSize(conway.userStartSize);
                //System.out.println("got here");
                if (isValidStartSize) {

                    isValidStartSize = conway.isValidSize(conway.userStartSize);
                    //System.out.println(baby.userStartInput);
                }
            }
            System.out.println("Your the number of generations you have choosen are" + conway.userStartSize);

        }
        String[] dish = {
            "_#_",
            "_#_",
            "_#_",};
        int gens = conway.userStartSize+1;
        for (int i = 0; i < gens; i++) {
            System.out.println("Generation " + i + ":");
            print(dish);
            dish = life(dish);
        }
    }

    public static String[] life(String[] dish) {
        String[] newGen = new String[dish.length];
        for (int row = 0; row < dish.length; row++) {//each row
            newGen[row] = "";
            for (int i = 0; i < dish[row].length(); i++) {//each char in the row
                String above = "";//neighbors above
                String same = "";//neighbors in the same row
                String below = "";//neighbors below
                if (i == 0) {//all the way on the left
                    //no one above if on the top row
                    //otherwise grab the neighbors from above
                    above = (row == 0) ? null : dish[row - 1].substring(i,
                            i + 2);
                    same = dish[row].substring(i + 1, i + 2);
					//no one below if on the bottom row
                    //otherwise grab the neighbors from below
                    below = (row == dish.length - 1) ? null : dish[row + 1]
                            .substring(i, i + 2);
                } else if (i == dish[row].length() - 1) {//right
                    //no one above if on the top row
                    //otherwise grab the neighbors from above
                    above = (row == 0) ? null : dish[row - 1].substring(i - 1,
                            i + 1);
                    same = dish[row].substring(i - 1, i);
					//no one below if on the bottom row
                    //otherwise grab the neighbors from below
                    below = (row == dish.length - 1) ? null : dish[row + 1]
                            .substring(i - 1, i + 1);
                } else {//anywhere else
                    //no one above if on the top row
                    //otherwise grab the neighbors from above
                    above = (row == 0) ? null : dish[row - 1].substring(i - 1,
                            i + 2);
                    same = dish[row].substring(i - 1, i)
                            + dish[row].substring(i + 1, i + 2);
					//no one below if on the bottom row
                    //otherwise grab the neighbors from below
                    below = (row == dish.length - 1) ? null : dish[row + 1]
                            .substring(i - 1, i + 2);
                }
                int neighbors = getNeighbors(above, same, below);
                if (neighbors < 2 || neighbors > 3) {
                    newGen[row] += "_";//<2 or >3 neighbors -> die
                } else if (neighbors == 3) {
                    newGen[row] += "#";//3 neighbors -> spawn/live
                } else {
                    newGen[row] += dish[row].charAt(i);//2 neighbors -> stay
                }
            }
        }
        return newGen;
    }

    public static int getNeighbors(String above, String same, String below) {
        int ans = 0;
        if (above != null) {//no one above
            for (char x : above.toCharArray()) {//each neighbor from above
                if (x == '#') {
                    ans++;//count it if someone is here
                }
            }
        }
        for (char x : same.toCharArray()) {//two on either side
            if (x == '#') {
                ans++;//count it if someone is here
            }
        }
        if (below != null) {//no one below
            for (char x : below.toCharArray()) {//each neighbor below
                if (x == '#') {
                    ans++;//count it if someone is here
                }
            }
        }
        return ans;
    }

    public static void print(String[] dish) {
        for (String s : dish) {
            System.out.println(s);
        }
    }
}
