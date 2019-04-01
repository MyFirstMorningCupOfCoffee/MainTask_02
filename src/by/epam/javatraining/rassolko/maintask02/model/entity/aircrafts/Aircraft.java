package by.epam.javatraining.rassolko.maintask02.model.entity.aircrafts;

import by.epam.javatraining.rassolko.maintask02.model.entity.Airport;

public abstract class Aircraft 
{
    private String model;
    private String name;
    private String number;
    private double baseWeight;
    private double payload;
    private double cargoWeight; 
    
    private State state;
    private Airport destinationPoint;
    private Airport departurePoint;
    
    public enum State
    {
        WAITING_FOR_LANDING_PERMISSION,
        LANDING,
        LANDED,
        HANGARED,
        
        WAITING_FOR_FLY_PERMISSION,
        TAKING_OFF,
        FLYING,
        
        UNKNOWN
    }
    
    {
        state = State.UNKNOWN;
        name = "N/A";
        number = "N/A";
    }
    
    
    public abstract double calcFreeCargoWeight();

    /**
     * @return the destinationPoint
     */
    public Airport getDestinationPoint()
    {
        return destinationPoint;
    }

    /**
     * @param destinationPoint the destinationPoint to set
     */
    public void setDestinationPoint(Airport destinationPoint)
    {
        this.destinationPoint = destinationPoint;
    }

    /**
     * @return the departurePoint
     */
    public Airport getDeparturePoint()
    {
        return departurePoint;
    }

    /**
     * @param departurePoint the departurePoint to set
     */
    public void setDeparturePoint(Airport departurePoint)
    {
        this.departurePoint = departurePoint;
    }

    /**
     * @return the cargoWeight
     */
    public double getCargoWeight()
    {
        return cargoWeight;
    }

    /**
     * @param cargoWeight the cargoWeight to set
     */
    public void setCargoWeight(double cargoWeight)
    {
        this.cargoWeight = cargoWeight;
    }


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
    
    /**
     * @return the state
     */
    public State getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state)
    {
        this.state = state;
    }

}
