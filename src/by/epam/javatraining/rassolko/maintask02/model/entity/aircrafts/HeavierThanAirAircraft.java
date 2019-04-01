package by.epam.javatraining.rassolko.maintask02.model.entity.aircrafts;

import by.epam.javatraining.rassolko.maintask02.model.entity.Fuel;
import by.epam.javatraining.rassolko.maintask02.model.entity.Engine;

public abstract class HeavierThanAirAircraft extends Aircraft
{
    private double fuelCapacity;
    private double fuelQuantity;
    private double fuelWeight;
    
    private int maxRange;
    
    private Fuel.Type fuel;
    private Engine.Type engine;
    private int enginesQuantity;

    {
        fuel = Fuel.Type.NOT_DEFINED;
        engine = Engine.Type.NOT_DEFINED;
    }

    // Refuel aircraft if it has enough empty space for requested fuel quantity
    public boolean refuel(double fuelQuantity)
    {
        if(calcFuelRequired() >= fuelQuantity)
        {
            setFuelQuantity(this.fuelQuantity + fuelQuantity);
            return true;
        }
        
        return false;
    }
    
    // Decreases fuel quantity in aircraft tank if requested value is <= than
    // fuel stored in aircraft tank
    public boolean spendFuel(double fuelQuantity)
    {
        if(this.fuelQuantity >= fuelQuantity)
        {
            setFuelQuantity(this.fuelQuantity - fuelQuantity);
            return true;
        }
        
        return false;
    }
    
    // Calculates empty space in aircraft fuel tank
    public double calcFuelRequired()
    {        
        return getFuelCapacity() - getFuelQuantity();
    }
    
    // calculate how much cargo can be taken aboard
    // negative value means that some cargo needs to be removed from aircraft
    @Override
    public double calcFreeCargoWeight()
    {
        return getPayload() - getCargoWeight() - getFuelWeight();
    }
    
    /**
     * @return fuel type
     */
    public Fuel.Type getFuelType()
    {
        return fuel;
    }

    /**
     * @param fuel fuel type to set
     */
    public void setFuelType(Fuel.Type fuel)
    {
        this.fuel = fuel;
    }

    /**
     * @return max flight range
     */
    public int getMaxRange()
    {
        return maxRange;
    }

    /**
     * @param maxRange max flight range to set
     */
    public void setMaxRange(int maxRange)
    {
        this.maxRange = maxRange;
    }

    /**
     * @return fuel capacity
     */
    public double getFuelCapacity()
    {
        return fuelCapacity;
    }

    /**
     * @param fuelCapacity fuel capacity to set
     */
    public void setFuelCapacity(double fuelCapacity)
    {
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * @return fuel quantity in aircraft fuel tank
     */
    public double getFuelQuantity()
    {
        return fuelQuantity;
    }

    /**
     * @param fuelQuantity fuel quantity in aircraft fuel tank to set
     */
    public void setFuelQuantity(double fuelQuantity)
    {
        this.fuelQuantity = fuelQuantity;
        this.fuelWeight = Fuel.getFuelWeight(this.fuel, this.fuelQuantity);
    }

    /**
     * @return engine type
     */
    public Engine.Type getEngineType()
    {
        return engine;
    }

    /**
     * @param engine engine type to set
     */
    public void setEngineType(Engine.Type engine)
    {
        this.engine = engine;
    }

    /**
     * @return the engines quantity
     */
    public int getEnginesQuantity()
    {
        return enginesQuantity;
    }

    /**
     * @param enginesQuantity engines quantity to set
     */
    public void setEnginesQuantity(int enginesQuantity)
    {
        this.enginesQuantity = enginesQuantity;
    }

    /**
     * @return fuel weight
     */
    public double getFuelWeight()
    {
        return fuelWeight;
    }
    
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("Number: ").append(getNumber()).append(" | ");
        result.append("Name: ").append(getName()).append(" | ");
        result.append("State: ").append(getState()).append(" | ");
        
        if(getState() == Aircraft.State.FLYING 
                || getState() == Aircraft.State.LANDING
                || getState() == Aircraft.State.TAKING_OFF
                || getState() == Aircraft.State.WAITING_FOR_LANDING_PERMISSION
                || getState() == Aircraft.State.WAITING_FOR_FLY_PERMISSION)
        {
            result.append("Departure: ").append(getDeparturePoint()).append(" | ");
            result.append("Destination: ").append(getDestinationPoint()).append(" | ");
        }
        else
        {
            result.append("Location: ").append(getDestinationPoint()).append(" | ");
        }
        result.append("Fuel: ").append(getFuelQuantity()).append(" / ")
              .append(getFuelCapacity());
        
        return result.toString(); 
    }
    
}
