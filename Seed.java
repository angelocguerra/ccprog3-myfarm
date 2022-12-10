/**
 * This class contains all seed details inherited from the Crop class
 */
public class Seed extends Crop
{
    private int amount;

    /**
     * Constructor for Seed Class
     * @param crop Object for Crop class, which contains all the plant's details
     */
    public Seed (Crop crop)
    {
        super();
        this.amount = 0;
        this.setName(crop.getName());
        this.setType(crop.getType());
        this.setSeedCost(crop.getSeedCost());
        this.setHarvestTime(crop.getHarvestTime());
        this.setWaterNeeds(crop.getWaterNeeds());
        this.setWaterBonusLimit(crop.getWaterBonusLimit());
        this.setFertilizerNeeds(crop.getFertilizerNeeds());
        this.setFertilizerBonusLimit(getFertilizerBonusLimit());
        this.setMinProduceYield(crop.getMinProduceYield());
        this.setMaxProduceYield(crop.getMaxProduceYield());
        this.setProduceSellPrice(crop.getProduceSellPrice());
        this.setExpYield(crop.getExpYield());
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
}