package by.epam.javatraining.rassolko.maintask02.model.entity;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class EngineNGTest
{
    
    public EngineNGTest()
    {
    }

    @Test
    public void testParseType()
    {
        String typeAsString = "TURBOPROP";
        Engine.Type result = Engine.parseType(typeAsString);
        assertEquals(result, Engine.Type.TURBOPROP);
    }
    
}
