package com.thought.works.domain;

import org.junit.Assert;
import org.junit.Test;

import com.thought.works.constants.Constants;
import com.thought.works.domain.RailwayNetwork;

public class RailwayNetworkTest {

	/**
	 * Test that a RailwayNetwork and the internal directedGraph structure is
	 * properly created without problems
	 */
	@Test
	@SuppressWarnings("unused")
	public void testRailwayNetworkGraphCreation() {

		try {
			RailwayNetwork railwayNetwork = new RailwayNetwork(
					"AD6,AE3,AC2,BA5,CB2");
		} catch (Exception e) {
			Assert.fail();
		}

		// Nothing else to test by now
	}

	/**
	 * Test that the dijkstra algorithm to get the shortest path between two
	 * towns (nodes) is properly implemented
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDijkstra() throws Exception {
		// Test1
		RailwayNetwork railwayNetwork = new RailwayNetwork(
				"AD6,AE3,AC2,BA5,CB2");

		Assert.assertTrue(railwayNetwork.dijkstra("A", "C") == 2);
		Assert.assertTrue(railwayNetwork.dijkstra("B", "B") == 9);

		// Test2
		railwayNetwork = new RailwayNetwork("AD6, AE3, AC2, AB5, CB2");

		Assert.assertTrue(railwayNetwork.dijkstra("A", "C") == 2);
		Assert.assertTrue(railwayNetwork.dijkstra("B", "B") == Integer.MAX_VALUE);

		// Test3
		railwayNetwork = new RailwayNetwork(
				"AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");

		Assert.assertTrue(railwayNetwork.dijkstra("A", "C") == 9);
		Assert.assertTrue(railwayNetwork.dijkstra("B", "B") == 9);
	}

	/**
	 * Test that the algorithm to compute a town route is properly implmented
	 * 
	 * @throws Exception
	 */
	@Test
	public void testComputeRouteDistance() throws Exception {
		RailwayNetwork railwayNetwork = new RailwayNetwork(
				"AD6,AE3,AC2,BA5,CB2");

		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-B-C").equals(
				"NO SUCH ROUTE"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-D")
				.equals("6"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-D-C").equals(
				"NO SUCH ROUTE"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-E-B-C-D")
				.equals("NO SUCH ROUTE"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-E-D").equals(
				"NO SUCH ROUTE"));

		// Test2
		railwayNetwork = new RailwayNetwork("AD6, AE3, AC2, AB5, CB2");

		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-B-C").equals(
				"NO SUCH ROUTE"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-D")
				.equals("6"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-D-C").equals(
				"NO SUCH ROUTE"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-E-B-C-D")
				.equals("NO SUCH ROUTE"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-E-D").equals(
				"NO SUCH ROUTE"));

		// Test3
		railwayNetwork = new RailwayNetwork(
				"AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");

		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-B-C").equals(
				"9"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-D")
				.equals("5"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-D-C").equals(
				"13"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-E-B-C-D")
				.equals("22"));
		Assert.assertTrue(railwayNetwork.computeRouteDistance("A-E-D").equals(
				"NO SUCH ROUTE"));

	}

	/**
	 * Tests that the method that calculates the number of routes between two
	 * towns is properly implemented.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNumRoutesBetweenTowns() throws Exception {
		// Test1
		RailwayNetwork railwayNetwork = new RailwayNetwork(
				"AD6,AE3,AC2,BA5,CB2");

		Assert.assertTrue(railwayNetwork.getNumRoutesBetweenTowns("C", "C", 3,
				Constants.ROUTE_RESTRICTION_MAX) == 1);
		Assert.assertTrue(railwayNetwork.getNumRoutesBetweenTowns("A", "C", 4,
				Constants.ROUTE_RESTRICTION_EXACT) == 1);

		// Test2
		railwayNetwork = new RailwayNetwork("AD6, AE3, AC2, AB5, CB2");

		Assert.assertTrue(railwayNetwork.getNumRoutesBetweenTowns("C", "C", 3,
				Constants.ROUTE_RESTRICTION_MAX) == 0);
		Assert.assertTrue(railwayNetwork.getNumRoutesBetweenTowns("A", "C", 4,
				Constants.ROUTE_RESTRICTION_EXACT) == 0);

		// Test3
		railwayNetwork = new RailwayNetwork(
				"AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");

		Assert.assertTrue(railwayNetwork.getNumRoutesBetweenTowns("C", "C", 3,
				Constants.ROUTE_RESTRICTION_MAX) == 2);
		Assert.assertTrue(railwayNetwork.getNumRoutesBetweenTowns("A", "C", 4,
				Constants.ROUTE_RESTRICTION_EXACT) == 3);

	}

	/**
	 * Tests that the method retrieving the number of routes between two towns
	 * in less distance than a given value is properly implmented.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetNumRoutesInLessDistance() throws Exception {
		RailwayNetwork railwayNetwork = new RailwayNetwork(
				"AD6,AE3,AC2,BA5,CB2");

		// Test1
		Assert.assertTrue(railwayNetwork.getNumRoutesInLessDistance("C", "C",
				30) == 3);

		// Test2
		railwayNetwork = new RailwayNetwork("AD6, AE3, AC2, AB5, CB2");
		Assert.assertTrue(railwayNetwork.getNumRoutesInLessDistance("C", "C",
				30) == 0);

		// Test3
		railwayNetwork = new RailwayNetwork(
				"AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");

		Assert.assertTrue(railwayNetwork.getNumRoutesInLessDistance("C", "C",
				30) == 7);

	}

}
