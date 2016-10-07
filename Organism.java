package com.chrisaytona;

public class Organism
{
    private String name;
    private boolean endTurn;

    public Organism()
    {
        this.name = "";
        this.endTurn = true;
    }

    private void move(Organism[] grid, int width)
    {

    }

    private void breed()
    {

    }

    public String GetName()
    {
        return this.name;
    }

    public void simStep(Organism[] grid, int width)
    {
        this.endTurn = true;
    }

    public void ToggleTurn()
    {
        this.endTurn = false;
    }

    public boolean GetTurn()
    {
        return this.endTurn;
    }
}
