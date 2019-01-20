package com.java.DataStructures;

import java.util.ArrayList;
import java.util.List;

/**
* The HashMap program using Arraylist and LinkedList which is inspired but coded with clear understanding
*
* @author  Sreemanth Jasti
* @version 1.0
* @since   2019-01-19 
*/
class Hashnode<K, V> {

	K key;
	V value;

	Hashnode<K, V> next;

	public Hashnode(K key, V value) {
		this.key = key;
		this.value = value;

	}
}

public class HashTable<K, V> {

	ArrayList<Hashnode<K, V>> bucketList;
	int bucketsize;
	int size;

	public HashTable() {
		bucketList = new ArrayList<>();
		this.bucketsize = 10;
		
		for(int i=0;i<bucketsize;i++)
			bucketList.add(null);

	}

	public V get(K key) {
		System.out.println("in get");

		int index = getIndex(key);
		
		Hashnode<K, V> node = bucketList.get(index);
		
		while (node != null) {
			if (!node.key.equals(key))
				node = node.next;
			else
				return node.value;
			
		}

		return null;
		
	}

	public void add(K key, V val) {

		System.out.println("in add");
		int index =  getIndex(key);
		Hashnode<K, V> node = bucketList.get(index);

		while (node != null) {
			if (!node.key.equals(key))
				node = node.next;

			else{
				node.value = val;
			    return;
			}
		}

		size++;
		node = bucketList.get(index);
		Hashnode<K, V> newNode = new Hashnode<K, V>(key, val);
		bucketList.set(index, newNode);
		newNode.next = node;
		
		
		
		
		if (((1.0) * size / bucketsize) >= 0.7) {
			ArrayList<Hashnode<K, V>> temp = bucketList;
			bucketsize = bucketsize * 2;

			for (int i = 0; i < bucketsize; i++)
				bucketList.set(i, null);

			for (Hashnode<K, V> headnode : temp)

				while (headnode != null) {
					add(headnode.key, headnode.value);
					headnode = headnode.next;
				}
		}

	}

	public Hashnode delete(K key) {
		
		System.out.println("in delete");

		int index = getIndex(key);
		Hashnode<K, V> node = bucketList.get(index);
		Hashnode<K, V> prev=null; 
		
		while (node != null) {
			if (!node.key.equals(key)){
				prev = node;
			    node=node.next; 
			}
			else
				break;
		}
		
		if(prev!=null)
			prev.next=node.next;
		else
			prev.next=node.next;
			bucketList.set(index, prev);
		
		return node;

	}

	public int getIndex(K key) {
		System.out.println("in getIndex");

		int hashval = key.hashCode();
		int index = hashval / bucketsize;
		return index;

	}

	public static void main(String[] args) {

		HashTable<Integer, String> Hinstance = new HashTable<>();
		Hinstance.add(1, "sree");
		Hinstance.add(2, "ram");
		System.out.println(Hinstance.get(1));
		
		Hinstance.delete(1);
		System.out.println(Hinstance.get(1));
		

	}

}
