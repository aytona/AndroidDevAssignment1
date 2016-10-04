package com.chrisaytona;

// One doodlebug
public class Doodlebug extends Organism
{
    private int xPos;
    private int yPos;
    private int currentStepLife;
    private int stepsToBreed = 8;
    private int stepsToStarve = 3;
    private String name = "Doodlebug";

    public Doodlebug() {}

    public Doodlebug(int xPos, int yPos)
    {
        this.currentStepLife = 0;
    }

    public Doodlebug(int index)
    {
        this.currentStepLife = 0;
    }

    public int GetXPos()
    {
        return this.xPos;
    }

    public int GetYPos()
    {
        return this.yPos;
    }

    public String GetName()
    {
        return this.name;
    }

    public void move()
    {
        currentStepLife++;
        if(currentStepLife >= this.stepsToBreed)
            breed();
        if(currentStepLife >= this.stepsToStarve)
            starve();
    }

    public void breed()
    {

    }

    public void starve()
    {

    }
}
