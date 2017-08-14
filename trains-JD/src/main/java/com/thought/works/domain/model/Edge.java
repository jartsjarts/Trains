package com.thought.works.domain.model;

/**
 * Represents an edge of a directed graph
 */
public class Edge implements Comparable<Edge>{
	private int weight;
	private String nodeLabel;
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getNodeLabel() {
		return nodeLabel;
	}
	public void setNode(String nodeLabel) {
		this.nodeLabel = nodeLabel;
	}
	public int compareTo(Edge o) {
		return weight - o.getWeight() ;
	}
	
}
