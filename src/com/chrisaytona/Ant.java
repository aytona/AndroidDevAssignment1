package com.chrisaytona;

import java.util.Random;
import java.util.ArrayList;

public class Ant extends Organism
{
    private int index;
    private int currentStepLife;
    private int stepsToBreed = 3;
    private String name = "Ant";

    public Ant() {}

    public Ant(int index)
    {
        this.currentStepLife = 0;
        this.index = index;
    }

    public Ant(int index, int currentStepLife)
    {
        this.currentStepLife = currentStepLife;
        this.index = index;
    }

    private void move(Organism[] grid, int width)
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
                    directions.get(randDir) >= 0 &&
                    grid[directions.get(randDir)].GetName().equals(""))
            {

                grid[this.index] = new Organism();
                grid[directions.get(randDir)] = new Ant(directions.get(randDir), this.currentStepLife + 1);
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
                    directions.get(randDir) >= 0 &&
                    grid[directions.get(randDir)].GetName().equals(""))
            {
                grid[directions.get(randDir)] = new Ant(directions.get(randDir));
                this.currentStepLife = 0;
                return;
            }
            directions.remove(randDir);
        }
    }

    public String GetName()
    {
        return this.name;
    }

    public void simStep(Organism[] grid, int width)
    {
        this.move(grid,width);
        if (this.currentStepLife == this.stepsToBreed)
        {
            this.breed(grid, width);
        }
    }
}