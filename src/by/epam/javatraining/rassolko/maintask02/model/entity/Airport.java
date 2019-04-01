package by.epam.javatraining.rassolko.maintask02.model.entity;

import by.epam.javatraining.rassolko.maintask02.model.entity.aircrafts.Aircraft;
import by.epam.javatraining.rassolko.maintask02.collections.Storage;
import by.epam.javatraining.rassolko.maintask02.model.entity.aircrafts.HeavierThanAirAircraft;

public class Airport 
{
    private String name;
    private String id;
    private Location location;
    
    // Can be used to store aircrafts that are situated in space that is controlled
    // by this Airport. Not used in current build
    private Storage<Aircraft> dispatchedAircrafts;
    
    // List of all airport, common resource, availible 1 for all airports.
    // Can be used in further versions to calculate distance between destination 
    // and departure points. Not used in current build
    private Storage<Airport>  airportsList;
    
    // Runway is reqired for landing and lifting planes. Heavy machines require
    // longer runway to use
    private int runwayLength;
    
    private Storage<AirportFuelStorage> localFuelTanks;

    
    {
        dispatchedAircrafts = new Storage<>();
        localFuelTanks = new Storage<>();
    }
    
    public Airport()
    {
        
    }
    
    public Airport(String name)
    {
        this.name = name;
    }
    
    // This thing emulates airport part of taking descision to refuel or not.
    // IRL refueling request will be processed in another way, not by air transfer company,
    // but by airport where aircraft is situated and involve money transition.
    // Refuel will be denied if airport does not have enough of fuel of particulat type
    // or aircraft does not have enough empty space for requested quantity of fuel
    public boolean requestRefueling(HeavierThanAirAircraft aircraft, double quantity)
    {
        for(int i = 0; i < localFuelTanks.size(); i++)
        {
            if(localFuelTanks.get(i).getType() == aircraft.getFuelType())
            {
                if(localFuelTanks.get(i).getQuantity() >= quantity)
                {
                    if(aircraft.refuel(quantity))
                    {
                        localFuelTanks.get(i).setQuantity(
                            localFuelTanks.get(i).getQuantity() - quantity);
                        
                        return true;
                    }
                }
            }
        }
        
        return false;
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
     * @return the dispatchedAircrafts
     */
    public Storage<Aircraft> getDispatchedAircrafts()
    {
        return dispatchedAircrafts;
    }

    /**
     * @param dispatchedAircrafts the dispatchedAircrafts to set
     */
    public void setDispatchedAircrafts(Storage<Aircraft> dispatchedAircrafts)
    {
        this.dispatchedAircrafts = dispatchedAircrafts;
    }

    /**
     * @return the airportsList
     */
    public Storage<Airport> getAirportsList()
    {
        return airportsList;
    }

    /**
     * @param airportsList the airportsList to set
     */
    public void setAirportsList(Storage<Airport> airportsList)
    {
        this.airportsList = airportsList;
    }

    /**
     * @return the localFuelTanks
     */
    public Storage<AirportFuelStorage> getLocalFuelTanks()
    {
        return localFuelTanks;
    }

    /**
     * @param localFuelTanks the localFuelTanks to set
     */
    public void setLocalFuelTanks(Storage<AirportFuelStorage> localFuelTanks)
    {
        this.localFuelTanks = localFuelTanks;
    }

    /**
     * @return the location
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }

    /**
     * @return the runwayLength
     */
    public int getRunwayLength()
    {
        return runwayLength;
    }

    /**
     * @param runwayLength the runwayLength to set
     */
    public void setRunwayLength(int runwayLength)
    {
        this.runwayLength = runwayLength;
    }

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("[").append(getName()).append("]");
        result.append(" (").append(getLocation()).append(")");
        
        return result.toString();
    }

    

    

}
