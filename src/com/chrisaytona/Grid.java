package com.chrisaytona;
import java.util.Random;

public class Grid
{
    private int width;
    private int height;
    private int size;
    private Organism[] grid;

    public Grid(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.size = width * height;
        this.grid = new Organism[this.size];
    }

    // Init with 5 doodlebugs and 100 ants
    public void InitGrid(int antAmount, int doodleBugAmount)
    {
        int randPos;
        while(antAmount > 0)
        {
            while(true)
            {
                Random rand = new Random();
                randPos = rand.nextInt(this.size);
                if(this.grid[randPos].GetName() != "Ant" || this.grid[randPos].GetName() != "Doodlebug")
                {
                    break;
                }
            }
            this.grid[randPos] = new Ant(randPos);
        }

        while(doodleBugAmount > 0)
        {
            while(true)
            {
                Random rand = new Random();
                randPos = rand.nextInt(this.size);
                if(this.grid[randPos].GetName() == "")
                {
                    break;
                }
            }
            this.grid[randPos] = new Doodlebug(randPos);
        }
    }

    public String printGrid()
    {
        String gridString = "";

        for(int i = 0; i < this.width; i++)
        {
            for (int j = 0; j < this.height; j++)
            {
                if(grid[i].GetName() == "Doodlebug")
                {
                    gridString += "x ";
                }
                else if(grid[i].GetName() == "Ant")
                {
                    gridString += "o ";
                }
                else
                {
                    gridString += "- ";
                }
            }
            gridString += "\r\n";
        }

        return gridString;
    }

    // Prompt user to press enter to go to the next step
    public void SimStep()
    {


        printGrid();
    }


}
