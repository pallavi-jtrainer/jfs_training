package mainpkg;

import java.util.PriorityQueue;

public class CollectionsDemo {
	public void priorityQDemo() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(10);
		pq.add(5);
		pq.add(24);
		pq.add(15);
		pq.add(2);
		pq.add(11);
		pq.add(101);
		
		
		System.out.println(pq);
		int ele = pq.remove();
		System.out.println("Removed: " + ele);
		System.out.println(pq);
		pq.offer(6);
		System.out.println(pq);
		ele = pq.remove();
		System.out.println("Removed: " + ele);
		System.out.println(pq);
		
	}
}
