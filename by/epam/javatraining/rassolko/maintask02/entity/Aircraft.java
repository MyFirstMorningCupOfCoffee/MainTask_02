package by.epam.javatraining.rassolko.entity;

public abstract class Aircraft 
{
    private String model;
    private String name;
    private String number;
    private double baseWeight;
    private double payload;
    

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
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

    /**
     * @return the baseWeight
     */
    public double getBaseWeight()
    {
        return baseWeight;
    }

    /**
     * @param baseWeight the baseWeight to set
     */
    public void setBaseWeight(double baseWeight)
    {
        this.baseWeight = baseWeight;
    }


    /**
     * @return the payload
     */
    public double getPayload()
    {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(double payload)
    {
        this.payload = payload;
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

}
