import java.util.*;

public class Structure
{
    static ArrayList<int[][]> list;
    static LinkedList<int[][]> linkedQueue;

        public static class Stack   //Stoiva me xrisi ArrayList.
        {
        // Afairesi stoixeiou apo tin koryfi tis stoivas me ArrayList.
            public static int[][] pop() {
            int[][] top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // Eisagogi prwtou stoixeiou stoivas me ArrayList.
        public static void push(int[][] array) 
        {
            list.add(array);
        }
    }

    public static class Queue       //Oura me xrisi ArrayList.
    {
        // Afairesi stoixeiou apo tin koryfi tis ouras me ArrayList.
        public static int[][] dequeue() 
        {
            int[][] top = list.get(0);
            list.remove(0);
            return top;
        }

        // Prosthiki stoixeiou stin arxi tis ouras me ArrayList.
        public static void enqueue(int[][] array) 
        {
            list.add(array);
        }
    }

    public static class LinkedQueue     //Oura me xrisi LinkedList.
    {
        // Afairesi stoixeiou apo tin arxi tis ouras, ylopoiisi me Linked List.
        public static int[][] dequeueLinked() 
        {
            int[][] top = linkedQueue.get(0);
            linkedQueue.remove(0);
            return top;
        }

        //Prosthiki stoixeiou stin koryfi tis ouras, ylopoiisi me Linked List.
        public static void enqueueLinked(int[][] array)
        {
            linkedQueue.add(array);
        } 
    }

}