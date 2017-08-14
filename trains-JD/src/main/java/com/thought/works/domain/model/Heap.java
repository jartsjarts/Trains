package com.thought.works.domain.model;

import com.thought.works.exceptions.HeapException;

/**
 * This class represents a min-heap containing edges. In the top can be found
 * the light-weighted edges, while in the bottom the heavier ones. As a normal
 * heap the mantained tree is a complete tree.
 * 
 * Data structure costs: size() O(1), isEmpty() O(1), insert() O(logn), remove()
 * O(logn), top() O(1)
 * 
 * @param <Edge>
 */
public class Heap<E extends Comparable<Edge>> {

	private Object edges[];
	private int last;
	private int capacity;

	public Heap() {
	}

	public Heap(int capacity) {
		edges = new Object[capacity + 1];
		last = 0;
		this.capacity = capacity;
	}

	/**
	 * @return the number of edges contained in the heap
	 */
	public int size() {
		return last;
	}

	/**
	 * @return if the heap contains elements
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * @return edge with smallest weight
	 * @throws HeapException
	 */
	public Edge top() throws HeapException {
		if (isEmpty()) {
			throw new HeapException("Empty heap.");
		} else {
			return (Edge) edges[1];
		}
	}

	/**
	 * Inserts an edge into the heap and reorganize it in order to keep being a
	 * min-heap
	 * 
	 * @param e
	 * @throws HeapException
	 */
	public void insert(Edge e) throws HeapException {
		if (size() == capacity) {
			throw new HeapException("Heap overflows capacity.");
		} else {
			last++;
			edges[last] = e;
			bubbleHeapEdgeUp();
		}
	}

	/**
	 * removes and returns smallest edge of the heap. It reorganize itself to
	 * maintain a min-heap
	 * 
	 * @return
	 * @throws HeapException
	 */
	public Edge remove() throws HeapException {
		if (isEmpty()) {
			throw new HeapException("Empty heap.");
		} else {
			Edge min = top();
			edges[1] = edges[last];
			last--;
			bubbleHeapEdgeDown();
			return min;
		}
	}

	/**
	 * Reorders the heap edges in order to maintain it as a min-heap. After
	 * remove() is invoked, the last element is promoted to the root, forcing
	 * this way to reorganize the heap to keep the structure.
	 */
	private void bubbleHeapEdgeDown() {
		int index = 1;
		while (true) {
			int child = index * 2;
			// If there is no or just one element
			if (child > size()) {
				break;
			}
			if (child + 1 <= size()) {
				// When there are two children get the smallest one
				child = findMinimum(child, child + 1);
			}
			if (compare((Edge) edges[index], (Edge) edges[child]) <= 0) {
				break;
			}
			swap(index, child);
			index = child;
		}
	}

	/**
	 * Reorders the heap edges in order to maintain it as a min-heap, after the
	 * insert() has appended a new edge at the bottom of the heap
	 */
	private void bubbleHeapEdgeUp() {
		int index = size();
		while (index > 1) {
			int parent = index / 2;
			if (compare((Edge) edges[index], (Edge) edges[parent]) >= 0) {
				// if the parent is greater or equal to the current element
				// reorganization its finished.
				break;
			}
			swap(index, parent);
			index = parent;
		}
	}

	/**
	 * Exchange two integers int1 and int2
	 * 
	 * @param int1
	 * @param int2
	 */
	private void swap(int int1, int int2) {
		Edge temp = (Edge) edges[int1];
		edges[int1] = edges[int2];
		edges[int2] = temp;
	}

	/**
	 * @param leftChild
	 * @param rightChild
	 * @return min of left and right child, if they are equal return the left
	 */
	private int findMinimum(int leftChild, int rightChild) {
		if (compare((Edge) edges[leftChild], (Edge) edges[rightChild]) <= 0) {
			return leftChild;
		} else {
			return rightChild;
		}
	}

	/**
	 * @param x
	 * @param y
	 * @return edge with smallest weight
	 */
	private int compare(Edge x, Edge y) {
		return ((Edge) x).compareTo((Edge) y);
	}

	public String toString() {
		String str = "";
		for (int i = 1; i <= size(); i++) {
			str += edges[i];
			if (i != last) {
				str += ",";
			}
		}
		return str + "";
	}
}
