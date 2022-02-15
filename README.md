# Directed Weighted Graph, Algorithms and GUI

This program is an implementation of a directed weighted graphs written in java.
The program also implements algorithms which can be applied on the graph, and a GUI menu.

## Features
- Create, add and remove vertices.
- Create, add and remove edges.
- Build a directed weighted graph.
- Initialize a graph from a json file.
- Saves the graph to a json file.
- Run algorithms on a directed weighted graph.
- GUI menu with the programs features and a graph display

## How to run the program
- Jar file name: Graph and Algo Java.jar
- The jar file must be in the project folder

Run Jar file  in commend line:

```
java -jar Graph and Algo Java.jar G1.json
```

## Packages
### BaseElements

#### Vertex
This class represents a vertex in a directed weighted graph.
Class variables:
- key - Vertex's id
- location - Geo Location of the vertex
- tag

#### Edge
This class represents an edge in a directed weighted graph.
This class is an implementation of the EdgeData interface.
Class variables:
- src - the source vertex
- dest - the destination vertex
- weight - the Weight of edge

#### GeoLocation
This class represents a geographic location of a vertex in a directed weighted graph.

### GraphAndAlgo
#### Graph
This class represents a directed weighted graph.
Class variables:
- vertices - Collection of all the graph vertices
- edges - Collection of all the graph edges

#### GraphAlgp
This class represents a Graph Theory algorithms.
- init(DirectedWeightedGraph g) - Initialize a graph.
- getGraph() - Returns the underlying graph of which this class works.
- copy() - Computes a deep copy of this weighted graph.
- isConnected() - Check if the graph is connected, using [Depth First Search.](https://www.geeksforgeeks.org/check-if-a-directed-graph-is-connected-or-not/)
- shortestPathDist(int src, int dest) - Returns the length of the shortest path between 2 vertices, using [Dijkstra's algorithm.](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)
- shortestPath(int src, int dest) - Returns the shortest path between 2 vertices, using [Dijkstra's algorithm.](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)
- center() - Finds the NodeData which minimizes the max distance to all the other nodes.
- [tsp(List cities)](https://en.wikipedia.org/wiki/Travelling_salesman_problem) - Computes a list of consecutive nodes which go over all the nodes in cities.
- [save(String file)](https://attacomsian.com/blog/gson-write-json-file) - Saves this weighted (directed) graph to the given file name - in JSON format, returns true if the file was successfully saved.
- [load(String file)](https://attacomsian.com/blog/gson-read-json-file) - This method loads a graph to this graph algorithm, returns true if the graph was successfully loaded.

### Json
- EdgeJson - converts a json file to an edge and vice versa
- VertexJson - converts a json file to a node and vice versa
- GraphJson - converts a json file to a graph and vice versa

### Tests
- VertexTest - JUnit test class for Vertex class's functions
- EdgeTest - JUnit test class for Edge class's functions
- GeoLocationTest - JUnit test class for geoLoc class's functions
- GraphTest - JUnit test class for Graph class's functions
- GraphAlgoTest - JUnit test class for GraphAlgo class's functions

### GraphGUI
This package is the main program of the GUI menu and features. MyFrame extends JFrame, and with MyPanel (an extension of JPanel) display the user the DWG.
#### LoginPage
LoginPage creates the main menubar, were the user can choose out of this 3 choices:

##### File
filePage creates a new frame with a menubar, were the user can load and save a json file from their computer's files or from the commit file.
Furthermore, the menu gives the user an option to create an empty graph.

##### Edit Graph
EditGraph creates a new frame with a menubar, were the user can choose out of these 4 options:
- Add new Node - this option will open a new frame with a text boxes, were the user writes the new node's ID
  and position(represents a geo location <x,y,z>).
- Add new Edge - this option will open a new frame with a text boxes, were the user writes the
  new edge's source, destination and weight.
- Remove Node - this option will open a new frame with a text boxes, were the user writes the ID of the required node to remove.
- Remove Edge - this option will open a new frame with a text boxes, were the user writes the source and destination of the required edge to remove.

##### Run Graph's Algorithm
AlgoGraph creates a new frame of a menubar including all the DWGA's algorithms.
- Check if the graph is connected - "This graph is connected" will be displayed if the graph is connected, and "This graph is not connected"
  will be displayed if otherwise.
- Get the distance of the shortest path - this option will open a new frame with a text boxes, were the user writes the
  source and destination of the wanted path.
- Get the shortest path - this option will open a new frame with a text boxes, were the user writes the
  source and destination of the wanted path. By clicking the enter button the result will be displayed to the user.
- Get graph's center - the graph's center will displayed to the user.
- TSP - this option will open a new frame with a text boxes, were the user writes a list of nodes ID (e.g. 1,2,3).
  By clicking the enter button the result will be displayed to the user.

## Performance
### Building graphs
- 10 Vertices 90 Edges: 1 ms
- 100 Vertices 1,000 Edges: 1 ms
- 1,000 Vertices 10,000 Edges: 50 ms
- 10,000 Vertices 100,000 Edges: 1 sec 964 ms
- 100,000 Vertices 1,000,000 Edges: 2 sec 456 ms
- 1,000,000 Vertices 10,000,000 Edges: 19 sec

### Running the Algorithms
##### isConnected()
- 10 Vertices 90 Edges: 120 ms
- 100 Vertices 1,000 Edges: 139 ms
- 1,000 Vertices 10,000 Edges: 413 ms
- 10,000 Vertices 100,000 Edges: 46 sec 409 ms
- 100,000 Vertices 2,000,000 Edges: timeout
- 1,000,000 Vertices 10,000,000 Edges: timeout

##### Center()
- 10 Vertices 90 Edges: 189 ms
- 100 Vertices 1,000 Edges: 402 ms
- 1,000 Vertices 10,000 Edges: 4 min 49 sec
- 10,000 Vertices 100,000 Edges: timeout
- 100,000 Vertices 1,000,000 Edges: timeout
- 1,000,000 Vertices 10,000,000 Edges: timeout

_External libraries:_
- gson-2.8.6
- JUnit4
- JUnit5.7.0