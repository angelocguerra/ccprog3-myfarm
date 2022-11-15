public class Tool {
    private final String name;
    private final int useCost;
    private final double experienceYield;

    public Tool(String name, int useCost, double experienceYield)
    {
        this.name = name;
        this.useCost = useCost;
        this.experienceYield = experienceYield;
    }

    public String getName() {
        return name;
    }

    public int getUseCost() {
        return useCost;
    }

    public double getExperienceYield() {
        return experienceYield;
    }
}