package com.thought.works.domain.model;

import java.util.LinkedList;
import java.util.List;

import com.thought.works.constants.Constants;
import com.thought.works.exceptions.DuplicatedEdgeException;
import com.thought.works.exceptions.NotExistingNodeException;
import com.thought.works.exceptions.WrongRailwaySectionException;

/**
 * This class represents a directed graph using an adjacency node list structure
 */
public class DirectedGraph {
	// List of directed graph nodes
	LinkedList<Node> nodeList;

	// Regular expression verifying edge name
	private static final String expr = "[A-E][A-E]\\d*[1-9]\\d*";

	private List<Node> getNodeList() {
		return nodeList;
	}

	@SuppressWarnings("unused")
	private void setNodeList(List<Node> nodeList) {
		this.nodeList = (LinkedList<Node>) nodeList;
	}

	public DirectedGraph() {
		this.nodeList = new LinkedList<Node>();
	}

	public DirectedGraph(List<Node> nodeList) {
		this.nodeList = (LinkedList<Node>) nodeList;
	}

	/**
	 * Class constructor initializer. Initialize a directed graph with a list of
	 * edges.
	 * 
	 * @param graphEdges
	 *            array of edges forming the directed graph
	 * @throws DuplicatedEdgeException
	 * @throws WrongRailwaySectionException
	 */
	public DirectedGraph(String[] graphEdges) throws DuplicatedEdgeException,
			WrongRailwaySectionException {
		nodeList = new LinkedList<Node>();

		for (String graphEdge : graphEdges) {
			if (graphEdge.matches(expr)) {
				String originNodeName = graphEdge.charAt(0) + "";
				String destinationNodeName = graphEdge.charAt(1) + "";
				Node node = getNode(originNodeName);
				Edge edge = null;
				if (node == null) {
					node = new Node();
					node.setLabel(originNodeName);
					nodeList.add(node);
				} else {
					edge = node.getEdgeWithNode(destinationNodeName);
				}

				if (edge != null) {
					throw new DuplicatedEdgeException(graphEdge);
				} else {
					Node destNode = getNode(destinationNodeName);
					if (destNode == null) {
						destNode = new Node();
						destNode.setLabel(destinationNodeName);
						nodeList.add(destNode);
					}
				}

				int weight = Integer.parseInt(graphEdge.substring(2,
						graphEdge.length()));
				edge = new Edge();
				edge.setNode(destinationNodeName);
				edge.setWeight(weight);

				node.getEdges().add(edge);

			} else {
				throw new WrongRailwaySectionException(graphEdge);
			}
		}
	}

	/**
	 * Returns the directed graph node with name "originNodeName" in case that
	 * it exists.
	 * 
	 * @param originNodeName
	 * @return
	 */
	private Node getNode(String originNodeName) {
		for (Node node : nodeList) {
			if (node.getLabel().equals(originNodeName)) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Compute the total weight for a given node path. If the path doesn't exist
	 * returns "NO SUCH ROUTE".
	 * 
	 * @param townsRoute
	 * @return
	 * @throws Exception
	 */
	public String computeRouteDistance(String[] townsString) throws Exception {

		if (townsString.length < 2) {
			throw new Exception(
					"At least there must be 2 towns in the railway network.");
		}

		int distance = 0;

		for (int i = 0; i < townsString.length - 1; i++) {
			Node currentNode = getNode(townsString[i]);
			if (currentNode == null) {
				throw new NotExistingNodeException(townsString[i]);
			}

			Edge edge = currentNode.getEdgeWithNode(townsString[i + 1]);
			if (edge == null) {
				return "NO SUCH ROUTE";
			}
			distance += edge.getWeight();
		}

		return distance + "";
	}

	/**
	 * Computes the lower distance between two nodes (origin-destination) from
	 * the directed graph. A min-heap structure is used in order to mantain the
	 * edges susceptibles to be followed by the algorithm when looking for the
	 * shortest path.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public int dijkstra(String source, String destination) {

		Node sourceNode = getNode(source);
		int sourceNodeIndex = (sourceNode.getLabel().charAt(0) - 'A');
		int destinationNodeIndex = destination.charAt(0) - 'A';

		int size = getNodeList().size();
		boolean[] visited = new boolean[size];
		int[] distance = new int[size];

		for (Node node : getNodeList()) {
			int index = node.getLabel().charAt(0) - 'A';
			distance[index] = Integer.MAX_VALUE;
			visited[index] = false;
		}

		int graphSize = getNodeList().size();
		Heap<Edge> heap = new Heap<Edge>(graphSize * (graphSize - 1));

		distance[sourceNodeIndex] = Integer.MAX_VALUE;

		for (Edge edge : sourceNode.getEdges()) {
			heap.insert(edge);
			int edgeNodeindex = edge.getNodeLabel().charAt(0) - 'A';
			distance[edgeNodeindex] = edge.getWeight();
		}

		while (heap.size() > 0) {
			Edge edge = (Edge) heap.remove();
			int destIndex = edge.getNodeLabel().charAt(0) - 'A';
			visited[destIndex] = true;
			Node newNode = getNode(edge.getNodeLabel());
			for (Edge g : newNode.getEdges()) {
				int destDestIndex = g.getNodeLabel().charAt(0) - 'A';
				if (!visited[destDestIndex]
						&& distance[destDestIndex] > distance[destIndex]
								+ g.getWeight()) {
					distance[destDestIndex] = distance[destIndex]
							+ g.getWeight();// distance[edge.getNodeLabel().charAt(0)-'A']
											// +
											// edge.getWeight();
					heap.insert(g);
				}
			}
		}

		return distance[destinationNodeIndex];

	}

	/**
	 * This method explores the directed graph counting then umber of existing
	 * routes between two nodes
	 * 
	 * @param origin
	 * @param destination
	 * @param numberSteps
	 * @param routeRestrictionType
	 * @return
	 */
	public int getNumRoutesBetweenTowns(String origin, String destination,
			int numberSteps, String routeRestrictionType) {
		Node originNode = getNode(origin);
		Node destNode = getNode(destination);
		return getNumRoutesBetweenTownsRec(originNode, destNode, numberSteps,
				routeRestrictionType, 0);
	}

	/**
	 * This method recursively explores the directed graph counting then umber
	 * of existing routes between two nodes. The search will be pruned according
	 * to the routerestrictionType.
	 * 
	 * @param current
	 * @param destination
	 * @param numSteps
	 * @param routeRestrictionType
	 * @param step
	 * @return
	 */
	private int getNumRoutesBetweenTownsRec(Node current, Node destination,
			int numSteps, String routeRestrictionType, int step) {

		int numRoutes = 0;
		if (Constants.ROUTE_RESTRICTION_EXACT == routeRestrictionType) {
			if (step == numSteps) {
				return current.getLabel().equals(destination.getLabel()) ? 1
						: 0;
			}
		} else if (Constants.ROUTE_RESTRICTION_MAX == routeRestrictionType) {
			if (step < numSteps + 1) {
				if (current.getLabel().equals(destination.getLabel())
						&& step != 0) {
					numRoutes++;
				}
			} else {
				return 0;
			}
		}

		for (Edge edge : current.getEdges()) {
			Node childNode = getNode(edge.getNodeLabel());
			numRoutes += getNumRoutesBetweenTownsRec(childNode, destination,
					numSteps, routeRestrictionType, step + 1);
		}

		return numRoutes;
	}

	/**
	 * This method invokes an algorithm performing an in-deph search on the
	 * number of paths between two nodes and taking into account that they never
	 * exceed the "maxDistance" weight.
	 * 
	 * @param origin
	 * @param destination
	 * @param maxDistance
	 * @return
	 */
	public int getNumRoutesInLessDistance(String origin, String destination,
			int maxDistance) {
		Node originNode = getNode(origin);
		Node destNode = getNode(destination);
		int accumulateDistance = 0;
		return getNumRoutesInLessDistanceRec(originNode, destNode, maxDistance,
				accumulateDistance);
	}

	/**
	 * This method performs an in-deph recursive search on the number of paths
	 * between two nodes and taking into account that they never exceed the
	 * "maxDistance" weight.
	 * 
	 * @param current
	 * @param destination
	 * @param maxDistance
	 * @param accumulatedDistance
	 * @return
	 */
	private int getNumRoutesInLessDistanceRec(Node current, Node destination,
			int maxDistance, int accumulatedDistance) {
		if (accumulatedDistance >= maxDistance) {
			return 0;
		} else {
			int numRoutes = 0;
			if (current.getLabel().equals(destination.getLabel())
					&& accumulatedDistance != 0) {
				numRoutes++;
			}
			for (Edge edge : current.getEdges()) {
				Node childNode = getNode(edge.getNodeLabel());
				numRoutes += getNumRoutesInLessDistanceRec(childNode,
						destination, maxDistance,
						accumulatedDistance + edge.getWeight());
			}
			return numRoutes;
		}
	}

	/**
	 * Returns a string representing containing a list of nodes the graph has.
	 * 
	 * @return
	 */
	public String printToSpring() {
		String str = "";
		for (Node nod : getNodeList()) {
			str = str + nod.getLabel();
		}
		return str;
	}
}
