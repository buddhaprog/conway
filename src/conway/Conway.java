/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conway;

import java.util.Scanner;

/**
 *
 * @author Rob Helvey
 */
public class Conway {

    public int userStartSize;
    public int userEndSize;
    public int smallestStartSize = 1;
    public int largestEndSize = 50;

    public boolean isValidStartSize(int userStartSize) {
        return !(userStartSize < this.smallestStartSize || userStartSize > this.largestEndSize);
    }

    public boolean isValidEndSize(int userEndSize) {
        //for optional grid sizing to be done later
        return !(userEndSize < this.smallestStartSize || userEndSize > this.largestEndSize);
    }

    public boolean isValidSize(int size) {
        //for optional grid sizing to be done later
        return !(size <= 0 || size > 50);
    }

    public static void main(String[] args) {
        Conway conway = new Conway();
        boolean isValidStartSize = false;
        boolean isValidEndSize = false;
        boolean isValidSize = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Rob's version of Conway's Game of Life!");

        while (!isValidStartSize)
        {
            {
                System.out.println("Please Enter how many generations you want to see(between 0-50)");

                while (!sc.hasNextInt())
                {
                    String input = sc.next();
                    System.out.println("Sorry " + input + " is not a valid size, please try again");
                }
                conway.userStartSize = sc.nextInt();
                isValidStartSize = conway.isValidSize(conway.userStartSize);
                if (isValidStartSize)
                {
                    isValidStartSize = conway.isValidSize(conway.userStartSize);
                }
            }
            System.out.println("Number of generations choosen: " + conway.userStartSize);

        }
        String[] dish =
        {
            "...o....",
            "...oo...",
            "...o....",
            "...oo...",
            "...o....",
            "...o..o.",
        };
        int gens = conway.userStartSize + 1;
        for (int i = 0; i < gens; i++)
        {
            System.out.println("Generation " + i + ":");
            print(dish);
            dish = life(dish);
        }
    }

    public static String[] life(String[] dish) {
        String[] newGen = new String[dish.length];
        for (int row = 0; row < dish.length; row++)
        {
            newGen[row] = "";
            for (int i = 0; i < dish[row].length(); i++)
            {
                String above = "";
                String same = "";
                String below = "";
                if (i == 0)
                {
                    above = (row == 0) ? null : dish[row - 1].substring(i,
                            i + 2);
                    same = dish[row].substring(i + 1, i + 2);
                    below = (row == dish.length - 1) ? null : dish[row + 1]
                            .substring(i, i + 2);
                } else if (i == dish[row].length() - 1)
                {
                    above = (row == 0) ? null : dish[row - 1].substring(i - 1,
                            i + 1);
                    same = dish[row].substring(i - 1, i);
                    below = (row == dish.length - 1) ? null : dish[row + 1]
                            .substring(i - 1, i + 1);
                } else
                {
                    above = (row == 0) ? null : dish[row - 1].substring(i - 1,
                            i + 2);
                    same = dish[row].substring(i - 1, i)
                            + dish[row].substring(i + 1, i + 2);
                    below = (row == dish.length - 1) ? null : dish[row + 1]
                            .substring(i - 1, i + 2);
                }
                int neighbors = getNeighbors(above, same, below);
                if (neighbors < 2 || neighbors > 3)
                {
                    newGen[row] += ".";
                } else if (neighbors == 3)
                {
                    newGen[row] += "o";
                } else
                {
                    newGen[row] += dish[row].charAt(i);
                }
            }
        }
        return newGen;
    }

    public static int getNeighbors(String above, String same, String below) {
        int ans = 0;
        if (above != null)
        {
            for (char x : above.toCharArray())
            {
                if (x == 'o')
                {
                    ans++;
                }
            }
        }
        for (char x : same.toCharArray())
        {
            if (x == 'o')
            {
                ans++;
            }
        }
        if (below != null)
        {
            for (char x : below.toCharArray())
            {
                if (x == 'o')
                {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void print(String[] dish) {
        for (String s : dish)
        {
            System.out.println(s);
        }
    }
}
