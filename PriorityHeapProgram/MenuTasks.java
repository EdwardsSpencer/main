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
     * 
     * @param input user keyword
     * @return the webcrawlers search
     */
    public static Set<String> getUrls(String input)
    {
        WebCrawler crawler = new WebCrawler(input);
        crawler.search();
        Set<String> set = crawler.getUrls();
        printWebCrawler(set);
        return set;
        
    }
    /**
     *  Prints the menu for the user
     */
   public static void printTable()
   {
       System.out.println("Enter the number associated with the task from the list below: ");
       System.out.println("1. Enter a new keyword");
       System.out.println("2. Sort 30 URLS");
       System.out.println("3. Print PageRank Scores with URLS (must call sort first to have them sorted)");
       System.out.println("4. See PageRank scores before adding them together");
       System.out.println("5. Choose a URL to increase PageRank Score");
       System.out.println("6. Print URLS in priority queue");
       System.out.println("7. Extract Maximum from priority queue");
       System.out.println("8. Add URL to priority queue");
       System.out.println("9. Exit");
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
    /**
     * 
     * @param set contains all the URLS 
     */
    private static void printWebCrawler(Set<String> set)
    {
        int count = 1;
        Iterator<String> iter = set.iterator();
        while( count <= 30 && iter.hasNext())
        {
            System.out.println(count + ". " + iter.next());
            count++;
        }
        System.out.println();
    }
    /**
     * 
     * @param set that contains the URLS
     * @param size of the new heap
     * @param rand is random integer value
     * @return new heap object
     */
    public static Heap makeHeap(Set<String> set, int size, Random rand)
    {
        Heap heap = new Heap(set, size, rand);
        
        return heap;
        
    }
    /**
     * 
     * @param heap to be made into priority queue
     * @param size of new priority queue
     * @return priority queue
     */
    public static Heap makePriorityQueue(Heap heap, int size)
    {
        ArrayList<WebsiteAndScoreHolder> list = heap.getList();
        
        Heap priorityQueue = new Heap(list, size);
        return priorityQueue;
    }
 
}
