package p2_1;

import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/9/28、15:35
 */
public class Test {
    /**
      Sorts the specified array of objects into ascending order, according
      to the {@linkplain Comparable natural ordering} of its elements.
      All elements in the array must implement the {@link Comparable}
      interface.  Furthermore, all elements in the array must be
      <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)} must
      not throw a {@code ClassCastException} for any elements {@code e1}
      and {@code e2} in the array).

      <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
      not be reordered as a result of the sort.

      <p>Implementation note: This implementation is a stable, adaptive,
      iterative mergesort that requires far fewer than n lg(n) comparisons
      when the input array is partially sorted, while offering the
      performance of a traditional mergesort when the input array is
      randomly ordered.  If the input array is nearly sorted, the
      implementation requires approximately n comparisons.  Temporary
      storage requirements vary from a small constant for nearly sorted
      input arrays to n/2 object references for randomly ordered input
      arrays.

      <p>The implementation takes equal advantage of ascending and
      descending order in its input array, and can take advantage of
      ascending and descending order in different parts of the the same
      input array.  It is well-suited to merging two or more sorted arrays:
      simply concatenate the arrays and sort the resulting array.

      <p>The implementation was adapted from Tim Peters's list sort for Python
      (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
      TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
      Sorting and Information Theoretic Complexity", in Proceedings of the
      Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
      January 1993.

      @param a the array to be sorted
      @throws ClassCastException if the array contains elements that are not
              <i>mutually comparable</i> (for example, strings and integers)
     @throws IllegalArgumentException (optional) if the natural
             ordering of the array elements is found to violate the
             {@link Comparable} contract
     */
    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        System.out.println(maxHeap);
        int[] test = new int[n];
        for (int i = 0; i < n; i++){
            test[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++){
            if (test[i] > test[i-1])
                System.out.println("----");
        }
    }
}
