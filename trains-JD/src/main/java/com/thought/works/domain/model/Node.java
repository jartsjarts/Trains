package com.thought.works.domain.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a directed graph vertex, containing node information and
 * edges departing from itself.
 *
 */
public class Node {

	private String label;
	private List<Edge> edges;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Node() {
		edges = new LinkedList<Edge>();
	}

	public Edge getEdgeWithNode(String destinationNodeName) {
		for (Edge edge : edges) {
			if (edge.getNodeLabel().equals(destinationNodeName)) {
				return edge;
			}
		}

		return null;
	}
	
}
