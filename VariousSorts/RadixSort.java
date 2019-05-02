import java.util.ArrayList;

public class RadixSort {
    /**
     * 
     * @param list list of SN as integers
     * @param radix the number of times to do the loop
     * @return the sorted list
     */
    public static ArrayList<Integer> radix(ArrayList<Integer> list, int radix)
    {
        int powerOfTen = 1;
        for(int i = 0; i < radix; i++)
        {
            list = countingSort(list, powerOfTen);
            powerOfTen = powerOfTen*10;
        }
            return list;
    }
    /**
     * 
     * @param list the list to be sorted
     * @param pTen the divisor to get the correct digit
     * @return the array sorted by the ith digit
     */
    private static ArrayList<Integer> countingSort(ArrayList<Integer> list, int pTen)
    {
        ArrayList<Integer> count = new ArrayList<Integer>();
        ArrayList<Integer> rArray = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); i++)
            rArray.add(0);
        for(int i = 0; i < 10; i++)
            count.add(0);
        for(int j = 0; j < list.size(); j++)
        {
            int index = (list.get(j)/pTen)%10;
            count.set(index, count.get(index) + 1);
        }
        for(int i = 1; i < 10; i++)
        {
            count.set(i, count.get(i) + count.get(i-1));
        }
        for( int j = list.size()-1; j >= 0; j--)
        {
            int listIndex = (list.get(j)/pTen)%10;
            rArray.set(count.get(listIndex)-1, list.get(j));
            count.set((list.get(j)/pTen)%10, count.get((list.get(j)/pTen)%10)-1); 
        }
           return rArray;       
    }
}
