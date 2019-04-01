package by.epam.javatraining.rassolko.maintask02.entity.aircrafts;

import by.epam.javatraining.rassolko.maintask02.collections.Storage;
import org.apache.log4j.Logger;

public class Aerostat extends Aircraft
{    
    public enum Type
    {
        GAS,
        THERMAL,
        VACUUM,
        HYBRID,
        NOT_DEFINED
    }
    
    private static final Logger LOGGER;
    // Some type of aerostats can be navigated
    private boolean navigable;
    // Some type of aerostats need special docks to land
    private boolean specialDockRequired;
    private Type type;
    
    static
    {
        LOGGER = Logger.getLogger("Aerostat");
    }

    public Aerostat()
    {
       this.type = Type.NOT_DEFINED;
    }
    
    public Aerostat(Type type, boolean navigable, boolean specialDockRequired)
    {
       this.type = type;
       this.navigable = navigable;
       this.specialDockRequired = specialDockRequired;
    }
    
    
    @Override
    public double calcFreeCargoWeight()
    {
        return this.getPayload() - this.getCargoWeight();
    }
    
    // Parsing type of Aerostat from given source String
    // If something goes wrong, NOT_DEFINED type will be returned
    public static Aerostat.Type parseType(String source)
    {
        Aerostat.Type responce = Type.NOT_DEFINED;
        
        try
        {
            responce = Aerostat.Type.valueOf(source);
        }
        catch(IllegalArgumentException ex)
        {
            LOGGER.error("Can't parse Aerostat type (" + source + ")", ex);
        }
        
        return responce;
    }
    
    /**
     * @return the navigable
     */
    public boolean isNavigable()
    {
        return navigable;
    }

    /**
     * @param navigable the navigable to set
     */
    public void setNavigable(boolean navigable)
    {
        this.navigable = navigable;
    }

    /**
     * @return the type
     */
    public Aerostat.Type getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Aerostat.Type type)
    {
        this.type = type;
    }
    
    /**
     * @return the specialDockRequired
     */
    public boolean isSpecialDockRequired()
    {
        return specialDockRequired;
    }

    /**
     * @param specialDockRequired the specialDockRequired to set
     */
    public void setSpecialDockRequired(boolean specialDockRequired)
    {
        this.specialDockRequired = specialDockRequired;
    }
    
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("Number: ").append(getNumber()).append(" | ");
        result.append("Name: ").append(getName()).append(" | ");
        result.append("State: ").append(getState()).append(" | ");
        
        return result.toString(); 
    }
    
    
    
}
