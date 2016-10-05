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
        for (int i = 0; i < size; i++)
        {
            grid[i] = new Organism();
        }
    }

    public void InitGrid(int antAmount, int doodleBugAmount)
    {
        while(antAmount > 0)
        {
            Random rand = new Random();
            int randPos = rand.nextInt(this.size);
            if(this.grid[randPos].GetName().equals(""))
            {
                this.grid[randPos] = new Ant(randPos);
                --antAmount;
            }
        }

        while(doodleBugAmount > 0)
        {
            Random rand = new Random();
            int randPos = rand.nextInt(this.size);
            if (this.grid[randPos].GetName().equals(""))
            {
                this.grid[randPos] = new Doodlebug(randPos);
                --doodleBugAmount;
            }
        }
        printGrid();
    }

    public void printGrid()
    {
        String gridString = "";
        for(int i = 0; i < this.width; i++)
        {
            for (int j = 0; j < this.height; j++)
            {
                if(grid[(this.width * i) + j].GetName().equals("Doodlebug"))
                {
                    gridString += "x ";
                }
                else if(grid[(this.width * i) + j].GetName().equals("Ant"))
                {
                    gridString += "o ";
                }
                else
                {
                    gridString += "- ";
                }
            }
            gridString += "\n";
        }
        System.out.print(gridString);
    }

    public void SimStep()
    {
        for(int index = 0; index < this.size; index++)
        {
            if (grid[index].GetName().equals("Doodlebug"))
            {
                grid[index].simStep(this.grid, this.width);
            }
        }
        for(int index = 0; index < this.size; index++)
        {
            if(grid[index].GetName().equals("Ant"))
            {
                grid[index].simStep(this.grid, this.width);
            }
        }

        printGrid();
    }
}
