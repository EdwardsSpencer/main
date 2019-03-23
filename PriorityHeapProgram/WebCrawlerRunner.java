import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/**
 * 
 * @author Spencer
 *
 */
public class WebCrawlerRunner
{
    /**
     * 
     * @param args not used
     * I/O for heap
     */
    public static void main(String[] args)
    {
        //initialize
        final int SIZEOFHEAPLIST = 30;
        final int SIZEOFPRIORITYQUEUE = 20;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        /*****************************************
         * 
         */
        //start of crawl and interface
        System.out.print("Please enter a keyword: ");
        input = scanner.next();
        Set<String> set = MenuTasks.getUrls(input);
        Heap workingHeap = MenuTasks.makeHeap(set, SIZEOFHEAPLIST, rand);
        workingHeap.buildMaxHeap();
        Heap workingPriorityQueue = MenuTasks.makePriorityQueue(workingHeap, SIZEOFPRIORITYQUEUE);
        workingPriorityQueue.buildMaxHeap();
        while(scanner.hasNextLine())
        {
            MenuTasks.printTable();
            input = scanner.next();
            if( input.equals("1"))
            {
                System.out.print("Please enter new keyword: ");
                input = scanner.next();
                set = MenuTasks.getUrls(input);
                workingHeap = MenuTasks.makeHeap(set, SIZEOFHEAPLIST, rand);
                workingHeap.buildMaxHeap();
                workingPriorityQueue = MenuTasks.makePriorityQueue(workingHeap, SIZEOFPRIORITYQUEUE);
                workingPriorityQueue.buildMaxHeap();
            }
            else if( input.equals("2"))
            {
                workingHeap.heapSort();
                System.out.println("Elements sorted.");
                System.out.println();
            }
            else if( input.equals("3"))
            {
                workingHeap.printHeap();
            }
            else if( input.equals("4"))
            {
                workingHeap.printHeapWithIndividualScores();
            }
            else if( input.equals("5"))
            {
                workingPriorityQueue.heapSort();
                workingPriorityQueue.printHeap();
                System.out.println();
                System.out.println("Please choose the list number associated with the website");
                    int number1 = MenuTasks.safeReadInt(scanner);
                    while(number1 > SIZEOFPRIORITYQUEUE)
                    {
                        System.out.println("Please enter a valid index.");
                        number1 = MenuTasks.safeReadInt(scanner);
                    }
                    System.out.print("Please enter the score: ");
                    int number2 = MenuTasks.safeReadInt(scanner);
                    workingPriorityQueue.heapIncreaseKey((workingPriorityQueue.getSizeOfHeap())-number1, number2 ); 
            }
            else if( input.equals("6"))
            {
                workingPriorityQueue.heapSort();
                workingPriorityQueue.printHeap();
            }
            else if( input.equals("7"))
            {
                System.out.print("Max: ");
                WebsiteAndScoreHolder temp = workingPriorityQueue.heapExtractMax();
                System.out.println( temp.getWebsite() + ", PageRank Score: " + temp.getScore());
            }
            else if( input.equals("8"))
            {
                System.out.print("Please enter URL and Score: ");
                input = scanner.next();
                int int1 = MenuTasks.safeReadInt(scanner);
                workingPriorityQueue.maxHeapInsert(input, int1);
            }
            else if( input.equals("9"))
            {
                System.out.println("Exit");
                return;
            }
            else
            {
                System.out.println("That is not a valid input");
            }
        }
        scanner.close();
    } 
}

