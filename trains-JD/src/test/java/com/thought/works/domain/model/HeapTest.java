package com.thought.works.domain.model;

import org.junit.Assert;
import org.junit.Test;

import com.thought.works.domain.model.Edge;
import com.thought.works.domain.model.Heap;
import com.thought.works.exceptions.HeapException;

public class HeapTest {

	@Test
	public void isEmpty() {
		Heap<Edge> heap = new Heap<Edge>(5);
		Assert.assertTrue(heap.isEmpty());

		Edge edge = new Edge();
		edge.setNode("A");
		edge.setWeight(5);

		heap.insert(edge);
		Assert.assertTrue(!heap.isEmpty());
	}

	@Test
	public void testSize() {
		Heap<Edge> heap = new Heap<Edge>(5);

		Assert.assertTrue(heap.size() == 0);

		Edge edge = new Edge();
		edge.setNode("A");
		edge.setWeight(5);

		heap.insert(edge);

		Assert.assertTrue(heap.size() == 1);

		edge = new Edge();
		edge.setNode("A");
		edge.setWeight(5);

		heap.insert(edge);

		Assert.assertTrue(heap.size() == 2);

	}

	@Test
	public void testTop() {
		Heap<Edge> heap = new Heap<Edge>(5);
		try {
			heap.top();
			Assert.fail();
		} catch (HeapException hexc) {

		}

		Edge edge = new Edge();
		edge.setNode("A");
		edge.setWeight(5);

		heap.insert(edge);

		edge = new Edge();
		edge.setNode("B");
		edge.setWeight(5);

		heap.insert(edge);

		edge = new Edge();
		edge.setNode("C");
		edge.setWeight(1);

		heap.insert(edge);

		Edge edge1 = (Edge) heap.top();
		Assert.assertEquals("C", edge1.getNodeLabel());

	}

	@Test
	public void testHeapInsertion() {

		Heap<Edge> heap = new Heap<Edge>(2);

		Edge edge = new Edge();
		edge.setNode("A");
		edge.setWeight(5);

		heap.insert(edge);

		Assert.assertTrue(!heap.isEmpty());
		Assert.assertTrue(heap.size() == 1);

		Edge recoveredEdge = (Edge) heap.top();
		Assert.assertTrue(recoveredEdge.getWeight() == 5);

		Edge edge2 = new Edge();
		edge2.setNode("B");
		edge2.setWeight(3);
		heap.insert(edge);

		Assert.assertTrue(!heap.isEmpty());
		Assert.assertTrue(heap.size() == 2);

		Edge recoveredEdge2 = (Edge) heap.top();
		Assert.assertTrue(recoveredEdge2.getWeight() == 5);

		Edge edge3 = new Edge();
		edge3.setNode("C");
		edge3.setWeight(4);

		try {
			heap.insert(edge3);
			Assert.fail();
		} catch (HeapException hexc) {

		}
	}

	@Test
	public void testHeapRemoval() {
		Heap<Edge> heap = new Heap<Edge>(2);

		Edge edge = new Edge();
		edge.setNode("A");
		edge.setWeight(5);

		heap.insert(edge);

		Edge edge1 = new Edge();
		edge1.setNode("B");
		edge1.setWeight(4);

		heap.insert(edge1);

		heap.remove();

		Assert.assertTrue(!heap.isEmpty());
		Assert.assertTrue(heap.size() == 1);

		Edge recoveredEdge = (Edge) heap.top();
		Assert.assertTrue(recoveredEdge.getWeight() == 5);
	}
}
