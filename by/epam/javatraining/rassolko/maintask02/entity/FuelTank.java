package by.epam.javatraining.rassolko.entity;

public class FuelTank 
{
    public static enum Type { EXTERNAL, INTERNAL };
    
    private FuelTank.Type type;
    private double capacity;
    private double filled;

    public FuelTank(Type type, double capacity)
    {
        this.type = type;
        this.capacity = capacity;
    }
    

    public FuelTank()
    {
    }

    
    /**
     * @return the type
     */
    public FuelTank.Type getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(FuelTank.Type type)
    {
        this.type = type;
    }
    
    /**
     * @return the capacity
     */
    public double getCapacity()
    {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(double capacity)
    {
        this.capacity = capacity;
    }

    /**
     * @return the filled
     */
    public double getFilled()
    {
        return filled;
    }

    /**
     * @param filled the filled to set
     */
    public void setFilled(double filled)
    {
        this.filled = filled;
    }
}
