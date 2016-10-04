package com.chrisaytona;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
	    Grid gridSim = new Grid(20, 20);
        gridSim.InitGrid(100, 5);

        while(true)
        {
            String input = scan.nextLine();

            if (input.equals("x"))
            {
                break;
            }

            gridSim.SimStep();
            System.out.println("Type 'x' to exit");
        }
    }
}
