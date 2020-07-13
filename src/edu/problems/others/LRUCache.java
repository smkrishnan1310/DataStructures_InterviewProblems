package edu.problems.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement LRU Cache without using LinkedHashMap and time complexity for get
 * and put methods in O(1)
 * 
 * For Synchronized LRU please refer SynchronizedLRUCache
 */

/** LList - Custom Linked List structure to maintain data with key */
class LList<K, V> {

	LRUNode<K, V> head;
	LRUNode<K, V> tail;

	public LRUNode<K, V> add(K k, V v) {
		LRUNode<K, V> node = new LRUNode<>(k, v);
		if (null != head) {
			LRUNode<K, V> temp = head;
			head = node;
			head.next = temp;
			temp.prev = head;
		} else
			head = tail = node;
		return node;
	}

	public void moveToFirst(LRUNode<K, V> node) {
		if (null != node) {
			LRUNode<K, V> temp = head;
			head = node;
			if (null != node.next)
				node.next.prev = node.prev;
			if (null != node.prev)
				node.prev.next = node.next;
			if (tail == node)
				tail = node.prev;
			node.prev = null;
			node.next = temp;
			temp.prev = head;
		}
	}

	public LRUNode<K, V> removeLast() {
		if (null != tail) {
			LRUNode<K, V> temp = tail;
			tail = temp.prev;
			temp.prev = null;
			if (null != tail)
				tail.next = null;
			if (temp == head)
				head = null;
			temp.v = null;
			return temp;
		}
		return null;
	}

	public void remove(LRUNode<K, V> node) {
		if (null != node) {
			LRUNode<K, V> temp = node;
			temp.v = null;
			if (null != temp.prev)
				temp.prev.next = temp.next;
			if (null != temp.next)
				temp.next.prev = temp.prev;
			if (head == temp)
				head = temp.next;
			temp.next = null;
			temp.prev = null;
		}
	}

}

/** LRUNode structure */
class LRUNode<K, V> {
	LRUNode<K, V> prev;
	LRUNode<K, V> next;
	V v;
	K k;

	public LRUNode(K k, V v) {
		this.k = k;
		this.v = v;
	}

}

/** Implementation of LRU */
public class LRUCache<K, V> {

	private LList<K, V> list = new LList<>();
	private Map<K, LRUNode<K, V>> map = new HashMap<>();

	public int size;
	private int maxSize = 3;

	public LRUCache() {
	}

	public LRUCache(int maxSize) {
		this.maxSize = maxSize;
	}

	public void put(K k, V v) {
		if (null != k) {
			LRUNode<K, V> node = map.get(k);
			if (null != node) {
				list.moveToFirst(node);
				node.v = v;
			} else {
				if (size >= maxSize) {
					LRUNode<K, V> lruNode = list.removeLast();
					map.remove(lruNode.k);
					size--;
				}
				node = list.add(k, v);
				map.put(k, node);
				size++;
			}
		}
	}

	public V get(K k) {
		if (null != k) {
			LRUNode<K, V> node = map.get(k);
			if (null != node) {
				list.moveToFirst(node);
				return node.v;
			}
		}
		return null;
	}

	public void printInLRUOrder() {
		LRUNode<K, V> temp = list.head;
		while (null != temp) {
			System.out.print(temp.v + ", ");
			temp = temp.next;
		}
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		LRUCache<String, String> lru = new LRUCache<>();
		lru.put("google", "www.google.com");
		lru.put("amazon", "www.amazon.com");
		System.out.println("Now LRU Size: " + lru.size);
		lru.put("microsoft", "www.microsoft.com");
		System.out.println("Get Google: " + lru.get("google"));
		lru.put("paypal", "www.paypal.com");
		System.out.println("Get Amazon: " + lru.get("amazon"));
		System.out.println("Get Microsoft: " + lru.get("microsoft"));
		lru.put("GS", "www.gs.com");
		lru.put("ms", "www.ms.com");
		lru.put("cisco", "www.cisco.com");
		lru.put("vmware", "www.vmware.com");
		System.out.println("Get Cisco: " + lru.get("cisco"));
		lru.put("walmart", "www.walmart.com");
		System.out.println("Now LRU Size: " + lru.size);
		System.out.print("Print in LRU Order: ");
		lru.printInLRUOrder();
	}

}
