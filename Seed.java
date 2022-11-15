public class Seed {
    private int amount;
    private final Crop crop;

    public Seed (Crop crop){
        this.amount = 0;
        this.crop = crop;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Crop getCrop() {
        return crop;
    }
}