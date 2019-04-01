package by.epam.javatraining.rassolko.maintask02.entity;

// Represents single fuel type storage used in airport
public class AirportFuelStorage 
{
    private Fuel.Type type;
    private double capacity;
    private double quantity;

    public AirportFuelStorage()
    {
        
    }

    public AirportFuelStorage(Fuel.Type type, double capacity)
    {
        this.type = type;
        this.capacity = capacity;
    }
    
    
    /**
     * @return the type
     */
    public Fuel.Type getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Fuel.Type type)
    {
        this.type = type;
    }

    /**
     * @return the quantity
     */
    public double getQuantity()
    {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity)
    {
        this.quantity = quantity;
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
    
}
