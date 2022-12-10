import java.util.Random;
import java.util.Scanner;

/**
 * This class contains all farmer (player) details and actions
 */
public class Farmer
{
    private final String name;
    private FarmerType type = FarmerType.FARMER;
    private int bonusProduceEarnings = 0;
    private int seedCostReduction = 0;
    private int level = 1;
    private double experience = 0;
    private int objectCoin = 100;
    Scanner scan = new Scanner(System.in);

    /**
     * Constructor for Farmer Class
     * @param name Farmer's Name, from user input in Game class
     */
    public Farmer(String name)
    {
        this.name = name;
    }

    /**
     * Purpose: This method allows the farmer (player) to buy seeds
     * @param seed Object for Seed class, which contains all seed details (amount and Crop details)
     */
    public void buySeeds(Seed seed)
    {
        int nAmount;
        System.out.println("Seed: "+seed.getName());
        System.out.println("How many seeds would you like to purchase? ");
        nAmount = scan.nextInt();
        scan.nextLine();
        if (objectCoin < (seed.getSeedCost()-seedCostReduction)*nAmount) {
            System.out.println("Insufficient Funds");
        } else {
            objectCoin-= (seed.getSeedCost()-seedCostReduction)*nAmount;
            seed.setAmount(seed.getAmount()+nAmount);
            System.out.println("Purchased x" + nAmount + " " + seed.getName() + " seeds.");
            System.out.println("Remaining balance: " + objectCoin);
        }
    }

    /**
     * Purpose: This method allows the farmer (player) to use his available tools
     * @param tool Object for Tool class, which contains all tool details
     * @param tile Object for Tile class, where tools will be used upon
     */
    public void useTool(Tool tool, Tile tile)
    {
        switch (tool.getName())
        {
            case "Plow Tool" -> tile.setPlowed(true);
            case "Watering Can" -> {
                tile.setTimesWateredToday(tile.getTimesWateredToday() + 1);
                tile.setTotalTimesWatered(tile.getTotalTimesWatered() + 1);
            }
            case "Fertilizer" -> {
                tile.setTimesFertilizedToday(tile.getTimesFertilizedToday() + 1);
                tile.setTotalTimesFertilized(tile.getTotalTimesFertilized() + 1);
            }
            case "Pickaxe" -> tile.setRockPlaced(true);
            default -> tile.reset();
        }
        objectCoin-= tool.getUseCost();
        experience+= tool.getExperienceYield();
    }

    /**
     * Purpose: This method allows the farmer (player) to plant crops
     * @param seed Object for Seed class, which concerns all seed details (amount and Crop details)
     * @param tile Object for Tile class, where seeds (crops) will be planted upon
     */
    public void plantCrop(Seed seed, Tile tile)
    {
        if (seed.getAmount() == 0)
        {
            System.out.println("No seeds for this plant");
        } else {
            tile.setFarmed(true);
            tile.setPlant(seed.getName());
            tile.setPlantType(seed.getType());
            tile.setDaysToHarvest(seed.getHarvestTime());
            tile.setFertilizerBonusLimit(seed.getFertilizerBonusLimit());
            tile.setFertilizerNeeds(seed.getFertilizerNeeds());
            tile.setWaterBonusLimit(seed.getWaterBonusLimit());
            tile.setWaterNeeds(seed.getWaterNeeds());
            tile.setMinProduceYield(seed.getMinProduceYield());
            tile.setMaxProduceYield(seed.getMaxProduceYield());
            tile.setProductSellPrice(seed.getProduceSellPrice());
            tile.setExpYield(seed.getExpYield());
            System.out.println("Planted " + seed.getName() + " on this tile.");
        }
    }

    public void plantCrop(Seed seed, int tens, int ones, Tile[][] tiles)
    {
        if (seed.getAmount() == 0)
        {
            System.out.println("No seeds for this plant");
        } else {
            if (tiles[tens - 1][ones - 1].getIsFarmed() || tiles[tens - 1][ones].getIsFarmed() || tiles[tens - 1][ones + 1].getIsFarmed()
                    || tiles[tens][ones - 1].getIsFarmed() || tiles[tens][ones + 1].getIsFarmed() || tiles[tens+1][ones-1].getIsFarmed()
                    || tiles[tens+1][ones].getIsFarmed() || tiles[tens+1][ones+1].getIsFarmed() || tiles[tens - 1][ones - 1].getIsWithered()
                    || tiles[tens - 1][ones].getIsWithered() || tiles[tens - 1][ones + 1].getIsWithered() || tiles[tens][ones - 1].getIsWithered()
                    || tiles[tens][ones + 1].getIsWithered() || tiles[tens+1][ones-1].getIsWithered() || tiles[tens+1][ones].getIsWithered()
                    || tiles[tens+1][ones+1].getIsWithered() || tiles[tens - 1][ones - 1].getIsRockPlaced() || tiles[tens - 1][ones].getIsRockPlaced()
                    || tiles[tens - 1][ones + 1].getIsRockPlaced() || tiles[tens][ones - 1].getIsRockPlaced() || tiles[tens][ones + 1].getIsRockPlaced()
                    || tiles[tens+1][ones-1].getIsRockPlaced() || tiles[tens+1][ones].getIsRockPlaced() || tiles[tens+1][ones+1].getIsRockPlaced())
            {
                System.out.println("There are objects obstructing the tree. Please clear them first");
            } else {
                tiles[tens][ones].setFarmed(true);
                tiles[tens][ones].setPlant(seed.getName());
                tiles[tens][ones].setPlantType(seed.getType());
                tiles[tens][ones].setDaysToHarvest(seed.getHarvestTime());
                tiles[tens][ones].setFertilizerBonusLimit(seed.getFertilizerBonusLimit());
                tiles[tens][ones].setFertilizerNeeds(seed.getFertilizerNeeds());
                tiles[tens][ones].setWaterBonusLimit(seed.getWaterBonusLimit());
                tiles[tens][ones].setWaterNeeds(seed.getWaterNeeds());
                tiles[tens][ones].setMinProduceYield(seed.getMinProduceYield());
                tiles[tens][ones].setMaxProduceYield(seed.getMaxProduceYield());
                tiles[tens][ones].setProductSellPrice(seed.getProduceSellPrice());
                tiles[tens][ones].setExpYield(seed.getExpYield());
                System.out.println("Planted " + seed.getName() + " on this tile.");
            }
        }
    }

    /**
     * Purpose: This method allows the farmer (player) to harvest crops
     * @param tile Object for Tile class, where crops will be harvested upon
     */
    public void harvestCrop(Tile tile)
    {
        Random rand = new Random();
        int produce;
        if (tile.getMaxProduceYield() == 1) {
            produce = 1;
        } else {
            produce = rand.nextInt(tile.getMaxProduceYield()-tile.getMinProduceYield())+tile.getMinProduceYield();
        }
        double harvestTotal = (produce * (tile.getProductSellPrice() + bonusProduceEarnings));
        double waterBonus = harvestTotal*(.2)*(tile.getTotalTimesWatered()-1);
        double fertilizerBonus = harvestTotal*(.5)*(tile.getTotalTimesFertilized());
        double total;
        if (tile.getPlantType() == PlantType.FLOWER) {
            total = (1.1) * (harvestTotal+waterBonus+fertilizerBonus);
            System.out.println("Flower bonus! 10%");
        } else {
            total = (harvestTotal+waterBonus+fertilizerBonus);
        }

        experience+=tile.getExpYield();
        objectCoin+=total;

        System.out.println("Produce: " + produce);
        System.out.println("You have earned " + total + " coins & " + tile.getExpYield() + " exp!");

        tile.reset();
    }

    /**
     * Purpose: This method allows the player (farmer) to register for a higher statuses
     * @param tiles Object for Tile class, where higher farmer types' benefits will be implemented upon
     */
    public void registerForHigherStatus(Tile[][] tiles)
    {
        if (type == FarmerType.LEGENDARY_FARMER) {
            System.out.println("You have already achieved max status!");
        } else if (type == FarmerType.DISTINGUISHED_FARMER) {
            if (objectCoin < 400) {
                System.out.println("Insufficient Funds");
            } else if (level < 15) {
                System.out.println("Your level is not high enough for this status");
            } else {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 10; j++)
                    {
                        tiles[i][j].setWaterBonusLimit(tiles[i][j].getWaterBonusLimit()+1);
                        tiles[i][j].setFertilizerBonusLimit(tiles[i][j].getFertilizerBonusLimit()+1);
                    }
                }
                seedCostReduction = 3;
                bonusProduceEarnings = 4;
                type = FarmerType.LEGENDARY_FARMER;
                objectCoin-=400;
                System.out.println("Congratulations! You are now a Legendary Farmer");
            }
        } else if (type == FarmerType.REGISTERED_FARMER) {
            if (objectCoin < 300) {
                System.out.println("Insufficient Funds");
            } else if (level < 10) {
                System.out.println("Your level is not high enough for this status");
            } else {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 10; j++)
                    {
                        tiles[i][j].setWaterBonusLimit(tiles[i][j].getWaterBonusLimit()+1);
                    }
                }
                seedCostReduction = 2;
                bonusProduceEarnings = 2;
                type = FarmerType.DISTINGUISHED_FARMER;
                objectCoin-=300;
                System.out.println("Congratulations! You are now a Distinguished Farmer");
            }
        } else {
            if (objectCoin < 200) {
                System.out.println("Insufficient Funds");
            } else if (level < 5) {
                System.out.println("Your level is not high enough for this status");
            } else {
                seedCostReduction = 1;
                bonusProduceEarnings = 1;
                type = FarmerType.REGISTERED_FARMER;
                objectCoin-=200;
                System.out.println("Congratulations! You are now a Registered Farmer");
            }
        }
    }

    /**
     * Purpose: This method allows the farmer (player) to increase his level over playing and gaining experience
     */
    public void levelUp()
    {
        double levelProgress = experience/level; //
        if (levelProgress >= 100) {
            level++;
        }
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the name details
     * @return The name of the farmer (player)
     */
    public String getName()
    {
        return name;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the farmer type details
     * @return The type of the farmer (whether Default, Registered, Distinguished, or Legendary)
     */
    public FarmerType getType()
    {
        return type;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the farmer's (player) level details
     * @return The farmer's (player) current level
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the farmer's (player) experience gain
     * @return The farmer's experience gain
     */
    public double getExperience()
    {
        return experience;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the farmer's (player) ObjectCoin amount
     * @return The farmer's ObjectCoin amount
     */
    public int getObjectCoin()
    {
        return objectCoin;
    }
}