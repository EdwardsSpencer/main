import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
/**
 * 
 * @author Spencer
 *
 */
public class Heap 
{
    private ArrayList<WebsiteAndScoreHolder> websites;
    private int sizeOfHeap;
    private boolean heapSortCalled = false;
    private static final int ROOT = 0;
    /**
     * 
     * @param temp ArrayList containing the URLS
     * @param size size of the heap
     */
    public Heap(ArrayList<WebsiteAndScoreHolder> temp, int size)
    {
        if (size > temp.size())//make sure we don't exceed the bounds of the arraylist that is passed in
        {
            size = temp.size();
        }
       websites = new ArrayList<WebsiteAndScoreHolder>(); 
        for(int i = temp.size()-1; i >= temp.size() - size; i--)
        {
            websites.add(temp.get(i));
        }
        sizeOfHeap = websites.size();
    }
    /**
     * 
     * @param set the set containing the URLS
     * @param size the size of the heap to be made
     * @param rand the score, produced by a random number generator
     */
    public Heap(Set<String> set, int size, Random rand )
    {
        websites = new ArrayList<WebsiteAndScoreHolder>();
        java.util.Iterator<String> iter = set.iterator();
        for(int i = 0; i < size; i++)
        { 
            if(iter.hasNext() == true)
            {   
                int score1 = Math.abs(rand.nextInt()%100);
                int score2 = Math.abs(rand.nextInt()%100);
                int score3 = Math.abs(rand.nextInt()%100);
                int score4 = Math.abs(rand.nextInt()%100);
                websites.add( new WebsiteAndScoreHolder(iter.next(), score1, score2, score3, score4)); 
            }
        }
        sizeOfHeap = websites.size();
    }
    /**
     * 
     * @param i the integer position of the websiteandscoreholder object to heapified
     */
    public void maxHeapify(int i)
    {
        int left = getLeft(i);
        int right = getRight(i);
        Integer largest = null;
        if( left <= sizeOfHeap-1 && websites.get(left).getScore() > websites.get(i).getScore())
            largest = left;
        else
            largest = i;
        if(right<=sizeOfHeap-1 && websites.get(right).getScore() > websites.get(largest).getScore())
            largest = right;
        if(largest != i)
        {
            swap(i, largest);
            maxHeapify(largest);
        }
    }
    /**
     * 
     * @param i index of object to be swapped with largest
     * @param largest contains the larger score and is swapped with 
     */
    private void swap(int i, int largest)
    {
        WebsiteAndScoreHolder temp = websites.get(i);
        websites.set(i, websites.get(largest));
        websites.set(largest, temp);
    }
    /**
     *  Make the array a heap
     */
    public void buildMaxHeap()
    {
        for(int i = sizeOfHeap/2 - 1; i >= ROOT; i--)
        {
           maxHeapify(i); 
        }
    }
    /**
     * 
     * @param parent in arraylist
     * @return index of left child of parent in arraylist 
     */
    private int getLeft(int parent)
    {
        return 2*parent + 1;
        
    }
    /**
     * 
     * @param parent in arraylist
     * @return index of right child of parent
     */
    private int getRight(int parent)
    {
        return (2*parent)+2;
    }
    /**
     * 
     * @param child in arraylist
     * @return the index of the parent of the child
     */
    private int getParent(int child)
    {
        return child/2;
    }
    /**
     *  Put the elements in the heap in sorted order
     */
    public void heapSort()
    {
        heapSortCalled = true;
        int temp = sizeOfHeap;
        buildMaxHeap();
        for(int i = sizeOfHeap-1; i>ROOT; i--)
        {
            swap(ROOT, i);
            sizeOfHeap--;
            maxHeapify(ROOT);
        }
        sizeOfHeap = temp;
    }
    /**
     * 
     * @param toBeAdded new URL to be added
     * @param score new score to be added
     */
    public void maxHeapInsert(String toBeAdded, int score)
    {
        WebsiteAndScoreHolder temp = new WebsiteAndScoreHolder(toBeAdded, score);
        sizeOfHeap++;
        websites.add(sizeOfHeap-1, temp);
        heapIncreaseKey(sizeOfHeap-1, score);
        int index = sizeOfHeap-1;
        while(temp.getScore() > websites.get(getParent(index)).getScore())
        {
            swap(index, getParent(index));     
            index = getParent(index);
        }
    }
    /**
     * 
     * @return WebsiteAndScoreHolder with the maximum score
     */
    public WebsiteAndScoreHolder heapExtractMax()
    {
        WebsiteAndScoreHolder websiteWithMaxScore = null;
        if(heapSortCalled == true)
        {
            buildMaxHeap();//in case heapSort has been called prior
            heapSortCalled = false;
        }
        if(sizeOfHeap < 1)
            throw new NoSuchElementException();
        else
        {
            websiteWithMaxScore = websites.get(ROOT);
            swap(ROOT, sizeOfHeap-1);
            sizeOfHeap--;
            maxHeapify(ROOT);
            return websiteWithMaxScore;
        }
       
    }
    /**
     * 
     * @param index of WebsiteAndScoreHolder
     * @param score new score to insert into the given WebsiteAndScoreHolder
     */
    public void heapIncreaseKey(int index, int score)
    {
        if(score < websites.get(index).getScore())
        {
           System.out.println("New score is smaller than current score, please try again. ");
           return;
        }
        else
        {
            websites.get(index).setScore(score);
            while(websites.get(getParent(index)).getScore() < websites.get(index).getScore())//index > 1 && 
            {
                swap(index, getParent(index));
                index = getParent(index);
            }
        }
            
    }
    /**
     * 
     * @return The WebsiteAndScoreHolder with the maximum score
     */
    public WebsiteAndScoreHolder heapMaximum()
    {
        if(heapSortCalled == true) //makes sure the heap property is maintained
        {
            buildMaxHeap();
            heapSortCalled = false;
        }
        return websites.get(ROOT);
    }
    /**
     * 
     * @return the size of the heap
     */
    public int getSizeOfHeap() 
    {
        int temp = sizeOfHeap;
        return temp;
    }  
    /**
     * 
     * @return a clone of the heap's arrayList
     */
    public ArrayList<WebsiteAndScoreHolder> getList()
    {
        if(heapSortCalled == false)
            heapSort();
        
            ArrayList<WebsiteAndScoreHolder> temp = new ArrayList<WebsiteAndScoreHolder>();
            for(int i = 0; i < sizeOfHeap; i++)
            {//cloning the objects in the heap for the priority queue
                temp.add(new WebsiteAndScoreHolder(websites.get(i).getWebsite(), 
                    websites.get(i).getScore1(),  websites.get(i).getScore2(), 
                    websites.get(i).getScore3(),websites.get(i).getScore4()));
            }
            return temp;
    }
    /**
     * 
     * @param score to use
     * @param index of the object to place the score into
     */
    public void setScore(int score, int index)
    {
        websites.get(index).setScore(score);
    } 
    /**
     * Prints the heap
     */
    public void printHeap()
    {
        int count = 1;
        for(int i = sizeOfHeap-1; i >= 0; i--)
        {
            System.out.println(count + ". " + websites.get(i).getWebsite() + ", PageRank Score: " + websites.get(i).getScore());
            count++;
        }
        System.out.println();
        if(heapSortCalled == false)
        {
            System.out.println("The heap has not been sorted.");
            System.out.println();
        }
    }
    /**
     * Prints the heap with individual scores
     */
    public void printHeapWithIndividualScores()
    {
        int count = 1;
        for(int i = sizeOfHeap-1; i >= 0; i--)
        {
            System.out.println(count + ". " + websites.get(i).getWebsite() + ", PageRank Scores: " + websites.get(i).seeScoreItemized());
            count++;
        }   
    }
    /**
     * Print all of the websites within the heap
     */
    public void printWebsites()
    {
        for(int i = 0; i < sizeOfHeap; i++)
        {
            System.out.print((i + 1) + ". ");
            System.out.println(websites.get(i).getWebsite());
        }    
    }
    /** 
     * @param i is the index of the WebsiteAndScoreHolder
     * @return the URL of the given object at index i 
     */
    public String getWebsite(int i)
    {
        return websites.get(i).getWebsite();
    }
    /**
     * 
     * @param i index of arrayList that we want to look at
     * @return the score of the website at index i
     */
    public int getScore(int i) 
    {
        return websites.get(i).getScore();
    }
}
