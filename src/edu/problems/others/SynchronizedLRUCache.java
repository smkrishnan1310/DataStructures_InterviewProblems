package edu.problems.others;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * Design LRU cache which will works in Multi-Threaded environments
 * 
 * SynchronizedLRUCache - This class is a wrapper on LRUCache which takes care
 * of synchronization
 *
 */
public class SynchronizedLRUCache<K, V> {

	private final LRUCache<K, V> lruCache;
	private final ReentrantReadWriteLock lock;
	private final ReadLock readLock;
	private final WriteLock writeLock;

	public SynchronizedLRUCache() {
		this(new LRUCache<>());
	}

	public SynchronizedLRUCache(LRUCache<K, V> lruCache) {
		this.lruCache = lruCache;
		this.lock = new ReentrantReadWriteLock();
		this.readLock = lock.readLock();
		this.writeLock = lock.writeLock();
	}

	public void put(K k, V v) {
		try {
			writeLock.lock();
			lruCache.put(k, v);
		} finally {
			writeLock.unlock();
		}
	}

	// Intentionally used write lock because for every get operation we are moving
	// the LRUNode to front of the LList
	public void get(K k) {
		try {
			writeLock.lock();
			lruCache.get(k);
		} finally {
			writeLock.unlock();
		}
	}

	public int size() {
		try {
			readLock.lock();
			return lruCache.getSize();
		} finally {
			readLock.unlock();
		}
	}

	public void printInLRUOrder() {
		try {
			readLock.lock();
			lruCache.printInLRUOrder();
		} finally {
			readLock.unlock();
		}
	}

}
