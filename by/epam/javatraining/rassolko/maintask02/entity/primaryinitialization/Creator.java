package by.epam.javatraining.rassolko.entity.primaryinitialization;

import by.epam.javatraining.rassolko.collections.Storage;
import by.epam.javatraining.rassolko.entity.*;
import by.epam.javatraining.rassolko.utils.DatabaseWorker;
import by.epam.javatraining.rassolko.utils.FileWorker;
import by.epam.javatraining.rassolko.utils.XMLRWorker;

public class Creator 
{
    public static PassengerAirliner createPassengerAirliner(String model)
    {
        PassengerAirliner aircraft = new PassengerAirliner();
        initAircraftPart(model, aircraft);
        initHeavierThanAirAircraftPart(model, aircraft);
        initPlanePart(model, aircraft);
        initPassengerAirlinerPart(model, aircraft);

        return aircraft;
    }
    
    public static CargoAirliner createCargoAirliner(String model)
    {
        CargoAirliner aircraft = new CargoAirliner();
        initAircraftPart(model, aircraft);
        initHeavierThanAirAircraftPart(model, aircraft);
        initPlanePart(model, aircraft);
        initCargoAirlinerPart(model, aircraft);

        return aircraft;
    }
    
    public static Helicopter createHelicopter(String model)
    {
        Helicopter aircraft = new Helicopter();
        initAircraftPart(model, aircraft);
        initHeavierThanAirAircraftPart(model, aircraft);
        initHelicopterPart(model, aircraft);

        return aircraft;
    }
    
    private static void initAircraftPart(String model, Aircraft aircraft)
    {
        aircraft.setModel(model);
        
        String param;
        
        param = DatabaseWorker.getValue(model, "baseweight");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            aircraft.setBaseWeight( Double.parseDouble(param) );
        }
        
        param = DatabaseWorker.getValue(model, "payload");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            aircraft.setPayload( Double.parseDouble(param) );
        }
        
        //return aircraft;
    }
    
    private static void initHeavierThanAirAircraftPart(String model, HeavierThanAirAircraft aircraft)
    {
        String param;
        
        //// start of big work on engines init ////
        int enginesQuantity = 0;
        Engine.Type enginesType = Engine.Type.NOT_DEFINED;
        String enginesModel = "";
        param = DatabaseWorker.getValue(model, "engines", "quantity");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            enginesQuantity = Integer.parseInt(param);
        }
        param = DatabaseWorker.getValue(model, "engines", "type");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            enginesType = Engine.Type.valueOf(param);
        }
        param = DatabaseWorker.getValue(model, "engines", "model");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            enginesModel = param;
        }
        
        Storage<Engine> engines = new Storage<>();
        for(int i = 0; i < enginesQuantity; i++)
        {
            Engine engine = new Engine(enginesType, enginesModel);
            engines.add(engine);
        }
        aircraft.setEngines(engines);
        //// end of big work on engines init ////
        
        //// start of work on fuel tanks ////
        int tanksQuantity = 0;
        double tankCapacity = 0;
        
        param = DatabaseWorker.getValue(model, "fueltanks", "quantity");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            tanksQuantity = Integer.parseInt(param);
        }
        param = DatabaseWorker.getValue(model, "fueltanks", "capacity");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            tankCapacity = Double.parseDouble(param);
        }
        Storage<FuelTank> tanks = new Storage<>();
        for(int i = 0; i < tanksQuantity; i++)
        {
            FuelTank tank = new FuelTank(FuelTank.Type.INTERNAL, tankCapacity);
            tanks.add(tank);
        }
        aircraft.setFuelTanks(tanks);
        //// end of work on fuel tanks ////
        
        param = DatabaseWorker.getValue(model, "range");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            aircraft.setMaxRange( Integer.parseInt(param) );
        }
        
        Fuel.Type fType = Fuel.Type.NOT_DEFINED;
        param = DatabaseWorker.getValue(model, "fuel");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            fType = Fuel.Type.valueOf(param);
        }
        aircraft.setFuelType(fType);
        
        //return aircraft;
    }
    
    private static void initPlanePart(String model, Plane aircraft)
    {
        String param;
        
        param = DatabaseWorker.getValue(model, "runway_length");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            aircraft.setRunwayLength(Integer.parseInt(param) );
        }
    }
    
    private static void initPassengerAirlinerPart(String model, PassengerAirliner aircraft)
    {
        String param;
        
        param = DatabaseWorker.getValue(model, "seats");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            aircraft.setSeats(Integer.parseInt(param) );
        }
    }
    
    private static void initCargoAirlinerPart(String model, CargoAirliner aircraft)
    {
        String param;
        
        param = DatabaseWorker.getValue(model, "loading_gates", "width");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            aircraft.setLoadingGateWidthMeters(Double.parseDouble(param) );
        }
        
        param = DatabaseWorker.getValue(model, "loading_gates", "heigtht");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            aircraft.setLoadingGateHeightMeters(Double.parseDouble(param) );
        }
    }
    
    private static void initHelicopterPart(String model, Helicopter aircraft)
    {
        String param;
        
        param = DatabaseWorker.getValue(model, "seats");
        if(param.length() == 0)
        {
            //report at logs
        }
        else
        {
            aircraft.setSeats(Integer.parseInt(param) );
        }
    }
    
    
}
