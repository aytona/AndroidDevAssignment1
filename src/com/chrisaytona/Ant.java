package com.chrisaytona;

// One ant
public class Ant extends Organism
{
    private int xPos;
    private int yPos;
    private int currentStepLife;
    private int stepsToBreed = 3;
    private String name = "Ant";

    public Ant() {}

    public Ant(int xPos,int yPos)
    {
        this.currentStepLife = 0;
    }

    public Ant(int index)
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
    }

    public void breed()
    {

    }
}
