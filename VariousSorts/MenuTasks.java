import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/**
 * 
 * @author Spencer
 *  Helper class to make methods more organized
 */
public class MenuTasks
{   
    /**
     *  Prints the menu for the user
     */
   public static void printTable()
   {
       System.out.println("Enter the number associated with the task from the list below: ");
       System.out.println("1. Make and Print a List of Random SSN");
       System.out.println("2. Sort and Print the list of SSN using Quicksort");
       System.out.println("3. Find Locations of SSN using Quicksort");
       System.out.println("4. Sort and Print the list of SSN using BucketSort");
       System.out.println("5. Find Locations of SSN using BucketSort");
       System.out.println("6. Sort and Print the list of SSN using RadixSort");
       System.out.println("7. Find Locations of SSN using RadixSort");
       System.out.println("8. Exit");
   }
   /**
    * 
    * @param scanner user input
    * @return the next integer from scanner
    */
    public static int safeReadInt(Scanner scanner)
    {
        while(!scanner.hasNextInt())
        {
            scanner.nextLine();
            System.out.println("Please enter an integer");
        }
         
        return scanner.nextInt();
        
    }
}
