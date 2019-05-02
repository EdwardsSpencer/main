import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MakeArray 
{
    /**
     * 
     * @return places the contents of the file into an ArrayString list
     */
    public static ArrayList<String> initializeStringArray()
    {
        File tempFile = new File("SSnNumbers.txt");
        Scanner scan1;
        ArrayList<String> ssHolder = new ArrayList<String>();
        String temp = "";
        try
        {
            scan1 = new Scanner(tempFile);
            while(scan1.hasNext())
            {
                temp = scan1.next();
                ssHolder.add(temp);
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return ssHolder;
    }
    /**
     * 
     * @return returns an array initialized with the SSN with the dashes removed
     */
    public static ArrayList<Integer> initializeIntArray()
    {
        ArrayList<String> ssHolder = initializeStringArray();
        ArrayList<Integer> ssIntHolder = new ArrayList<Integer>();
        for(int i = 0; i< ssHolder.size(); i++ )
        {
            ssIntHolder.add(Integer.parseInt(ssHolder.get(i).replaceAll("-", "")));
        }
        return ssIntHolder;
    }
    
}
