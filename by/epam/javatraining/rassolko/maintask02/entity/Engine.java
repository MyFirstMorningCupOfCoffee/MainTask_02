package by.epam.javatraining.rassolko.entity;

public class Engine 
{
    public static enum Type { JET, TURBOPROP, NOT_DEFINED };
    
    
    private Engine.Type type;
    private String model;
    private String number;
    //private Fuel.FuelType fuel;

    public Engine(Type type, String model)
    {
        this.type = type;
        this.model = model;
    }

    public Engine()
    {
    }
    
    
    /**
     * @return the type
     */
    public Engine.Type getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Engine.Type type)
    {
        this.type = type;
    }

    /**
     * @return the model
     */
    public String getModel()
    {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model)
    {
        this.model = model;
    }

    /**
     * @return the number
     */
    public String getNumber()
    {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number)
    {
        this.number = number;
    }

}
