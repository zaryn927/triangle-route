/**
 * 
 */
package edu.cnm.deepdive.triangle;

//import java.util.Arrays;

/**
 * @author Sky Link
 *
 */
public class Solver {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Data data = new Data("data/data.txt");
    //System.out.println(Arrays.toString(data.nodes));
    Route[] routes = null;
    for (int i = data.nodes.length - 1; i >= 0; i--) {
      routes = processRow(data.nodes[i], routes);
    }
    System.out.printf("Minimum route cost = %,d%n", routes[0].cumulativeCost);
    System.out.print("Steps: ");
    for (Route trace = routes[0]; trace != null; trace = trace.optimal) {
      System.out.print(trace.direction);
    }
  }
  
  private static Route[] processRow(int[] costs, Route[] routesBelow) {
    Route[] result = new Route[costs.length];
    if (routesBelow == null) {
      for (int i = 0; i < costs.length; i++) {
        result[i] = new Route(costs[i]);
      }
    } else {
      for (int i = 0; i < costs.length; i++) {
        result[i] = new Route(costs[i], routesBelow[i], routesBelow[i + 1]);
      }
    }
    return result;
  }
}
