package collection;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQu {
	public static void main(String srg[]) {
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("Ajay");
		pq.add("vijay");
		pq.add("vishal");
		pq.add("vinay");
		pq.add("mohan");

		System.out.println(pq.peek());
		System.out.println(pq.poll());
		
Iterator<String> it=pq.iterator();
while(it.hasNext())
{
	System.out.println(it);
}
	}

}
