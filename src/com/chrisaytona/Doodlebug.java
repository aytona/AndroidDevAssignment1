package com.chrisaytona;

import java.util.Random;
import java.util.ArrayList;

public class Doodlebug extends Organism
{
    private int index;
    private int currentStepLife;
    private int currentStarveLife;
    private int stepsToBreed = 8;
    private int stepsToStarve = 3;
    private String name = "Doodlebug";

    public Doodlebug() {}

    public Doodlebug(int index)
    {
        this.currentStepLife = 0;
        this.currentStarveLife = 0;
        this.index = index;
    }

    public Doodlebug(int index, int currentStepLife, int currentStarveLife)
    {
        this.index = index;
        this.currentStepLife = currentStepLife;
        this.currentStarveLife = currentStarveLife;
    }

    public String GetName()
    {
        return this.name;
    }

    private void move(Organism[] grid, int width)
    {
        ArrayList<Integer> directions = new ArrayList<Integer>(4);

        directions.add(this.index - 1);
        directions.add(this.index + 1);
        directions.add(this.index - width);
        directions.add(this.index + width);

        for(int i = 0; i < 4; i++)
        {
            if(directions.get(i) >= 0 &&
                    directions.get(i) < grid.length - 1 &&
                    grid[directions.get(i)].GetName().equals("Ant"))
            {

                grid[this.index] = new Organism();
                grid[directions.get(i)] = new Doodlebug(directions.get(i), this.currentStepLife + 1, 0);
                return;
            }
        }
        for (int i = 0; i < 4; i++)
        {
            Random rand = new Random();
            int randDir = rand.nextInt(directions.size());
            if(directions.get(randDir) < grid.length - 1 &&
                    directions.get(randDir) >= 0 &&
                    grid[directions.get(randDir)].GetName().equals(""))
            {
                grid[this.index] = new Organism();
                grid[directions.get(randDir)] = new Doodlebug(directions.get(randDir), this.currentStepLife + 1, this.currentStarveLife + 1);
                break;
            }
            directions.remove(randDir);
        }

    }

    private void breed(Organism[] grid, int width)
    {
        ArrayList<Integer> directions = new ArrayList<Integer>(4);

        directions.add(this.index - 1);
        directions.add(this.index + 1);
        directions.add(this.index - width);
        directions.add(this.index + width);

        for (int i = 0; i < 4; i++)
        {
            Random rand = new Random();
            int randDir = rand.nextInt(directions.size());
            if(directions.get(randDir) < grid.length - 1 &&
                    directions.get(randDir) >= 0)
            {
                grid[directions.get(randDir)] = new Doodlebug(directions.get(randDir));
                this.currentStepLife = 0;
                break;
            }
            directions.remove(randDir);
        }
    }

    private void starve(Organism[] grid)
    {
        grid[this.index] = new Organism();
    }

    public void simStep(Organism[] grid, int width)
    {
        this.move(grid, width);
        if (this.currentStepLife == this.stepsToBreed)
        {
            this.breed(grid, width);
        }
        if (this.currentStarveLife == this.stepsToStarve)
        {
            this.starve(grid);
        }
    }
}
