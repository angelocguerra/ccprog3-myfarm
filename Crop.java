public class Crop {
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

    public String getName() {
        return name;
    }

    public PlantType getType() {
        return type;
    }

    public int getSeedCost() {
        return seedCost;
    }

    public int getHarvestTime() {
        return harvestTime;
    }

    public int getWaterNeeds() {
        return waterNeeds;
    }

    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    public int getFertilizerNeeds() {
        return fertilizerNeeds;
    }

    public int getFertilizerBonusLimit() {
        return fertilizerBonusLimit;
    }

    public int getMinProduceYield() {
        return minProduceYield;
    }

    public int getMaxProduceYield() {
        return maxProduceYield;
    }

    public double getProduceSellPrice() {
        return produceSellPrice;
    }

    public double getExpYield() {
        return expYield;
    }
}