package by.epam.javatraining.rassolko.utils;

import by.epam.javatraining.rassolko.collections.Storage;

public class DatabaseWorker 
{
    private static final String XMLR_DATABASE_FILEPATH = "D:\\Users\\Александр\\Desktop\\aircrafts.xmlr";
    
    private static Storage<String> getElements()
    {
        String source = FileWorker.readFile(XMLR_DATABASE_FILEPATH);
        //System.out.println(source);
        Storage<String> elements = XMLRWorker.collectItems(source, "aircraft");
        
        //System.out.println("! " + elements.size());
        /*System.out.println("!!!!***---***");
        for(int i = 0; i < elements.size(); i++)
        {
            System.out.println(elements.get(i));
            System.out.println("---------------");
        }
        System.out.println("!!!!***---***");*/
        
        return elements;
    }
//    
//    private static String getElementContent(String source, String itemContainer, String searchValue, String ... searchPath)
//    {
//        Storage<String> elements = XMLRWorker.collectItems(source, itemContainer);
//        String elementContent = XMLRWorker.search(elements, searchValue, searchPath);
//        String foundValue = XMLRWorker.getContent(elementContent, searchPath);
//        
//        return foundValue;
//    }
//    
//    private static String getElementContent(Storage<String> elements, String searchValue, String ... searchPath)
//    {
//        String elementContent = XMLRWorker.search(elements, searchValue, searchPath);
//        String foundValue = XMLRWorker.getContent(elementContent, searchPath);
//        
//        return foundValue;
//    }
    
    private static String getElementContent(String searchValue, String ... searchPath)
    {
        Storage<String> elements = getElements();
        
        /*System.out.println("!!!!***---***");
        for(int i = 0; i < elements.size(); i++)
        {
            System.out.println(elements.get(i));
            System.out.println("---------------");
        }
        System.out.println("!!!!***---***");*/
        
        String content = XMLRWorker.search(elements, searchValue, searchPath);
        //String content = XMLRWorker.getContent(elementContent, searchPath);
        
        //System.out.println("content: " + content);
        return content;
    }
    
    public static String getValue(String model, String ... chainPath)
    {
        String elementContent = getElementContent(model, "model");
        /*System.out.println("***start");
        System.out.println(elementContent);
        System.out.println("***end");*/
        String value = XMLRWorker.getContent(elementContent, chainPath);
        
        return value;
    }
}
