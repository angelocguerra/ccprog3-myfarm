/*
  Guerra, Jose Maria Angelo; Inocencio, Rey Vincent H. - S16 MCO1 Group 7
  I hereby certify that this work is original.
 */

import java.util.Scanner;

public class Game {
    
    private static int days = 1;

    public static void advanceDays(Tile tile){
        days++;
        tile.growCrop();
    }
    
    public static void main(String[] args)
    {
        boolean gameRun;
        boolean dayEnd;

        Scanner scan = new Scanner(System.in);
        String farmerName;
        int userInput;
        int userInput2;

        //  Crop/Seed instantiation
        Crop Turnip    = new Crop("Turnip", PlantType.ROOT_CROP, 5, 2, 1, 2, 0, 1, 1, 2, 6, 5);
        Crop Carrot    = new Crop("Carrot", PlantType.ROOT_CROP, 10, 3, 1, 2, 0, 1, 1, 2, 9, 7.5);
        Crop Potato    = new Crop("Potato", PlantType.ROOT_CROP, 20, 5, 3, 4,1, 2, 1, 10, 3, 12.5);
        Crop Rose      = new Crop("Rose", PlantType.FLOWER, 5, 1, 1, 2, 0, 1, 1, 1, 5, 2.5);
        Crop Tulips    = new Crop("Tulips", PlantType.FLOWER, 10, 2, 2, 3,0, 1, 1, 1,9, 5);
        Crop Sunflower = new Crop("Sunflower", PlantType.FLOWER, 20, 3, 2, 3,1, 2,1, 1,19, 7.5);
        Crop Mango     = new Crop("Mango", PlantType.FRUIT_TREE, 100, 10, 7, 7,4, 4, 5, 15, 8, 25);
        Crop Apple     = new Crop("Apple", PlantType.FRUIT_TREE, 200, 10, 7, 7, 5, 5, 10, 15, 5, 25);

        Seed TurnipSeed    = new Seed(Turnip);
        Seed CarrotSeed    = new Seed(Carrot);
        Seed PotatoSeed    = new Seed(Potato);
        Seed RoseSeed      = new Seed(Rose);
        Seed TulipsSeed    = new Seed(Tulips);
        Seed SunflowerSeed = new Seed(Sunflower);
        Seed MangoSeed     = new Seed(Mango);
        Seed AppleSeed     = new Seed(Apple);

        //  Tool instantiation
        Tool PlowTool = new Tool("Plow Tool", 0, 0.5);
        Tool WateringCan = new Tool("Watering Can", 0, 0.5);
        Tool Fertilizer = new Tool("Fertilizer", 10, 4);
        Tool Pickaxe = new Tool("Pickaxe", 50, 15);
        Tool Shovel = new Tool("Shovel", 7, 2);

        //instructions:
        //TODO: create instructions interface

        //player details
        System.out.print("Please enter your name: ");
        farmerName = scan.nextLine();
        Farmer farmer = new Farmer(farmerName);

        Farm farm = new Farm();

        //Main Game Loop
        do {
            //display daily stats
            System.out.println("\n" + farmer.getName() + "'s" + " Farm: Day " + days);
            System.out.println("Level " + farmer.getLevel() + "(" + farmer.getType() + ")");
            System.out.println("Progress: " + farmer.getExperience() + " exp points");

            dayEnd = false;
            do {
                //display tile status
                farm.getTile().displayTileStatus();

                //main game menu
                System.out.println("\n"+farmer.getObjectCoin() + " coins\n");
                System.out.println("What would you like to do? ");
                System.out.println("[1] Buy Seeds");
                System.out.println("[2] Use Tools");
                System.out.println("[3] Plant Crops");
                System.out.println("[4] Harvest Crops");
                System.out.println("[5] Register for a higher farmer status");
                System.out.println("[6] End the Day");

                userInput = scan.nextInt();
                scan.nextLine();

                switch (userInput)
                {
                    case (1):
                        System.out.println("Which type of seeds would you like to buy? ");
                        System.out.println("[1] Turnip\n[2] Carrot\n[3] Potato\n[4] Rose\n[5] Tulips\n[6] Sunflower\n[7] Mango\n[8] Apple");
                        userInput2 = scan.nextInt();
                        scan.nextLine();
                        switch (userInput2)
                        {
                            case (1) -> farmer.buySeeds(TurnipSeed);
                            case (2) -> farmer.buySeeds(CarrotSeed);
                            case (3) -> farmer.buySeeds(PotatoSeed);
                            case (4) -> farmer.buySeeds(RoseSeed);
                            case (5) -> farmer.buySeeds(TulipsSeed);
                            case (6) -> farmer.buySeeds(SunflowerSeed);
                            case (7) -> farmer.buySeeds(MangoSeed);
                            case (8) -> farmer.buySeeds(AppleSeed);
                            default -> System.out.println("Invalid Input.");
                        }
                        break;
                    case (2):
                        System.out.println("Select which tool you would like to use: ");
                        System.out.println("[1] Plow Tool\n[2] Watering Can\n[3] Fertilizer\n[4] pickaxe\n[5] shovel");
                        userInput2 = scan.nextInt();
                        scan.nextLine();
                        switch (userInput2)
                        {
                            case (1):
                                if (farm.getTile().getIsPlowed())
                                {
                                    System.out.println("This tile is already plowed.");
                                } else
                                {
                                    System.out.println("This tile has been plowed.");
                                    farmer.useTool(PlowTool, farm.getTile());
                                }
                                break;
                            case (2):
                                if (!farm.getTile().getIsFarmed())
                                {
                                    System.out.println("There is no crop on this tile.");
                                } else if (farm.getTile().getTimesWateredToday() >= farm.getTile().getWaterBonusLimit())
                                {
                                    System.out.println("You have already watered this tile the maximum number of times");
                                } else
                                {
                                    System.out.println("This tile has been watered.");
                                    farmer.useTool(WateringCan, farm.getTile());
                                }
                                break;
                            case (3):
                                if (!farm.getTile().getIsFarmed())
                                {
                                    System.out.println("There is no crop on this tile.");
                                } else if (farm.getTile().getTimesFertilizedToday() >= farm.getTile().getFertilizerBonusLimit())
                                {
                                    System.out.println("You have already fertilized this tile the maximum number of times");
                                } else
                                {
                                    System.out.println("This tile has been fertilized.");
                                    farmer.useTool(Fertilizer, farm.getTile());
                                }
                                break;
                            case (4):
                                if (!farm.getTile().getIsRockPlaced())
                                {
                                    System.out.println("There is no rock on this tile");
                                } else
                                {
                                    System.out.println("The rock on this tile has been removed.");
                                    farmer.useTool(Pickaxe, farm.getTile());
                                }
                                break;
                            case (5):
                                if (farm.getTile().getIsFarmed() && farm.getTile().getIsWithered())
                                {
                                    System.out.println("The withered crop on this tile has been removed,");
                                    farmer.useTool(Shovel, farm.getTile());
                                }
                                else if (farm.getTile().getIsFarmed())
                                {
                                    System.out.println("The growing crop on this tile has been removed,");
                                    farmer.useTool(Shovel, farm.getTile());
                                } else
                                {
                                    System.out.println("There is nothing on this tile to shovel.");
                                }
                                break;
                            default:
                                System.out.println("Invalid input.");
                                break;
                        }
                        break;
                    case (3): //plant crops
                        if (farm.getTile().getIsFarmed() && farm.getTile().getIsWithered())
                        {
                            System.out.println("There is currently a withered crop on this tile.");
                        } else if (farm.getTile().getIsFarmed())
                        {
                            System.out.println("There is already a crop growing on this tile.");
                        } else if (farm.getTile().getIsRockPlaced())
                        {
                            System.out.println("There is currently a rock on this tile.");
                        } else if (!farm.getTile().getIsPlowed())
                        {
                            System.out.println("You cannot plant on unplowed tiles.");
                        } else
                        {
                            System.out.println("Select the seed you would like to plant on this tile");
                            System.out.println("[1] Turnip ("+ TurnipSeed.getAmount() + ")\n[2] Carrot  ("+ CarrotSeed.getAmount() + ")\n[3] Potato ("+ PotatoSeed.getAmount() + ")\n[4] Rose (" + RoseSeed.getAmount() + ")\n[5] Tulips (" + TulipsSeed.getAmount() + ")\n[6] Sunflower (" + SunflowerSeed.getAmount() + ")\n[7] Mango (" + MangoSeed.getAmount() +")\n[8] Apple ("+ AppleSeed.getAmount() + ")");
                            userInput2 = scan.nextInt();
                            scan.nextLine();
                            switch (userInput2) {
                                case (1) -> farmer.plantCrop(TurnipSeed, farm.getTile());
                                case (2) -> farmer.plantCrop(CarrotSeed, farm.getTile());
                                case (3) -> farmer.plantCrop(PotatoSeed, farm.getTile());
                                case (4) -> farmer.plantCrop(RoseSeed, farm.getTile());
                                case (5) -> farmer.plantCrop(TulipsSeed, farm.getTile());
                                case (6) -> farmer.plantCrop(SunflowerSeed, farm.getTile());
                                case (7) -> farmer.plantCrop(MangoSeed, farm.getTile());
                                case (8) -> farmer.plantCrop(AppleSeed, farm.getTile());
                                default -> System.out.println("Invalid Input.");
                            }
                        }
                        break;
                    case (4): //harvest crops
                        if (!farm.getTile().getIsFarmed())
                        {
                            System.out.println("There is nothing on this tile to harvest.");
                        } else if (farm.getTile().getIsWithered())
                        {
                            System.out.println("This crop is already withered and cannot be harvested");
                        } else if (!farm.getTile().getIsRipe())
                        {
                            System.out.println("This crop is not yet ready to be harvested");
                        }
                        else
                        {
                            System.out.println("The crop on this tile has been harvested");
                            farmer.harvestCrop(farm.getTile());
                        }
                        break;
                    case (5):
                        farmer.registerForHigherStatus(farm.getTile());
                        break;
                    case (6):
                        advanceDays(farm.getTile());
                        dayEnd = true;
                        break;
                    default:
                        System.out.println("Invalid option, try again.");
                        break;
                }
                farmer.levelUp();
            } while (!dayEnd);
            if (farm.getTile().getIsWithered())
            {
                gameRun=false;
                System.out.println("Crop wilted. Game over");
            } else if (farmer.getObjectCoin()<0)
            {
                gameRun=false;
                System.out.println("Out of money. Game over");
            } else if (!farm.getTile().getIsFarmed())
            {
                gameRun=false;
                System.out.println("No crops growing. Game over");
            } else {
                gameRun=true;
            }
        } while (gameRun);
    }
}
