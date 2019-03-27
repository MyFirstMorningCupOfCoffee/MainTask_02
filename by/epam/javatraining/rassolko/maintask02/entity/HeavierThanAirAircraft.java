package by.epam.javatraining.rassolko.entity;

import by.epam.javatraining.rassolko.collections.Storage;

public class HeavierThanAirAircraft extends Aircraft
{
    private Storage<Engine> engines;
    private Storage<FuelTank> fuelTanks;
    private int maxRange;
    
    private Fuel.Type fuel;
    //private double fuelConsumption;

    public HeavierThanAirAircraft()
    {
        engines = new Storage<>();
        fuelTanks = new Storage<>();
    }
    
    public double getFuelCapacity()
    {
        double responce = 0;
        for(int i = 0; i < fuelTanks.size(); i++)
        {
            responce += fuelTanks.get(i).getCapacity();
        }
        
        return responce;
    }
    
    public double getFuelFilled()
    {
        double responce = 0;
        for(int i = 0; i < fuelTanks.size(); i++)
        {
            responce += fuelTanks.get(i).getFilled();
        }
        
        return responce; 
    }
    
    public double calcFuelRequired()
    {        
        return getFuelCapacity() - getFuelFilled();
    }
    
    

    /**
     * @return the engines
     */
    public Storage<Engine> getEngines()
    {
        return engines;
    }

    /**
     * @param engines the engines to set
     */
    public void setEngines(Storage<Engine> engines)
    {
        this.engines = engines;
    }

    /**
     * @return the fuelTanks
     */
    public Storage<FuelTank> getFuelTanks()
    {
        return fuelTanks;
    }

    /**
     * @param fuelTanks the fuelTanks to set
     */
    public void setFuelTanks(Storage<FuelTank> fuelTanks)
    {
        this.fuelTanks = fuelTanks;
    }

    /**
     * @return the fuel
     */
    public Fuel.Type getFuelType()
    {
        return fuel;
    }

    /**
     * @param fuel the fuel to set
     */
    public void setFuelType(Fuel.Type fuel)
    {
        this.fuel = fuel;
    }

    /**
     * @return the maxRange
     */
    public int getMaxRange()
    {
        return maxRange;
    }

    /**
     * @param maxRange the maxRange to set
     */
    public void setMaxRange(int maxRange)
    {
        this.maxRange = maxRange;
    }
    
}
