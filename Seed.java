/**
 * This class contains all seed details inherited from the Crop class
 */
public class Seed
{
    private int amount;
    private final Crop crop;

    /**
     * Constructor for Seed Class
     * @param crop Object for Crop class, which contains all the plant's details
     */
    public Seed (Crop crop)
    {
        this.amount = 0;
        this.crop = crop;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the amount details
     * @return The amount of seeds the farmer (player) currently has on a particular plant
     */
    public int getAmount()
    {
        return amount;
    }

    /**
     * Purpose: This setter method allows the program to update the amount of seeds the farmer (player) currently has
     * @param amount The amount of seeds the farmer (player) currently has on a particular plant
     */
    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the crop details
     * @return crop, the instantiated object from the Crop class, which contains all the details on a particular plant
     */
    public Crop getCrop()
    {
        return crop;
    }
}