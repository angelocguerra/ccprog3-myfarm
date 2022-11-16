/**
 * This class contains all tool details and actions
 */
public class Tool
{
    private final String name;
    private final int useCost;
    private final double experienceYield;

    /**
     * Constructor for Tool Class
     * @param name Tool Name
     * @param useCost Cost to use the tool
     * @param experienceYield Amount of experience earned from using the tool
     */
    public Tool(String name, int useCost, double experienceYield)
    {
        this.name = name;
        this.useCost = useCost;
        this.experienceYield = experienceYield;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the details of a tool's name
     * @return The name of the tool
     */
    public String getName()
    {
        return name;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the use cost details of a tool
     * @return The cost to use the tool
     */
    public int getUseCost()
    {
        return useCost;
    }

    /**
     * Purpose: This getter method allows the program to retrieve and access the experience yield details of a tool
     * @return The amount of experience earned from using a tool
     */
    public double getExperienceYield()
    {
        return experienceYield;
    }
}