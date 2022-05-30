import adt.arrayimpl.UnorderedArrayMaxPQ;

public class Main {
    public static void main(String[] args) {

        /***************************************************************************
         * UnorderedArrayMaxPQ Test routine.
         ***************************************************************************/
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        System.out.println("THe size of UnorderedArrayMaxPQ is " + pq.getSize());

        while (!pq.isEmpty())
            System.out.println(pq.delMax());
        System.out.println("THe size of UnorderedArrayMaxPQ is " + pq.getSize());
    }

}
