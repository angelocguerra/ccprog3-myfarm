public class Tile {
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

    public void displayTileStatus()
    {
        System.out.println("\nTile Status: ");
        if (isRockPlaced)
        {
            System.out.println("There is a rock on this tile.");
        } else if (!isPlowed)
        {
            System.out.println("This tile is unplowed.");
        } else if (!isFarmed)
        {
            System.out.println("There is no crop growing on this tile.");
        } else if (isWithered)
        {
            System.out.println("The crop on this tile has withered away.");
        } else
        {
            if (isRipe)
            {
                System.out.println("This crop is ready to be harvested!\n");
            }
            System.out.println("crop: " + getPlant());
            System.out.println("Type: " + getPlantType());
            System.out.println("Days to Harvest: "+ getDaysToHarvest());
            System.out.println("Times Watered Today: " + getTimesWateredToday());
            System.out.println("Daily Water Requirement " + getWaterNeeds());
            System.out.println("Times Fertilized Today: " + getTimesFertilizedToday());
            System.out.println("Daily Fertilizer Requirement: " + getFertilizerNeeds());
        }
    }

    public void growCrop()
    {
        if (isFarmed)
        {
            daysToHarvest--;
            if (timesWateredToday < waterNeeds || timesFertilizedToday < fertilizerNeeds || daysToHarvest<0)
            {
                isWithered = true;
            } else if (daysToHarvest == 0)
            {
                isRipe = true;
            }
            timesFertilizedToday = 0;
            timesWateredToday = 0;
        }
    }

    public void reset(){
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

    public boolean getIsRockPlaced() {
        return isRockPlaced;
    }

    public void setRockPlaced(boolean rockPlaced) {
        isRockPlaced = rockPlaced;
    }

    public boolean getIsPlowed() {
        return isPlowed;
    }

    public void setPlowed(boolean plowed) {
        isPlowed = plowed;
    }

    public boolean getIsFarmed() {
        return isFarmed;
    }

    public void setFarmed(boolean farmed) {
        isFarmed = farmed;
    }

    public int getTimesWateredToday() {
        return timesWateredToday;
    }

    public void setTimesWateredToday(int timesWateredToday) {
        this.timesWateredToday = timesWateredToday;
    }

    public int getTotalTimesWatered() {
        return totalTimesWatered;
    }

    public void setTotalTimesWatered(int totalTimesWatered) {
        this.totalTimesWatered = totalTimesWatered;
    }

    public int getWaterNeeds() {
        return waterNeeds;
    }

    public void setWaterNeeds(int waterNeeds) {
        this.waterNeeds = waterNeeds;
    }

    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    public void setWaterBonusLimit(int waterBonusLimit) {
        this.waterBonusLimit = waterBonusLimit;
    }

    public int getTimesFertilizedToday() {
        return timesFertilizedToday;
    }

    public void setTimesFertilizedToday(int timesFertilizedToday) {
        this.timesFertilizedToday = timesFertilizedToday;
    }

    public int getTotalTimesFertilized() {
        return totalTimesFertilized;
    }

    public void setTotalTimesFertilized(int totalTimesFertilized) {
        this.totalTimesFertilized = totalTimesFertilized;
    }

    public int getFertilizerNeeds() {
        return fertilizerNeeds;
    }

    public void setFertilizerNeeds(int fertilizerNeeds) {
        this.fertilizerNeeds = fertilizerNeeds;
    }

    public int getFertilizerBonusLimit() {
        return fertilizerBonusLimit;
    }

    public void setFertilizerBonusLimit(int fertilizerBonusLimit) {
        this.fertilizerBonusLimit = fertilizerBonusLimit;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public void setPlantType(PlantType plantType) {
        this.plantType = plantType;
    }

    public boolean getIsRipe() {
        return isRipe;
    }

    public boolean getIsWithered() {
        return isWithered;
    }

    public int getDaysToHarvest() {
        return daysToHarvest;
    }

    public void setDaysToHarvest(int daysToHarvest) {
        this.daysToHarvest = daysToHarvest;
    }

    public int getMinProduceYield() {
        return minProduceYield;
    }

    public void setMinProduceYield(int minProduceYield) {
        this.minProduceYield = minProduceYield;
    }

    public int getMaxProduceYield() {
        return maxProduceYield;
    }

    public void setMaxProduceYield(int maxProduceYield) {
        this.maxProduceYield = maxProduceYield;
    }

    public double getProductSellPrice() {
        return productSellPrice;
    }

    public void setProductSellPrice(double productSellPrice) {
        this.productSellPrice = productSellPrice;
    }

    public double getExpYield() {
        return expYield;
    }

    public void setExpYield(double expYield) {
        this.expYield = expYield;
    }
}
