/**
 * This class contains all crop details and actions
 */
public class Crop
{
    private final String name;
    private final PlantType type;
    private final int seedCost;
    private final int harvestTime;
    private final int waterNeeds;
    private final int waterBonusLimit;
    private final int fertilizerNeeds;
    private final int fertilizerBonusLimit;
    private final int minProduceYield;
    private final int maxProduceYield;
    private final double produceSellPrice;
    private final double expYield;

    /**
     * Constructor for src.Crop Class
     * @param name src.Crop Name
     * @param TYPE Plant Type, from PlantType class
     * @param seedCost Cost to buy the seed
     * @param harvestTime Number of day(s) past before the crop can be harvested
     * @param waterNeeds Minimum number of time(s) the crop should be watered
     * @param waterBonusLimit Maximum number of time(s) the crop can be watered
     * @param fertilizerNeeds Minimum number of time(s) the crop should be fertilized
     * @param fertilizerBonusLimit Maximum number of time(s) the crop can be fertilized
     * @param minProduceYield Minimum amount of products produced from a crop
     * @param maxProduceYield Maximum amount of products produced from a crop
     * @param produceSellPrice Base selling price of each product from a harvest
     * @param expYield Amount of experience earned from successfully harvesting a crop
     */
    public Crop(String name, PlantType TYPE, int seedCost, int harvestTime, int waterNeeds, int waterBonusLimit, int fertilizerNeeds, int fertilizerBonusLimit, int minProduceYield, int maxProduceYield, double produceSellPrice, double expYield)
    {
        this.name = name;
        this.type = TYPE;
        this.seedCost = seedCost;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.waterBonusLimit = waterBonusLimit;
        this.fertilizerNeeds = fertilizerNeeds;
        this.fertilizerBonusLimit = fertilizerBonusLimit;
        this.minProduceYield = minProduceYield;
        this.maxProduceYield = maxProduceYield;
        this.produceSellPrice = produceSellPrice;
        this.expYield = expYield;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the details of a crop's name
     * @return The name of the crop
     */
    public String getName()
    {
        return name;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the plant type details
     * @return The plant type of the crop, from PlantType class
     */
    public PlantType getType()
    {
        return type;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the seed cost details
     * @return The cost to buy the seed
     */
    public int getSeedCost()
    {
        return seedCost;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the harvest time details
     * @return The number of day(s) past before the crop can be harvested
     */
    public int getHarvestTime()
    {
        return harvestTime;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the water needs details
     * @return The minimum number of time(s) the crop should be watered
     */
    public int getWaterNeeds()
    {
        return waterNeeds;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the water bonus limit details
     * @return The maximum number of time(s) the crop can be watered
     */
    public int getWaterBonusLimit()
    {
        return waterBonusLimit;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the fertilizer needs details
     * @return The minimum number of time(s) the crop should be fertilized
     */
    public int getFertilizerNeeds()
    {
        return fertilizerNeeds;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the fertilizer bonus limit details
     * @return The maximum number of time(s) the crop can be fertilized
     */
    public int getFertilizerBonusLimit()
    {
        return fertilizerBonusLimit;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the minimum produce yield details
     * @return The minimum amount of products produced from a crop
     */
    public int getMinProduceYield()
    {
        return minProduceYield;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the maximum produce yield details
     * @return The maximum amount of products produced from a crop
     */
    public int getMaxProduceYield()
    {
        return maxProduceYield;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the produce selling price details
     * @return The base selling price of each product from a harvest
     */
    public double getProduceSellPrice()
    {
        return produceSellPrice;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the experience yield details of a crop
     * @return The amount of experience earned from successfully harvesting a crop
     */
    public double getExpYield()
    {
        return expYield;
    }
}