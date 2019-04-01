package by.epam.javatraining.rassolko.maintask02.entity;

import by.epam.javatraining.rassolko.maintask02.entity.aircrafts.PassengerAirliner;
import by.epam.javatraining.rassolko.maintask02.utils.AircraftCreator;
import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class AirportNGTest
{
    
    public AirportNGTest()
    {
    }

    @Test
    public void testRequestRefuelingTrue()
    {
        Airport ap = new Airport();
        AirportFuelStorage afs1 = new AirportFuelStorage(Fuel.Type.AVIATION_TURBINE_FUEL, 200);
        afs1.setQuantity(100);
        AirportFuelStorage afs2 = new AirportFuelStorage(Fuel.Type.BIOFUEL, 300);
        afs2.setQuantity(200);
        
        ap.getLocalFuelTanks().add(afs1);
        ap.getLocalFuelTanks().add(afs2);
        
        PassengerAirliner liner = AircraftCreator.createPassengerAirliner("AN-3");
        boolean responce = ap.requestRefueling(liner, 100);
        assertEquals(responce, true);
    }
    
    @Test
    public void testRequestRefuelingFalse()
    {
        Airport ap = new Airport();
        AirportFuelStorage afs1 = new AirportFuelStorage(Fuel.Type.AVIATION_SPIRIT, 200);
        afs1.setQuantity(100);
        AirportFuelStorage afs2 = new AirportFuelStorage(Fuel.Type.BIOFUEL, 300);
        afs2.setQuantity(200);
        
        ap.getLocalFuelTanks().add(afs1);
        ap.getLocalFuelTanks().add(afs2);
        
        PassengerAirliner liner = AircraftCreator.createPassengerAirliner("AN-3");
        boolean responce = ap.requestRefueling(liner, 100);
        assertEquals(responce, false);
    }

    
}
