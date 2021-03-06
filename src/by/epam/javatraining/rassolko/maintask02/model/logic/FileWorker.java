package by.epam.javatraining.rassolko.maintask02.model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWorker 
{
    //Simply reads all text from file, nothing more
    public static String readFile(String fullPath)
    {
        BufferedReader br = null;
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();

        try 
        {
            fr = new FileReader(fullPath);
            br = new BufferedReader(fr);
            String buffer;

            while ((buffer = br.readLine()) != null) 
            {
                sb.append(buffer).append("\n");
            }
        } 
        catch (IOException e) 
        {
            // ignore
        } 
        finally 
        {
            try 
            {
                if (br != null)
                {
                    br.close();
                }
                if (fr != null)
                {
                    fr.close();
                }
            } 
            catch (IOException ex) 
            {
                // ignore
            }
        }
        return sb.toString();
    }
}
