package com.thought.works.domain;

import com.thought.works.domain.model.DirectedGraph;

public class RailwayNetwork {

	private DirectedGraph railwayNetGraph;

	public RailwayNetwork() {
	}

	/**
	 * Initializate a new RailwayNetwork
	 * 
	 * @param textRailwayNetwork
	 *            comma separated string where every element represents a
	 *            section of a railwayNetwork (edge of a directed graph)
	 * @throws Exception
	 */
	public RailwayNetwork(String textRailwayNetwork) throws Exception {

		String[] graphEdges = textRailwayNetwork.toUpperCase()
				.replaceAll(" ", "").split(",");

		if (graphEdges.length < 2) {
			throw new Exception(
					"At least there must be 2 towns in the railway network.");
		}

		railwayNetGraph = new DirectedGraph(graphEdges);

	}

	/**
	 * Returns the addition of distances between the towns of a given town
	 * route.
	 * 
	 * @param townsRoute
	 *            comma separated list of towns
	 * @return
	 * @throws Exception
	 */
	public String computeRouteDistance(String townsRoute) throws Exception {
		String[] townsString = townsRoute.toUpperCase().replaceAll(" ", "")
				.split("-");
		return railwayNetGraph.computeRouteDistance(townsString);
	}

	/**
	 * Returns the shortest distance between two towns in the railwayNetwork.
	 * 
	 * @param source
	 *            origin town name
	 * @param destination
	 *            town name
	 * @return
	 */
	public int dijkstra(String source, String destination) {
		return railwayNetGraph.dijkstra(source, destination);
	}

	/**
	 * Returns the number of routes between town "origin" and town "destination"
	 * with a maximum or exact (routeRestrictionType) number of "numberSteps".
	 * 
	 * @param origin
	 * @param destination
	 * @param numberSteps
	 * @param routeRestrictionType
	 * @return
	 */
	public int getNumRoutesBetweenTowns(String origin, String destination,
			int numberSteps, String routeRestrictionType) {
		return railwayNetGraph.getNumRoutesBetweenTowns(origin, destination,
				numberSteps, routeRestrictionType);
	}

	/**
	 * Returns the number of routes between a town "origin" and town
	 * "destination" whose result distance is less than "maxDistance"
	 * 
	 * @param origin
	 * @param destination
	 * @param maxDistance
	 * @return
	 */
	public int getNumRoutesInLessDistance(String origin, String destination,
			int maxDistance) {
		return railwayNetGraph.getNumRoutesInLessDistance(origin, destination,
				maxDistance);
	}
}
