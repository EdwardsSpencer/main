import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Spencer
 *
 */
public class ProgrammingAssignment2Runner
{
    static final int p = 0;
    public static void main(String[] args)
    {
        //start interface
       Scanner menuScan = new Scanner(System.in);
        String input = "";
        MenuTasks.printTable();
        while(menuScan.hasNextLine())
        {
            input = menuScan.next();
            if( input.equals("1"))
            {
                RandomNumberGenerator.rng();
                
                ArrayList<String> ssHolder = MakeArray.initializeStringArray();
                for(int i = 0; i< ssHolder.size(); i++)
                    System.out.println(ssHolder.get(i));
            }
            else if( input.equals("2"))
            {
                ArrayList<Integer> ssHolder = MakeArray.initializeIntArray();
                QuickSort.quickSort(ssHolder, p, ssHolder.size()-1);
                ArrayList<String> sList = WriteToFile.convertToString(ssHolder);
                WriteToFile.writeToFile(sList, "QuickSortOutput.txt");
                for(int i = 0; i< sList.size();i++)
                    System.out.println(sList.get(i));
            }
            else if( input.equals("3"))
            {
                FindArea.findLocations("QuickSortOutput.txt");
            }
            else if( input.equals("4"))
            {
                ArrayList<String> temp = MakeArray.initializeStringArray();
                ArrayList<Integer> intTemp = MakeArray.initializeIntArray();
               ArrayList<Integer> afterSort = BucketSort.bucketSort(temp, intTemp);
               ArrayList<String> newTemp = WriteToFile.convertToString(afterSort);
               for(int i = 0; i < newTemp.size(); i++)
               {
                   System.out.println(newTemp.get(i));
               }
               WriteToFile.writeToFile(newTemp, "BucketSortOutput.txt");
            }
            else if( input.equals("5"))
            {
                    FindArea.findLocations("BucketSortOutput.txt");  
            }
            
            else if( input.equals("6"))
            {
                int radix = 9;
                ArrayList<String> temp = MakeArray.initializeStringArray();
                ArrayList<Integer> intTemp = MakeArray.initializeIntArray();
               intTemp = RadixSort.radix(intTemp, radix);
               temp = WriteToFile.convertToString(intTemp);
               for(int i = 0; i < temp.size(); i++)
                   System.out.println(temp.get(i));
               WriteToFile.writeToFile(temp, "radixSortOutput.txt");
            }
            else if( input.equals("7"))
            {
                    FindArea.findLocations("radixSortOutput.txt");  
            }
            else if( input.equals("8"))
            {
                System.out.println("Exit");
                return;
            }
            else
            {
                System.out.println("That is not a valid input");
            }
            MenuTasks.printTable(); 
        } 
        menuScan.close();  
    }
}
   

