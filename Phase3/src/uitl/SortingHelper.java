package uitl;


public class SortingHelper {



    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {

        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(Class sortClass, E[] arr)  {
        SortInterface sortInterface = null;
        try {
            sortInterface = (SortInterface) sortClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        long startTime = System.nanoTime();
        sortInterface.sort( arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException("this sort failed");
        System.out.println(String.format("%s , n = %d : %f s",sortClass, arr.length, time));
    }
}
