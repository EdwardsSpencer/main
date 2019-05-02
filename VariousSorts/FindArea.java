import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindArea {
    /**
     * 
     * @param file input file with SN numbers
     */
    public static void findLocations(String file)
    {
        int NE = 0; //from 0 to 199
        int SC = 0; //from 200 to 399
        int MS = 0; //from 400 to 599
        int NW = 0; //from 600 to 799
        int WC = 0; //from 800 to 999
        
        ArrayList<String> list = new ArrayList<String>();
        Scanner scan;
        try
        {
            scan = new Scanner(new File(file));
            while(scan.hasNext())
                list.add(scan.next());
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        for(int i = 0; i < list.size(); i++)
        {
            Integer sub = Integer.parseInt(list.get(i).substring(0,3));
           // System.out.println(sub);
            if(sub <= 199)
                NE++;
            if(sub > 199 && sub <= 399)
                SC++;
            if(sub > 400 && sub <= 599)
                MS++;
            if(sub > 600 && sub <= 799)
                NW++;
            if(sub > 800 && sub <= 999)
                WC++;
        }
        System.out.println("Northeast Coast States:" + NE);
        System.out.println("South Coast States:" + SC);
        System.out.println("Middle States:" + MS);
        System.out.println("Northwest Coast States:" + NW);
        System.out.println("West Coast States:" + WC);
        System.out.println();
    }

}
