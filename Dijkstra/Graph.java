package Dijkstra;

import java.util.*;
import java.io.*;

public class Graph {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(new File("Graph.txt"));
        int size = 10;
        String original[] = new String[size + 1];
        for (int z = 0; z <= size; z++) {
            original[z] = read.nextLine();
        }
        read.close();
        int[][] array = new int[size][size];
        for (int i = 1; i <= size; i++) { // load up the data into array
            for (int j = 1; j <= size; j++) {
                array[i - 1][j - 1] = Integer.parseInt(original[i].split("\t")[j]);
            }
        }
        int furthestdistance = 0; // keep track of the longest path found so far
        String furthestroute = "";
        for (int i = 0; i < size; i++) { // loop through all possible starting positions
            int visited = 0; // how many vertices have been visited so far?
            Vertex[] vertices = new Vertex[size]; // initiate the vertex objects
            for (int j = 0; j < size; j++) {
                vertices[j] = new Vertex(original[0].split("\t")[j + 1]);
            }
            vertices[i].visited = true; // we visit the starting position
            visited++; // we've visited one vertex so far
            vertices[i].distance = 0; // set this vertex as starting point
            for (int j = 0; j < size; j++) { // update distances from starting point
                if (array[j][i] > 0) { // only update those that can be reached from here
                    vertices[j].distance = array[j][i];
                }
            }
            while (visited < size) { // while not all vertices visited
                // …fill this in

            }
            for (int x = 0; x < size; x++) { // check for a new record distance
                if (vertices[x].distance > furthestdistance) { // go through all distances in the graph
                    furthestdistance = vertices[x].distance;
                    int visiting = x;
                    String solution = ""; // build up the path taken to get this particular record beating distance
                    while (visiting >= 0) { // the starting position has route of -1
                        solution = vertices[visiting].label + "" + solution;
                        visiting = vertices[visiting].route; // step back along the route taken to generate this
                                                             // distance
                    }
                    solution = vertices[i].label + "" + solution; // this is the starting position
                    furthestroute = solution; // keep track of this record path
                }
            }
        }
        System.out.println(furthestdistance); // print out the results
        System.out.println(furthestroute);
    }
}

class Vertex { // everything you need for a vertex
    public boolean visited = false; // has it been visited?
    int distance = Integer.MAX_VALUE; // the shortest route from starting position to this vertex
    int route = -1; // keep track of the last step taken to reach this vertex for the shortest path
                    // - what vertex did it come from?
    String label; // name of the vertex

    public Vertex(String labelin) { // give the vertex a name when instantiated
        label = labelin;
    }
}