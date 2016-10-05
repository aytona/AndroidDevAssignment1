import java.util.Random;
import java.util.ArrayList;

public class Ant extends Organism
{
    private int index;
    private int currentStepLife;
    private int stepsToBreed = 3;
    private String name = "Ant";
    private boolean endTurn;

    public Ant(int index)
    {
        this.currentStepLife = 0;
        this.index = index;
        this.endTurn = true;
    }

    public Ant(int index, int currentStepLife)
    {
        this.currentStepLife = currentStepLife;
        this.index = index;
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

    private void move(Organism[] grid, int width)
    {
        ArrayList<Integer> directions = new ArrayList<Integer>(4);

        if (this.index - 1 >= 0)
        {
            directions.add(this.index - 1);
        }
        if (this.index + 1 < grid.length)
        {
            directions.add(this.index + 1);
        }
        if (this.index - width >= 0)
        {
            directions.add(this.index - width);
        }
        if (this.index + width < grid.length)
        {
            directions.add(this.index + width);
        }

        int dirSize = directions.size();
        for (int i = 0; i < dirSize; i++)
        {
            Random rand = new Random();
            int randDir = rand.nextInt(directions.size());
            int newIndex = directions.get(randDir);
            if(grid[newIndex].GetName().equals(""))
            {
                grid[this.index] = new Organism();
                grid[newIndex] = new Ant(newIndex, this.currentStepLife + 1);
                return;
            }
            directions.remove(randDir);
        }
    }

    private void breed(Organism[] grid, int width)
    {
        ArrayList<Integer> directions = new ArrayList<Integer>(4);

        if (this.index - 1 >= 0)
        {
            directions.add(this.index - 1);
        }
        if (this.index + 1 < grid.length)
        {
            directions.add(this.index + 1);
        }
        if (this.index - width >= 0)
        {
            directions.add(this.index - width);
        }
        if (this.index + width < grid.length)
        {
            directions.add(this.index + width);
        }

        int dirSize = directions.size();
        for (int i = 0; i < dirSize; i++)
        {
            Random rand = new Random();
            int randDir = rand.nextInt(directions.size());
            int newIndex = directions.get(randDir);
            if(grid[newIndex].GetName().equals(""))
            {
                grid[newIndex] = new Ant(newIndex);
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
        this.endTurn = true;
    }
}
