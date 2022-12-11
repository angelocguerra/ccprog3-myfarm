/**
 * This class contains all farm details (tiles) and actions
 */
public class Farm
{
    // Tile Instantiation
    private final Tile[][] tiles = {{new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()},
                                    {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()},
                                    {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()},
                                    {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()},
                                    {new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile(), new Tile()}};

    /**
     * Purpose: This method allows the program to retrieve and access tiles details
     * @return The tiles' details
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    public void setRocks(String[] rocks)
    {
        int k = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 10; j++)
                if (!rocks[k].equals("0"))
                    tiles[i][j].setRockPlaced(true);
    }
}