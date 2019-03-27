package by.epam.javatraining.rassolko.entity;

public class Fuel 
{
    private Fuel()
    {
        // not allowed
    }
    
    public enum Type 
    { 
        AVIATION_TURBINE_FUEL, 
        AVIATION_SPIRIT, 
        BIOFUEL, 
        LIQUIFIED_NATURAL_GAS, 
        COMPRESSED_NATURAL_GAS,
        NOT_DEFINED
    }
    
    public double getFuelWeight(Type type, double litre)
    {
        double density = 0;
        switch(type)
        {
            case AVIATION_TURBINE_FUEL:
            {
                density = 0.81;
                break;
            }
            case AVIATION_SPIRIT:
            {
                density = 0.72;
                break;
            }
            case BIOFUEL:
            {
                density = 0.92;
                break;
            }
            case LIQUIFIED_NATURAL_GAS:
            {
                density = 0.46;
                break;
            }
            case COMPRESSED_NATURAL_GAS:
            {
                density = 0.18;
                break;
            }      
        }
        
        return litre * density;
    }

}
