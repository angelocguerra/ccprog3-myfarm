/**
 * This class contains all details about a farm tile (including the crop planted on it) and other possible actions
 */
public class Tile
{
    private boolean isRockPlaced = false;
    private boolean isPlowed = false;
    private boolean isFarmed = false;
    private int timesWateredToday = 0;
    private int totalTimesWatered = 0;
    private int waterNeeds = 0;
    private int waterBonusLimit = 0;
    private int timesFertilizedToday = 0;
    private int totalTimesFertilized = 0;
    private int fertilizerNeeds = 0;
    private int fertilizerBonusLimit = 0;
    private String plant;
    private PlantType plantType;
    private boolean isRipe = false;
    private boolean isWithered = false;
    private int daysToHarvest = 0;
    private int minProduceYield = 0;
    private int maxProduceYield = 0;
    private double productSellPrice = 0;
    private double expYield = 0;

    /**
     * Purpose: This method displays the Tile Status
     */
    public void displayTileStatus()
    {
        System.out.println("\nTile Status: ");
        if (isRockPlaced) {
            System.out.println("""
                    ++++++++++
                    +  /```\\ +
                    +  \\___/ +
                    ++++++++++""");
            System.out.println("There is a rock on this tile.");
        } else if (!isPlowed) {
            System.out.println("""
                    ++++++++++
                    ++ ++++ ++
                    ++ ++++ ++
                    ++++++++++""");
            System.out.println("This tile is unplowed.");
        } else if (!isFarmed) {
            System.out.println("""
                    ++++++++++
                    +        +
                    +        +
                    ++++++++++""");
            System.out.println("There is no crop growing on this tile.");
        } else if (isWithered) {
            System.out.println("""
                    ++++++++++
                    + /\\-|-/\\+
                    + _/\\|/\\_+
                    ++++++++++""");
            System.out.println("The crop on this tile has withered away.");
        } else {
            if (isRipe)
            {
                System.out.println("""
                    ++++++++++
                    + ~\\~|~/~+
                    +  ~\\|/~ +
                    ++++++++++""");
                System.out.println("This crop is ready to be harvested!\n");
            }
            System.out.println("Crop: " + getPlant());
            System.out.println("Type: " + getPlantType());
            System.out.println("Days to Harvest: "+ getDaysToHarvest());
            System.out.println("Times Watered Today: " + getTimesWateredToday());
            System.out.println("Daily Water Requirement " + getWaterNeeds());
            System.out.println("Times Fertilized Today: " + getTimesFertilizedToday());
            System.out.println("Daily Fertilizer Requirement: " + getFertilizerNeeds());
        }
    }

    /**
     * Purpose: This method decrements the crop's daysToHarvest
     * and checks if the crop is ready for harvesting or if it surpasses its harvestTime and makes it withered
     */
    public void growCrop()
    {
        if (isFarmed)
        {
            daysToHarvest--;
            if (timesWateredToday < waterNeeds || timesFertilizedToday < fertilizerNeeds || daysToHarvest<0) {
                isWithered = true;
            } else if (daysToHarvest == 0) {
                isRipe = true;
            }
            timesFertilizedToday = 0;
            timesWateredToday = 0;
        }
    }

    /**
     * Purpose: This method resets all Tile details for game restart
     */
    public void reset()
    {
        isRockPlaced = false;
        isPlowed = false;
        isFarmed = false;
        timesWateredToday = 0;
        totalTimesWatered = 0;
        waterNeeds = 0;
        waterBonusLimit = 0;
        timesFertilizedToday = 0;
        totalTimesFertilized = 0;
        fertilizerNeeds = 0;
        fertilizerBonusLimit = 0;
        plant = "";
        isRipe = false;
        isWithered = false;
        daysToHarvest = 0;
        minProduceYield = 0;
        maxProduceYield = 0;
        productSellPrice = 0;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the isRockPlaced details
     * @return True if there is a rock placed on the tile, False if none
     */
    public boolean getIsRockPlaced()
    {
        return isRockPlaced;
    }

    /**
     * Purpose: This setter method allows the program to update the details of isRockPlaced
     * @param rockPlaced True if there is a rock placed on the tile, False if none
     */
    public void setRockPlaced(boolean rockPlaced)
    {
        isRockPlaced = rockPlaced;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the isPlowed details
     * @return True if the tile has been plowed, False if not yet
     */
    public boolean getIsPlowed()
    {
        return isPlowed;
    }

    /**
     * Purpose: This setter method allows the program to update the details of isPlowed
     * @param plowed True if the tile has been plowed, False if not yet
     */
    public void setPlowed(boolean plowed)
    {
        isPlowed = plowed;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the isFarmed details
     * @return True if the tile has been farmed and planted with a crop, False if not yet
     */
    public boolean getIsFarmed()
    {
        return isFarmed;
    }

    /**
     * Purpose: This setter method allows the program to update the details of isFarmed
     * @param farmed True if the tile has been farmed and planted with a crop, False if not yet
     */
    public void setFarmed(boolean farmed)
    {
        isFarmed = farmed;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the timesWateredToday details
     * @return The number of time(s) the crop has been watered for the day
     */
    public int getTimesWateredToday()
    {
        return timesWateredToday;
    }

    /**
     * Purpose: This setter method allows the program to update the details of timesWateredToday
     * @param timesWateredToday The number of time(s) the crop has been watered for the day
     */
    public void setTimesWateredToday(int timesWateredToday)
    {
        this.timesWateredToday = timesWateredToday;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the totalTimesWatered details
     * @return The total number of time(s) the crop has been watered over the days
     */
    public int getTotalTimesWatered()
    {
        return totalTimesWatered;
    }

    /**
     * Purpose: This setter method allows the program to update the details of totalTimesWatered
     * @param totalTimesWatered The total number of time(s) the crop has been watered over the days
     */
    public void setTotalTimesWatered(int totalTimesWatered)
    {
        this.totalTimesWatered = totalTimesWatered;
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
     * Purpose: This setter method allows the program to update the details of the crop's water needs
     * @param waterNeeds The minimum number of time(s) the crop should be watered
     */
    public void setWaterNeeds(int waterNeeds)
    {
        this.waterNeeds = waterNeeds;
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
     * Purpose: This setter method allows the program to update the details of the crop's water bonus limit
     * @param waterBonusLimit The maximum number of time(s) the crop can be watered
     */
    public void setWaterBonusLimit(int waterBonusLimit)
    {
        this.waterBonusLimit = waterBonusLimit;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the timesFertilizedToday details
     * @return The number of time(s) the crop has been fertilized for the day
     */
    public int getTimesFertilizedToday()
    {
        return timesFertilizedToday;
    }

    /**
     * Purpose: This setter method allows the program to update the details of timesFertilizedToday
     * @param timesFertilizedToday The number of time(s) the crop has been fertilized for the day
     */
    public void setTimesFertilizedToday(int timesFertilizedToday)
    {
        this.timesFertilizedToday = timesFertilizedToday;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the totalTimesFertilized details
     * @return The total number of time(s) the crop has been fertilized over the days
     */
    public int getTotalTimesFertilized()
    {
        return totalTimesFertilized;
    }

    /**
     * Purpose: This setter method allows the program to update the details of totalTimesFertilized
     * @param totalTimesFertilized The total number of time(s) the crop has been fertilized over the days
     */
    public void setTotalTimesFertilized(int totalTimesFertilized)
    {
        this.totalTimesFertilized = totalTimesFertilized;
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
     * Purpose: This setter method allows the program to update the details of the crop's fertilizer needs
     * @param fertilizerNeeds The minimum number of time(s) the crop should be fertilized
     */
    public void setFertilizerNeeds(int fertilizerNeeds)
    {
        this.fertilizerNeeds = fertilizerNeeds;
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
     * Purpose: This setter method allows the program to update the details of the crop's fertilizer bonus limit
     * @param fertilizerBonusLimit The maximum number of time(s) the crop can be fertilized
     */
    public void setFertilizerBonusLimit(int fertilizerBonusLimit)
    {
        this.fertilizerBonusLimit = fertilizerBonusLimit;
    }

    /**
     * Purpose: This method allows the program to retrieve and access the plant details
     * @return The name of the seed/crop/plant
     */
    public String getPlant()
    {
        return plant;
    }

    /**
     * Purpose: This method allows the program to update the details of the plant/crop's name
     * @param plant The name of the seed/crop/plant
     */
    public void setPlant(String plant)
    {
        this.plant = plant;
    }

    /**
     * Purpose: This method allows the program to retrieve and access the PlantType details
     * @return The crop's plant type
     */
    public PlantType getPlantType()
    {
        return plantType;
    }

    /**
     * Purpose: This method allows the program to update the details of the crop's plant type
     * @param plantType The crop's plant type
     */
    public void setPlantType(PlantType plantType)
    {
        this.plantType = plantType;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the isRipe details
     * @return True if the crop/plant is ripe and ready to harvest, False if not yet
     */
    public boolean getIsRipe()
    {
        return isRipe;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the isWithered details
     * @return True if the crop/plant has withered, False if not yet
     */
    public boolean getIsWithered()
    {
        return isWithered;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the daysToHarvest details
     * @return The number of day(s) remaining before the crop can be harvested
     */
    public int getDaysToHarvest()
    {
        return daysToHarvest;
    }

    /**
     * Purpose: This setter method allows the program to update the details of the plant/crop's daysToHarvest
     * @param daysToHarvest The number of day(s) remaining before the crop can be harvested
     */
    public void setDaysToHarvest(int daysToHarvest)
    {
        this.daysToHarvest = daysToHarvest;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the minProduceYield details
     * @return The minimum amount of products produced from a crop
     */
    public int getMinProduceYield()
    {
        return minProduceYield;
    }

    /**
     * Purpose: This setter method allows the program to update the details of the product's minimum produce yield
     * @param minProduceYield The minimum amount of products produced from a crop
     */
    public void setMinProduceYield(int minProduceYield)
    {
        this.minProduceYield = minProduceYield;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the maxProduceYield details
     * @return The maximum amount of products produced from a crop
     */
    public int getMaxProduceYield()
    {
        return maxProduceYield;
    }

    /**
     * Purpose: This setter method allows the program to update the details of the product's maximum produce yield
     * @param maxProduceYield The maximum amount of products produced from a crop
     */
    public void setMaxProduceYield(int maxProduceYield)
    {
        this.maxProduceYield = maxProduceYield;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the ProductSellPrice details
     * @return The base selling price of each product from a harvest
     */
    public double getProductSellPrice()
    {
        return productSellPrice;
    }

    /**
     * Purpose: This setter method allows the program to update the details of the product's base selling price
     * @param productSellPrice The base selling price of each product from a harvest
     */
    public void setProductSellPrice(double productSellPrice)
    {
        this.productSellPrice = productSellPrice;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the expYield details
     * @return The amount of experience earned from successfully harvesting a crop
     */
    public double getExpYield()
    {
        return expYield;
    }

    /**
     * Purpose: This setter method allows the program to update the details of the experience yield gained from a harvest
     * @param expYield The amount of experience earned from successfully harvesting a crop
     */
    public void setExpYield(double expYield)
    {
        this.expYield = expYield;
    }
}
