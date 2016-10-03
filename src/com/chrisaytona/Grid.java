package com.chrisaytona;

/**
 * Created by Christopher on 2016-10-02.
 */
public class Grid
{
    private int width;
    private int height;
    private int size;
    private int[] grid;
    private int[] foreignGrid;

    public Grid(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.size = width * height;
        this.grid = new int[this.size];
        this.foreignGrid = new int[this.size];      // Get this from a different class
    }

    public void InitGrid()
    {
        for(int i = 0; i < this.size; i++)
        {
            this.grid[i] = 0;
        }
    }

    public String printGrid()
    {
        String gridString = "";

        for(int i = 0; i < this.width; i++)
        {
            for (int j = 0; j < this.height; j++)
            {
                if(grid[i] == 2)
                {
                    gridString += "x ";
                }
                else if(grid[i] == 1)
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

    public void SimStep()
    {

    }

   private int[] UpdateGrid(int[] prevGrid)
   {
       int[] updatedGrid = new int[this.size];


       return updatedGrid;
   }
}
