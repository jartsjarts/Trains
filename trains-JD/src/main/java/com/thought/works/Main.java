package com.thought.works;

import java.util.Scanner;

import com.thought.works.constants.Constants;
import com.thought.works.domain.RailwayNetwork;

public class Main {

	/**
	 * Input Preconditions: 
	 * - There are no negative distances 
	 * - All tracks are 1 way -
	 * - Route from Kaitaia to Invercargill does not imply the existence of a
	 * route from Invercargill to Kaitaia. 
	 * - No repeated routes 
	 * - No routes from a town to the same town
	 * - e.g: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
	 * 
	 * Output: 
	 * - Compute the distance along a certain route. 
	 * - Number of different routes between two towns and a fixed number of stops. 
	 * - Shortest route between two towns. 
	 * - Number of different routes between two towns with distance lower than X
	 **/
	public static void main(String[] args) throws Exception {
		if (args.length > 0 && args[0].equals("-help")) {
			System.out
					.println("NOTICE: In order to run this application, a directed graph representing a railway network needs to be provided.\n"
							+ "The network must be inserted as an application parameter by means of a directed graph representation. \n"
							+ "In order to do so, enter the sequence representing the directed graph following the comma separated format:"
							+ "\n\ne.g: AB2,BC2... where letters A B represents the origin (A) and destination town (B) and 2 the distance between them.\n");
		} else {
			welcomePresentation();
			System.out.println("Please enter the railway network:");

			Scanner sc = new Scanner(System.in);
			String textRailwayNetwork = sc.nextLine();
			sc.close();

			if (textRailwayNetwork == null || textRailwayNetwork.isEmpty()) {
				System.out
						.println("You need to provide a right directed graph (-help for more information).");
			} else {

				// Directed Graph parse creation
				RailwayNetwork railwayNetwork = new RailwayNetwork(
						textRailwayNetwork);

				String result = "";

				result = railwayNetwork.computeRouteDistance("A-B-C");
				System.out.println("#1: " + result);

				result = railwayNetwork.computeRouteDistance("A-D");
				System.out.println("#2: " + result);

				result = railwayNetwork.computeRouteDistance("A-D-C");
				System.out.println("#3: " + result);

				result = railwayNetwork.computeRouteDistance("A-E-B-C-D");
				System.out.println("#4: " + result);

				result = railwayNetwork.computeRouteDistance("A-E-D");
				System.out.println("#5: " + result);

				result = railwayNetwork.getNumRoutesBetweenTowns("C", "C", 3,
						Constants.ROUTE_RESTRICTION_MAX) + "";
				System.out.println("#6: " + result);

				result = railwayNetwork.getNumRoutesBetweenTowns("A", "C", 4,
						Constants.ROUTE_RESTRICTION_EXACT) + "";
				System.out.println("#7: " + result);

				result = railwayNetwork.dijkstra("A", "C") + "";
				if (result.equals(Integer.MAX_VALUE + "")) {
					result = "NO SUCH ROUTE";
				}
				System.out.println("#8: " + result);

				result = railwayNetwork.dijkstra("B", "B") + "";
				if (result.equals(Integer.MAX_VALUE + "")) {
					result = "NO SUCH ROUTE";
				}
				System.out.println("#9: " + result);

				result = railwayNetwork
						.getNumRoutesInLessDistance("C", "C", 30) + "";
				System.out.println("#10: " + result);

			}

			System.out.println("Execution ends successfully.");
		}
	}

	private static void welcomePresentation() {
		System.out.println("" +

				"                           '@@@@#@@@@@:                                                                   \n"
				+ "                         @''''''''''''''@                                                                 \n"
				+ "                         @+++++++++++++@                                                                 \n"
				+ "        ;''#@             @;;;;;;;;;;;@                                                                  \n"
				+ "      `@#@@@@#            @;;;;;;;;;;;@                                                                  \n"
				+ "      .:;;;''@            @'.........;@                                                                  \n"
				+ "      .;;;;''@            @'`  ``````;@    @@@@@@@@@@@@@@@@@@@@@@@@@@     @@@@@@@@@@@@@@@@@@@@@@@@@@     \n"
				+ "       .''''@             @'` `````..;@    '`;;;;;;;;;;;;;;;;;;;;;;;@     #`;;;;;;;;;;;;;;;;;;;;;;;@     \n"
				+ "       ..;;'@             @'``````...'@    ';;;;;;;;;;;;;;;;;;;;;;;;@     #:;;;;;;;;;;;;;;;;;;;;;;;@     \n"
				+ "       ..;;'@             @'`````....'@    ''``````@@``````'@``````'@     #;``````@+``````@@``````'@     \n"
				+ "   `   ;:''+@::::::::::   @'```......'@    ''` ````@@  ````'@  ````'@     #;`  ```@+` ````@@` ````'@     \n"
				+ "     @'''#;,....,,,;;;;': @'```......'@    ''` ````@@ `````'@ `````'@     #;` ````@+``````@@``````'@     \n"
				+ "    +,,,'@;;;;;;;;;;;;;'#+@'``.......'@    ''`````.@@ ````.'@ ````.'@     #;``````@+``````@@ ````.'@     \n"
				+ "    @+++';;;;;;;;;;;;;;'#'@'@@@@@@@@@'@    ''````..@@`````.'@````..'@     #;`````.@+`````.@@````..'@     \n"
				+ "    ''''+;;;;;;;;;;;;;;'#'@;;;;;;;''''@    ''```...@@```...'@```...'@     #;````..@+````..@@```...'@     \n"
				+ "   ,''''@;;;;;;;;;;;;;;'#'@;;;;;;'''''@    ''@@@@@@@@@@@@@@'@@@@@@@'@     #;@@@@@@@+@@@@@@@@@@@@@@'@     \n"
				+ "   @''''@;;;;;;;;;;;;;;'#'@;;;;;;'''''@    ';;;;;;;;;;;;;;''''''''''@     #;;;;;;;;;;;;;;''''''''''@     \n"
				+ "   @''''@;;;;;;;;;;;;;;'#'@;;;;;;'''''@    ';;;;;;;;;;;;''''''''''''@     #;;;;;;;;;;;;;'''''''''''@     \n"
				+ "   @''''@;;;;;;;;;;;;;;'#'@;;;;;''''''@    ';;;;;;;;;;;'''''''''''''@     #;;;;;;;;;;;'''''''''''''@     \n"
				+ "   @####@;;;;;;;;;;;;;;'#'@;;;;;''''''@    ';;;;;;;;;;''''''''''''''@     #;;;;;;;;;;''''''''''''''@     \n"
				+ "   @####@'''''''''''''''##@;;;;;''''''@    ';;;;;;;;;'''''''''''''''@     #;;;;;;;;;'''''''''''''''@     \n"
				+ "   @####@'''''''''''''''##@;;;;'''''''@    ';;;;;;;;''''''''''''''''@     #;;;;;;;;''''''''''''''''@     \n"
				+ "   +####@'''''''''''''''##@+@@@#''''''@    ';;;;;;;'''''''''''''''''@     #;;;;;;;'''''''''''''''''@     \n"
				+ "    #####'''''''''''''''#@#'''''+@''''@    ';;;;;'''''''''''''''''''@     #;;;;;;''''''''''''''''''@     \n"
				+ "    @+####@@@@@@@@@@@@@@@';;;;;;;'@'''@''@ ';;;;''''''''''''''''''''@@'', #;;;;''''''''''''''''''''@.''@ \n"
				+ "     ;#################@';;''''';;'@''@+@@ ';;;'''''''''''''''''''''@@'', #;;;'''''''''''''''''''''@.''@ \n"
				+ "   @#@+++++++++++++++++@;;'''''''';'++@++''';;''''''''''''''''''''''@'+@''#;;''''''''''''''''''''''@'':` \n"
				+ "  @.,@''''''''''''''''+';''''''''';'@''++++';'''''''''''''''''''''''@++@++#;'''''''''''''''''''''''@++.  \n"
				+ " .,;;@''''''''''''''''@';'''###''';;@@+,  +@@@@@@@@@@@@@@@@@@@@@@@@@@:   .@@@@@@@@@@@@@@@@@@@@@@@@@@@    \n"
				+ " @;'@@@@@@@@@@@@@@@@@@@';'''###+''';#    #::::::::::::::::::::::::::::. .;:::::::::::::::::::::::::::@   \n"
				+ "#;;'@@@'##@@@@@@@@@+@@@';'''###'''';@    @:@@@@@@@@@@@@@`@@@@@@@@@@@@'@ :;@@@@@@@@@@@@@`@@@@@@@@@@@@@@   \n"
				+ "@;''@@'.@+++++++##@.'@@';''''+'''';'@     @:@''@@@@#'+@' @#'+@@@@''@@.   ; @''@@@@@''@@ @@''@@@@+'#@     \n"
				+ "';''@@.+'';'@@@,+''+:@@#;;'''''''';',      @''''@@+'''': +''''@@''''@     @''''@@@''''@ @''''@@''''+     \n"
				+ "@@@@@@.'+'+;@@@,'+++,@@@';;'''''';'@       +'##'+'''#''@;''#''@@'+#''`    @'+#'',''#+'@ ''#+'@@''#'';    \n"
				+ "     @',''.', @+.''.+'  @';;;';;;'@        #'++'#;''+''@:''+''@@''+''     @''+'' ''+''@ ''+''@@''+'':    \n"
				+ "      @'..+@   @'..+@    @+';;;''@         @''''@ @'''+  @'''+ ;''''@     ;''''@ @'''': @''''; +'''@     \n"
				+ "       @@@@     @@@@       @@@@@.           @@@@   @@@`   @@@`  ;@@@       ;@@@   @@@;   @@@;  `@@@\n");

		System.out.println("Welcome to Kiwiland Commuter railroad route information provider: ");

	}

}
