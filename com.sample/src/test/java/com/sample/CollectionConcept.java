package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.concurrent.PriorityBlockingQueue;

import com.graphbuilder.struc.Stack;

public class CollectionConcept {

	public static void main(String[] args) {
	ArrayList<Object> list=new ArrayList<Object>();
	list.add(10);
	list.add(null);
	list.add("hi");
	list.add("hello");
	list.add(null);
	list.add(10);
	System.out.println(list);
	System.out.println("------------>");
	ArrayList<Integer> list1=new ArrayList<Integer>();
	list1.add(60);
	list1.add(10);
	list1.add(30);
	list1.add(0);
	list1.add(20);
	Collections.sort(list1);
	System.out.println(list1);
	list.addAll(list1);
	System.out.println(list);
	if(list.contains("hello"))
	{
		System.out.println("is present");
	}else {
		System.out.println("not present");
	}
	System.out.println(list.get(2));//fetch the element present in index2
	System.out.println("------>");
	System.out.println(list.size());
	System.out.println("------>");
	System.out.println(list.remove(3));//removes the element present in index3
	System.out.println("------>");
	System.out.println(list.indexOf("hello"));//print the index of hello
	System.out.println("------>");
	for(Object value:list) {//fetch elements 1 by 1
		System.out.println(value);
	}
	System.out.println("------>");
	Iterator<Object> it=list.iterator();//fetch elements by using iterator method
	while(it.hasNext())
	{
		System.out.println(it.next());
	}
	
PriorityQueue<Object> q = new PriorityQueue<Object>();
q.add(10);
q.add(20);
q.add(50);
System.out.println(q.peek());
System.out.println(q);
System.out.println(q.poll());
System.out.println(q);

	
HashSet<Object> set = new HashSet<Object>();
set.add(10);
set.add("hello");
set.add("hi");
set.add(null);
set.add(10);
set.add(null);
System.out.println(set);
ArrayList<Object> list2 = new ArrayList<Object>();
list2.add(20);
list2.add("bye");
System.out.println(list2);
System.out.println(set.size());
System.out.println(list2.size());


TreeSet<Object> ts = new TreeSet<Object>();
ts.add(30);
ts.add(20);
ts.add(10);
ts.add(40);
//ts.add("hi");//not allowed  (class caste exception)
//ts.add(null);//not allowed  (null pointer exception)
System.out.println(ts);//auto sorted in ascending order
System.out.println(ts.descendingSet());//auto sorted in descending order


Hashtable<Integer, String> map = new Hashtable<Integer,String>();
map.put(20, "hi");
map.put(40, "hello");
map.put(70, "bye");
map.put(50, "hi");
//map.put(null, "hi");//not allowed
//map.put(60, null);//not allowed
System.out.println(map);
for(Entry<Integer, String> m:map.entrySet()) {
	System.out.println(m.getKey()+" "+m.getValue());
}
System.out.println(map.contains("hello"));
System.out.println(map.containsKey(50));
map.remove(70);
map.remove(70, "bye");
System.out.println(map.get(50));
System.out.println(map);

}
}
