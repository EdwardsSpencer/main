import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {
    /**
     * 
     * @param list is the arrayList to write to file
     * @param nameOfFile the name of the file to write to
     */
    public static void writeToFile(ArrayList<String> list, String nameOfFile)
    {
        try
        {
            File file = new File(nameOfFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(int i = 0; i < list.size(); i++)
            {
                writer.write(list.get(i) + String.format("%n"));
            }
            writer.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }    
    }
    public static ArrayList<String> convertToString(ArrayList<Integer> list)
    {
        ArrayList<String> sList = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++)
        {
            String temp = (String.format("%9s", list.get(i)).replace(' ', '0'));
            StringBuilder b = new StringBuilder(temp);
            b.insert(3, '-');
            b.insert(6, '-');
            sList.add(b.toString());
        }
       return sList;      
    }
}
