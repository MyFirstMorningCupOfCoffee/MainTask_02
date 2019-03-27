package by.epam.javatraining.rassolko.utils;

import by.epam.javatraining.rassolko.collections.Storage;

import java.util.regex.*;

public class XMLRWorker 
{
    public static boolean fits(String source, String value, String ... propertyChain)
    {
        String factValue = getContent(source, propertyChain);
        
        return factValue.equals(value);
    }
    
    public static String search(Storage<String> elements, String value, String ... propertyChain)
    {
        for(int i = 0; i < elements.size(); i++)
        {
            if(fits(elements.get(i), value, propertyChain))
            {
                return elements.get(i);
            }
        }
        
        return "";
    }
    
    public static String getContent(String source, String ... propertyChain)
    {
        String buffer = source;
        
        for(String property : propertyChain)
        {
            String pattern = "<" + property + ">(.+?)</" + property + ">";
            //System.out.println(pattern);
            Pattern pat = Pattern.compile(pattern, Pattern.DOTALL);
            Matcher mat = pat.matcher(buffer);
            if(mat.find())
            {
                buffer = mat.group(1);
            }
            else
            {
                buffer = "";
            }
        }
        
        return buffer;
    }
    
    public static Storage<String> collectItems(String source, String itemContainer)
    {
        Storage<String> responce = new Storage<>();
        
        //System.out.println("src: " + source);
        String pattern = "<" + itemContainer + ">(.+?)</" + itemContainer + ">";
        //System.out.println("pattern: " + pattern);
        Pattern pat = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher mat = pat.matcher(source);
        
        while(mat.find())
        {
            responce.add(mat.group(1));
        }
        
        return responce;
    }
}
