package by.epam.javatraining.rassolko.maintask02.controller;

import by.epam.javatraining.rassolko.maintask02.entity.aircrafts.Aircraft;
import by.epam.javatraining.rassolko.maintask02.entity.aircrafts.PassengerAirliner;
import by.epam.javatraining.rassolko.maintask02.utils.AirportsDatabaseWorker;
import by.epam.javatraining.rassolko.maintask02.entity.Airport;
import by.epam.javatraining.rassolko.maintask02.utils.AircraftCreator;
import org.apache.log4j.Logger;

public class Main 
{
    private static final Logger LOGGER;
    
    static
    {
        LOGGER = Logger.getLogger("SystemOutput");
    }

    public static void main(String[] args)
    {

        LOGGER.info("< Creating 2 Airport objects, getting parameters from airports database >");
                
        Airport ap157 = AirportsDatabaseWorker.getAirportById("157");
        Airport ap158 = AirportsDatabaseWorker.getAirportById("158");
        
        LOGGER.info(ap157);
        LOGGER.info(ap158);

        
        LOGGER.info("< Creating an Aircraft object, getting parameters from aircraft database >");
        PassengerAirliner liner1 = AircraftCreator.createPassengerAirliner("AN-2");
        liner1.setName("FireFly");
        liner1.setNumber("8330000");
        
        LOGGER.info("< Plane is situated in airport " + ap157 + " >");
        liner1.setState(Aircraft.State.HANGARED);
        liner1.setDestinationPoint(ap157);
        liner1.setDeparturePoint(ap157);
        LOGGER.info(liner1);
        
        LOGGER.info("< Refueling and loading cargo >");
        LOGGER.info("fuel required: " + liner1.calcFuelRequired());
        LOGGER.info("free cargo weight: " + liner1.calcFreeCargoWeight());
        LOGGER.info("< Requesting refuel (200 litres), request accepted >");
        ap157.requestRefueling(liner1, 200);
        LOGGER.info("fuel required: " + liner1.calcFuelRequired());
        LOGGER.info("free cargo weight: " + liner1.calcFreeCargoWeight());
        LOGGER.info("< Adding some cargo (800 kg) >");
        liner1.setCargoWeight(800);
        LOGGER.info("free cargo weight: " + liner1.calcFreeCargoWeight());
        
        LOGGER.info("< Plane is ready to fly >");
        LOGGER.info(liner1);
        LOGGER.info("< Switching to \"waiting for fly permission\" status >");
        liner1.setState(Aircraft.State.WAITING_FOR_FLY_PERMISSION);
        liner1.setDestinationPoint(ap158);
        LOGGER.info(liner1);
        
        LOGGER.info("< Plane got fly permission >");
        liner1.setState(Aircraft.State.TAKING_OFF);
        liner1.spendFuel(3);
        LOGGER.info(liner1);
        
        LOGGER.info("< Plane is flying to destination point >");
        liner1.setState(Aircraft.State.FLYING);
        liner1.spendFuel(2);
        LOGGER.info(liner1);
        
        LOGGER.info("< Arriving to destination point... >");
        liner1.setState(Aircraft.State.WAITING_FOR_LANDING_PERMISSION);
        liner1.spendFuel(103);
        LOGGER.info(liner1);
        
        LOGGER.info("< Landing... >");
        liner1.setState(Aircraft.State.LANDING);
        liner1.spendFuel(4);
        LOGGER.info(liner1);
        
        LOGGER.info("< Landed... >");
        liner1.setState(Aircraft.State.LANDED);
        liner1.spendFuel(7);
        LOGGER.info(liner1);
        
        LOGGER.info("< Parked in hangar >");
        liner1.setState(Aircraft.State.HANGARED);
        liner1.spendFuel(1);
        LOGGER.info(liner1);
        
    }

}
