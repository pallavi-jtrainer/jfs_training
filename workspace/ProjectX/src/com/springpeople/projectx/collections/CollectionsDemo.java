/*
 * Iterator <- ListIterator
 * List <- ArrayList, Vector, LinkedList, Stack
 * Map <- HashMap, TreeMap
 * Set <- HashSet, TreeSet
 * Queue <- Deque, PriorityQ
 */

package com.springpeople.projectx.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.springpeople.projectx.inheritance.Employee;

public class CollectionsDemo {
	public void listDemo() {
		/*
		 * methods of lists:
		 * add, addAll, remove, get, set, iterator, clear,
		 * size, toArray, removeAll, contains
		 * 
		 * arraylists:
		 * clone, sort, isEmpty, indexOf
		 */
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(12);
		
		System.out.println(numbers);
		numbers.add(1, 23);
		System.out.println(numbers);
		
		int ele = numbers.get(2);
		System.out.println("Element: " + ele);
		
//		for(int i = 0; i < numbers.size(); i++) {
//			System.out.println(numbers.get(i));
//		}
		
		Iterator<Integer> itr = numbers.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}
	
	public void listDemo1() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee(101, "Emp1", "HR", 24560.00));
		employees.add(new Employee(102, "EMP2", "IT SUpport", 45600.00));
		
		ListIterator<Employee> itr = employees.listIterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Employee e = employees.get(1);
		System.out.println(e.toString());
	}
	
	public void linkedListDemo() {
		/*
		 * linkedList methods:
		 * contains, lastIndexOf, indexOf, clear, iterator
		 * 
		 * Also implements Queue and Deque interfaces.
		 * some methods are:
		 * addFirst, addLast, removeFirst, removeLast, poll, peek, offer
		 * getFirst, getLast
		 */
		
//		LinkedList<String> list = new LinkedList<String>();
//		list.add("First");
//		list.add("Third");
//		System.out.println(list);
		
//		Queue<String> queue = new LinkedList<String>();
//		
//		queue.offer("First");
//		queue.add("Second");
//		queue.add("Third");
//		
//		System.out.println(queue);
//		
//		String ele = queue.remove();
//		System.out.println(ele);
//		System.out.println(queue);
		
		Deque<String> queue = new LinkedList<String>();
		queue.add("One");
		queue.add("Two");
		
		System.out.println(queue);
		
		queue.addFirst("Three");
		
		queue.offerLast("Three");
		System.out.println(queue);
		queue.removeFirstOccurrence("Two");
		System.out.println(queue);
		
	}
	
	public void priorityQDemo() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(10);
		pq.add(5);
		pq.add(24);
		pq.add(15);
		pq.add(2);
		
		
		System.out.println(pq);
		int ele = pq.remove();
		System.out.println("Removed: " + ele);
		System.out.println(pq);
		pq.offer(6);
		System.out.println(pq);
		
	}
	
	public void setDemo() {
		HashSet<Integer> numbers = new HashSet<Integer>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(4);
		numbers.add(5);
		
		System.out.println(numbers);
		
		//Integer[] arr = numbers.toArray();
//		System.out.println(arr[2]);
		int ele = numbers.stream().findFirst().get(); //first value
		System.out.println(ele);
	}
	
	public void setDemo1() {
		HashSet<Employee> empList = new HashSet<Employee>();
		
		empList.add(new Employee(101, "Emp1", "HR", 2345.00));
		empList.add(new Employee(101, "Emp1", "HR", 2345.00));
		empList.add(new Employee(102, "Emp2", "IT", 3451.00));
		
		System.out.println(empList);
	}
	
	public void mapDemo() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "One");
		map.put(2, "Two");
		map.putIfAbsent(2, "Also Two");
		map.putIfAbsent(3, "Another one");
		map.put(4, "Another one");
		
		System.out.println(map);
		
		Collection<String> ele = map.values();
		System.out.println("Values: " + ele);
		
		Set<Integer> keys = map.keySet();
		System.out.println(keys);
		
		Set<Entry<Integer, String>> entries = map.entrySet();
		System.out.println(entries);
		
		map.remove(3);
		System.out.println(map);
		
	}
	
	public void mapDemo1() {
		HashMap<Integer, Employee> empList = new HashMap<Integer, Employee>();
		empList.put(101, new Employee(101, "EMP1", "HR", 2345.00));
		empList.put(102, new Employee(102, "EMP1", "HR", 2345.00));
		empList.put(103, new Employee(103, "EMP1", "HR", 2345.00));
		empList.put(104, new Employee(104, "EMP1", "HR", 2345.00));
		
		for(Entry<Integer, Employee> entry: empList.entrySet()) {
			System.out.println("Key => " + entry.getKey()+ ", Value =>  " + entry.getValue().toString());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
