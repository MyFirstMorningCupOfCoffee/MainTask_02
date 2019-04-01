package by.epam.javatraining.rassolko.maintask02.model.logic;

import by.epam.javatraining.rassolko.maintask02.model.entity.Fuel;
import by.epam.javatraining.rassolko.maintask02.model.entity.AirportFuelStorage;
import by.epam.javatraining.rassolko.maintask02.collections.Storage;
import by.epam.javatraining.rassolko.maintask02.model.entity.Airport;
import by.epam.javatraining.rassolko.maintask02.model.entity.Location;
import org.apache.log4j.Logger;

// Emulates work with properly built database
public class AirportsDatabaseWorker 
{
    private static final String XMLR_DATABASE_FILEPATH = "D:\\Users\\Александр\\Desktop\\airports.xmlr";
    private static final Logger LOGGER;
    
    private AirportsDatabaseWorker()
    {
        // not allowed
    }
    
    private static Storage<Airport> airports;
   
    static
    {
        LOGGER = Logger.getLogger("AirportsDatabaseWorker");
        initObjects();
    }
    
    // Tries to get proper airport by name from airports list
    // Ruturns null (I know, there should be exception, but we didn't learn em)
    // if search is failed
    public static Airport getAirportByName(String name)
    {
        Airport responce = null;
        
        for(int i = 0; i < airports.size(); i++)
        {
            if(airports.get(i).getName().equals(name))
            {
                responce = airports.get(i);
                break;
            }
        }
        
        LOGGER.info("Requested Airport object, by name = " + name);
        LOGGER.info(responce + " gotten as responce");
        
        return responce;
    }
    
    // Tries to get proper airport by id from airports list
    // Ruturns null (I know, there should be exception, but we didn't learn em)
    // if search is failed
    public static Airport getAirportById(String id)
    {
        Airport responce = null;
        
        if(airports == null)
        {
            initObjects();
        }
        
        for(int i = 0; i < airports.size(); i++)
        {
            if(airports.get(i).getId().equals(id))
            {
                responce = airports.get(i);
                break;
            }
        }
        
        LOGGER.info("Requested Airport object, by id = " + id);
        LOGGER.info(responce + " gotten as responce");
        
        return responce;
    }
    
    public static Storage<Airport> getAirportList()
    {
        return airports;
    }
    
    // Used to init airports list from file database
    // Storage<String> holds String xmlr pieces, 1 for each airport
    private static Storage<String> getElements()
    {
        String source = FileWorker.readFile(XMLR_DATABASE_FILEPATH);
        Storage<String> elements = XMLRWorker.collectItems(source, "airport");
        
        return elements;
    }

    // Used to init airports list, parsing elements via XMLRWorker 
    private static void initObjects()
    {
        airports = new Storage<>();
        
        Storage<String> elements = getElements();
        
        for(int i = 0; i < elements.size(); i++)
        {
            String element = elements.get(i);
            
            Airport airport = new Airport();
            airport.setName(XMLRWorker.getContent(element, "name"));
            airport.setId(XMLRWorker.getContent(element, "id"));
            
            Location location = new Location();
            location.setLatitude(
                    parseDouble(
                    XMLRWorker.getContent(element, "location", "latitude")));
            location.setLongitude(
                    parseDouble(
                    XMLRWorker.getContent(element, "location", "longitude")));
            airport.setLocation(location);
            
            Storage<AirportFuelStorage> airportFuel = new Storage<>();
            
            airport.setRunwayLength(
                    parseInt(
                    XMLRWorker.getContent(element, "runway_length")));
            
            //// reading fuel part
            int fuelTypesQuantity = Fuel.Type.values().length - 1;
            for(int j = 0; j < fuelTypesQuantity; j++)
            {
                Fuel.Type fuelType = Fuel.Type.values()[j];
                String fuelTypeName = fuelType.name().toLowerCase();
                
                AirportFuelStorage singleStorage = new AirportFuelStorage();
                singleStorage.setType(fuelType);
                
                double capacity;
                capacity = parseDouble(
                        XMLRWorker.getContent(element, "fuel", fuelTypeName, "capacity"));
                double quantity;
                quantity = parseDouble(
                        XMLRWorker.getContent(element, "fuel", fuelTypeName, "quantity"));
                singleStorage.setCapacity(capacity);
                singleStorage.setQuantity(quantity);
                airportFuel.add(singleStorage);
            }
            airport.setLocalFuelTanks(airportFuel);
            airport.setAirportsList(airports);
            airports.add(airport);
            ////
            
            
        }
        
        LOGGER.info("initializing airports list");
    }
    
    // Updates airports list if requested
    public void updateList()
    {
        initObjects();
    }
    
    
    // Parse double value from String source
    // If source is empty ( == "") returns 0
    private static double parseDouble(String source)
    {
        double responce = 0;
        if(source.length() != 0)
        {
            responce = Double.parseDouble(source);
        }
        
        return responce;
    }
    
    // Parse int value from String source
    // If source is empty ( == "") returns 0
    private static int parseInt(String source)
    {
        int responce = 0;
        if(source.length() != 0)
        {
            responce = Integer.parseInt(source);
        }
        
        return responce;
    }
}
