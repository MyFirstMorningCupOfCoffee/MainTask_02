package by.epam.javatraining.rassolko.maintask02.utils;

import by.epam.javatraining.rassolko.maintask02.collections.Storage;
import org.apache.log4j.Logger;

// Emulates work with properly built database
public class AircraftsDatabaseWorker 
{
    private static final String XMLR_DATABASE_FILEPATH = "aircrafts_default_params.xmlr";
    private static final Logger LOGGER;

    
    static
    {
        LOGGER = Logger.getLogger("AircraftsDatabaseWorker");
    }
    
    private AircraftsDatabaseWorker()
    {
        // not allowed
    }
    
    // Used to prepare aircrafts xmlr file parts
    // Storage<String> holds String xmlr pieces, 1 for each aircraft
    private static Storage<String> getElements()
    {
        
        String source = FileWorker.readFile(XMLR_DATABASE_FILEPATH);
        Storage<String> elements = XMLRWorker.collectItems(source, "aircraft");
        
        return elements;
    }

    // Used to init aircraft fields with values taken from default params database
    // Returns piece of xmlr file with data for chosen model
    private static String getElementContent(String searchValue, String ... searchPath)
    {
        Storage<String> elements = getElements();
        
        String content = XMLRWorker.search(elements, searchValue, searchPath);

        return content;
    }
    
    // Used to read proper field value (using 1 or more Strings to set field)
    // for chosen by model aircraft
    public static String getValue(String model, String ... chainPath)
    {
        String elementContent = getElementContent(model, "model");
        String value = XMLRWorker.getContent(elementContent, chainPath);
        
        if(value.length() == 0)
        {
            StringBuilder message = new StringBuilder();
            message.append("Failed to get data for model ").append(model);
            message.append(", property ");
            for(int i = 0; i < chainPath.length; i++)
            {
                message.append(chainPath[i]).append(" ");
            }
            
            LOGGER.warn(message.toString());
        }
        return value;
    }
}
