import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BucketSort
{
    /**
     * 
     * @param list is the list of SN with dashes
     * @param intList is the list of SN without dashes
     * @return returns the sorted list
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Integer> bucketSort(ArrayList<String> list, ArrayList<Integer> intList)
    {
        List<ArrayList<Integer>> lList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 100; i++)
        {
            lList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < list.size(); i++)
        {
            String stemp = list.get(i).substring(0,2);
            int tempInt = Integer.parseInt(stemp);//index
            lList.get(tempInt).add(intList.get(i));//adding value to proper index
        }
        for(int i = 0; i < lList.size(); i++)
        {
            insertionSort(lList.get(i));
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i< lList.size();i++)
        {
            for(int j = 0; j < lList.get(i).size(); j++)
            {
               temp.add(lList.get(i).get(j));
            }
        }
        return temp;  
    }
   
    /**
     * 
     * @param list the bucket to be sorted
     */
    private static void insertionSort(ArrayList<Integer> list)
    {
        //InsertionSort
        int key = 0;
        int i = 0;
            for( int j = 1; j < list.size(); j++)
            {
                key = list.get(j);
                i = j - 1;
            
                while( i >= 0 && list.get(i)>key)
                {
                    list.set(i+1, list.get(i));
                    i--;
                } 
            list.set(i+1, key);
            } 
        }
}









