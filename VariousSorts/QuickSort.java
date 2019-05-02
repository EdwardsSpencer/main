import java.util.ArrayList;

public class QuickSort {
    /**
     * 
     * @param list is the list to be sorted
     * @param p is the starting index
     * @param r is the upper bound
     */
    public static void quickSort(ArrayList<Integer> list, int p, int r)
    {
        if (p<r)
        {
            int q = partition(list, p, r);
            quickSort(list, p, q-1);
            quickSort(list, q+1, r);            
        }
    }
    /**
     * 
     * @param list is the list to be sorted
     * @param p is the starting index
     * @param r is the upper bound
     * @return the pivot for the sort just done
     */
    public static Integer partition(ArrayList<Integer> list, int p, int r)
    {
        int x = list.get(r);
        int i = p-1;
        for( int j = p; j < r; j++)
        {
            if(list.get(j) <= x)
            {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i+1, r);
        return i+1;
    }
    /**
     * 
     * @param list is the list to be sorted
     * @param i i is an index to be swapped
     * @param j j is an index to be swapped
     */
    private static void swap(ArrayList<Integer> list, Integer i, Integer j)
    {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}
