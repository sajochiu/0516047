import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;

import java.util.*;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Collection;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class PriorityQueueTest {
    Random rand = new Random();

    public PriorityQueueTest (Integer n1, Integer n2, Integer n3, Integer n4, Integer n5) {
        PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
        prq.add(n1); prq.add(n2); prq.add(n3); prq.add(n4); prq.add(n5);
        Integer[] SortedArray = new Integer[]{n1, n2, n3, n4, n5};
        Integer[] PRQArray = new Integer[5];
        Arrays.sort(SortedArray);
        for(int i=0; i<5; i++) {
            PRQArray[i] = prq.poll();
        }
        assertArrayEquals(PRQArray, SortedArray);
    }

    @Parameters
    public static Collection testArrays() {
        Integer[][] Random2Darray = new Integer[5][10];
        return Arrays.asList(new Integer[][] {
                { 2, 3, 1, 9, 6 },
                { 7, 2, 5, 1, 4 },
                { 6, 3, 7, 2, 8 },
                { 3, 9, 8, 2, 1 },
                { 4, 7, 9, 1, 6 }
        });
    }

    @Test
    public void NotParameterizedTest() {
        PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
        prq.add(7); prq.add(4); prq.add(8); prq.add(2); prq.add(5);
        Integer[] SortedArray = new Integer[]{2, 4, 5, 7, 8};
        Integer[] PRQArray = new Integer[5];
        Arrays.sort(SortedArray);
        for(int i=0; i<5; i++) {
            PRQArray[i] = prq.poll();
        }
        assertArrayEquals(PRQArray, SortedArray);
    }
    @Test(expected=NullPointerException.class) // add
    public void ExceptionTest1() {
        PriorityQueue<String> prq = new PriorityQueue<String>();
        String s = new String();
        s = "ERROR";
        prq.add(s);
    }
    @Test(expected=ClassCastException.class) // add
    public void ExceptionTest2() {
        PriorityQueue<ArrayList> prq = new PriorityQueue<ArrayList>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        prq.add(list);
    }
    @Test(expected=ArrayStoreException.class) // toArray
    public void ExceptionTest3() {
        PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
        prq.add(1);
        prq.add(2);
        prq.add(3);
        Double[] arr = new Double[5];
        prq.toArray(arr);
    }
}
