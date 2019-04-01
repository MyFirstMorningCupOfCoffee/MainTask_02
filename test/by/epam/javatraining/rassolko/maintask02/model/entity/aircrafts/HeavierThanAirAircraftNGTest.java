package by.epam.javatraining.rassolko.maintask02.model.entity.aircrafts;

import by.epam.javatraining.rassolko.maintask02.model.entity.Fuel;
import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class HeavierThanAirAircraftNGTest
{
    
    public HeavierThanAirAircraftNGTest()
    {
    }

    @Test
    public void testRefuelTrue()
    {
        HeavierThanAirAircraft aircraft = new CargoAirliner();
        aircraft.setFuelCapacity(200);
        
        assertEquals(aircraft.refuel(100), true);
    }
    
    @Test
    public void testRefuelFalse()
    {
        HeavierThanAirAircraft aircraft = new CargoAirliner();
        aircraft.setFuelCapacity(200);
        
        assertEquals(aircraft.refuel(800), false);
    }

    @Test
    public void testSpendFuelTrue()
    {
        HeavierThanAirAircraft aircraft = new CargoAirliner();
        aircraft.setFuelCapacity(200);
        aircraft.refuel(100);
        
        assertEquals(aircraft.spendFuel(50), true);
    }
    
    @Test
    public void testSpendFuelFalse()
    {
        HeavierThanAirAircraft aircraft = new CargoAirliner();
        aircraft.setFuelCapacity(200);
        aircraft.refuel(100);
        
        assertEquals(aircraft.spendFuel(5000), false);
    }
    
    @Test
    public void testSpendFuelQuantityCheck()
    {
        HeavierThanAirAircraft aircraft = new CargoAirliner();
        aircraft.setFuelCapacity(200);
        aircraft.refuel(100);
        aircraft.spendFuel(50);
                
        assertEquals(aircraft.getFuelQuantity(), 100.0 - 50.0);
    }

    @Test
    public void testCalcFuelRequired()
    {
        HeavierThanAirAircraft aircraft = new CargoAirliner();
        aircraft.setFuelCapacity(200);
        aircraft.refuel(50);
        
        double expected = 150;
        
        assertEquals(aircraft.calcFuelRequired(), expected);
    }

    @Test
    public void testCalcFreeCargoWeight()
    {
        HeavierThanAirAircraft aircraft = new CargoAirliner();
        aircraft.setPayload(10000);
        aircraft.setFuelType(Fuel.Type.AVIATION_SPIRIT);
        aircraft.setFuelCapacity(1000);
        aircraft.refuel(1000);
        aircraft.setCargoWeight(3000);
        
        double expected = 10000 - 1000 * 0.72 - 3000;
        
        assertEquals(aircraft.calcFreeCargoWeight(), expected);
    }

    
    
}
