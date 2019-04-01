package by.epam.javatraining.rassolko.maintask02.model.entity;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class FuelNGTest
{
    
    public FuelNGTest()
    {
    }

    @Test
    public void testGetFuelWeight()
    {
        double expected = 0.81 * 20;
        double actual = Fuel.getFuelWeight(Fuel.Type.AVIATION_TURBINE_FUEL, 20);
        assertEquals(actual, expected);
    }

    @Test
    public void testParseType()
    {
        String typeAsString = "AVIATION_TURBINE_FUEL";
        Fuel.Type result = Fuel.parseType(typeAsString);
        assertEquals(result, Fuel.Type.AVIATION_TURBINE_FUEL);
    }
    
}
