package GraphAndAlgo;

import BaseElements.Edge;
import BaseElements.Vertex;
import Json.GraphJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphAlgo {
    Graph g;
    private int connected = -1;

    // A HashMap with all the nodes distances --> <src, <dest, distance>>
    private HashMap<Integer, HashMap<Integer,Double>> graphDistance = new HashMap<>();

    public void init(Graph g) {
        this.g = g;
    }

    public boolean isEmpty(){
        return (this.g == null);
    }

    public Graph getGraph() {
        return this.g;
    }

    public Graph copy() {
        return new Graph(this.g);
    }

    public boolean isConnected() {
        int edges = this.g.edgeSize();
        int nodes = this.g.nodeSize();

        // a connected graph with n vertex must have at list n-1 edges
        if(edges < nodes-1){
            this.connected = 0;
            return false;
        }

        DFS((Vertex)g.getNode(0));

        Iterator iter = this.getGraph().nodeIter();
        while (iter.hasNext()){
            Vertex next_node = (Vertex) iter.next();
            if(next_node.getTag() == 0){
                this.connected = 0;
                return false;
            }
        }

        this.connected = 1;
        return true;
    }

    private void DFS(Vertex n){
        n.setTag(1);

        Iterator iter = g.edgeIter(n.getKey());
        while (iter.hasNext()){
            Edge edge = (Edge) iter.next();
            Vertex nd = (Vertex) g.getNode(edge.getDest());
            if(nd.getTag() == 0){
                DFS(nd);
            }
        }
        n.setTag(2);
    }

    public double shortestPathDist(int src, int dest) {
        if(src == dest){
            return 0;
        }

        if(!this.graphDistance.isEmpty() && this.graphDistance.get(src) != null
                && this.graphDistance.get(src).get(dest) != null
                && this.graphDistance.get(src).get(dest) != Double.MAX_VALUE){
            return this.graphDistance.get(src).get(dest);
        }

        // distance from src to the other nodes in the graph
        HashMap<Integer,Double> distance = new HashMap<>();

        Iterator iter = this.g.nodeIter();
        distance.put(src,0.0);

        while (iter.hasNext()){
            Vertex temp = (Vertex) iter.next();
            int temp_key = temp.getKey();
            this.g.getNode(temp_key).setTag(0);

            if(temp_key != src) {
                // if there's an edge between src and dest then put the weight of the edge
                if (g.getEdge(src, temp_key) != null) {
                    distance.put(temp_key, g.getEdge(src, temp_key).getWeight());
                } else {
                    distance.put(temp_key, Double.MAX_VALUE);
                }
            }
        }

        while(this.g.getNode(dest).getTag() != 1) {
            int index = lowestDist(distance);
            if (index == -1) {
                return distance.get(dest);
            }
            else {
                Dijkstra_algorithm(index, distance);
                this.graphDistance.put(src,distance);
                this.g.getNode(index).setTag(1);
            }
        }
        return distance.get(dest);
    }

    // returns the node's key with the lowest distance and tag=0(wasn't used)
    private int lowestDist(HashMap<Integer,Double> distance){
        double ans = Double.MAX_VALUE;
        int index = -1;

        for (Map.Entry<Integer, Double> integerDoubleEntry : distance.entrySet()) {
            Integer key = (Integer) ((Map.Entry) integerDoubleEntry).getKey();
            Double value = (Double) ((Map.Entry) integerDoubleEntry).getValue();
            if (this.g.getNode(key).getTag() == 0) {
                if (value < ans) {
                    ans = value;
                    index = key;
                }
            }
        }
        return index;
    }

    private void Dijkstra_algorithm(int index, HashMap<Integer,Double> dist){
        double distance = dist.get(index);
        double new_dist = -1;
        Iterator<Edge> iter = g.edgeIter(index);

        // process all neighbouring nodes of next_node
        while (iter.hasNext()){
            Edge current = (Edge) iter.next();
            int dest_note = current.getDest();

            new_dist = distance + g.getEdge(index, dest_note).getWeight();

            // compare distances and change if needed
            if (new_dist < dist.get(dest_note)) {
                dist.put(dest_note, new_dist);
            }
        }
    }

    public List<Vertex> shortestPath(int src, int dest) {
        List<Vertex> path = new LinkedList<>();

        HashMap<Integer,Double> distance = new HashMap<>();
        int[] prev = new int[g.nodeSize()];
        Arrays.fill(prev, -2);

        Iterator<Vertex> iter = this.g.nodeIter();

        while (iter.hasNext()){
            Vertex temp = (Vertex) iter.next();
            int temp_key = temp.getKey();
            this.g.getNode(temp_key).setTag(0);

            if(temp_key == src){
                distance.put(src,0.0);
            }
            else if(g.getEdge(src,temp.getKey()) != null){
                distance.put(temp_key,g.getEdge(src,temp.getKey()).getWeight());
            }
            else {
                distance.put(temp_key,Double.MAX_VALUE);
            }
        }

        while(this.g.getNode(dest).getTag() != 1) {
            int index = lowestDist(distance);
            if (index == -1) {
                return null;
            } else {
                Dijkstra_algorithmPath(index, distance,prev);
                this.g.getNode(index).setTag(1);
            }
        }

        while(prev[dest] != prev[src]){
            path.add(g.getNode(dest));
            dest = prev[dest];
        }
        path.add(g.getNode(dest));
        path.add(g.getNode(src));

        return flipList(path);
    }

    private void Dijkstra_algorithmPath(int index, HashMap<Integer,Double> dist,int[] prev){
        double distance = dist.get(index);
        double newDistance = -1;
        Iterator<Edge> iter = g.edgeIter(index);

        // process all neighbouring nodes of next_node
        while (iter.hasNext()){
            Edge current = (Edge) iter.next();
            int dest_note = current.getDest();

            newDistance = distance + g.getEdge(index, dest_note).getWeight();

            // compare distances and change if needed
            if (newDistance < dist.get(dest_note)) {
                dist.put(dest_note,newDistance);
                prev[dest_note] = index;
            }
        }
    }

    private List<Vertex> flipList(List<Vertex> path){
        List<Vertex> ans = new LinkedList<>();
        while(path.size() != 0){
            ans.add(path.get(path.size()-1));
            path.remove(path.size()-1);
        }
        return ans;
    }

    public Vertex center() {
        if(this.g.nodeSize() == 0){
            return null;
        }
        if(this.g.nodeSize() == 1){
            return this.g.nodeIter().next();
        }
        if(this.connected == -1){
            this.isConnected();
        }

        if(this.connected == 1){
            double max = 0;
            double MaxValue = Double.MIN_VALUE;
            double minOfMax = Double.MAX_VALUE;
            int ans = 0;

            Iterator<Vertex> iter = this.g.nodeIter();
            while (iter.hasNext()){
                Vertex current_node = (Vertex) iter.next();
                int key = current_node.getKey();

                max = 0;
                MaxValue = Double.MIN_VALUE;
                Iterator<Vertex> iter2 = this.g.nodeIter();
                while (iter2.hasNext()){
                    Vertex next_node = (Vertex) iter2.next();
                    int next_node_key = next_node.getKey();

                    if(!this.graphDistance.isEmpty() && this.graphDistance.get(key) != null
                            && this.graphDistance.get(key).get(next_node_key) != null
                            && this.graphDistance.get(key).get(next_node_key) != Double.MAX_VALUE){
                        max = this.graphDistance.get(key).get(next_node_key);
                    }
                    else if(key != next_node_key) {
                        max = shortestPathDist(key, next_node_key);
                    }

                    if(max > MaxValue){
                        MaxValue = max;
                    }
                }
                if(MaxValue < minOfMax){
                    minOfMax = MaxValue;
                    ans = key;
                }
            }
            return g.getNode(ans);
        }

        else if(this.connected == 0){
            return null;
        }
        return null;
    }

    public List<Vertex> tsp(List<Vertex> cities) {
        if(cities.isEmpty()){
            throw new NullPointerException();
        }
        int numberOfCities;

        // removing duplicates
        Set<Vertex> set = new HashSet<>(cities);
        cities.clear();
        cities.addAll(set);

        List<Vertex> pathAns = new LinkedList<>();
        List<Vertex> tempPath =new LinkedList<>();
        double cost = Double.MAX_VALUE;
        double tempSPD = 0;

        Vertex startNode = cities.get(0);
        cities.remove(0);
        int currentNode = 0;
        pathAns.add(startNode);

        while(!cities.isEmpty()){
            int startNodeKey = startNode.getKey();
            numberOfCities = cities.size();
            for(int i = 0; i < numberOfCities; i++){
                int next_node_key =  cities.get(i).getKey();

                if(!this.graphDistance.isEmpty() && this.graphDistance.get(startNodeKey) != null
                        && this.graphDistance.get(startNodeKey).get(next_node_key) != null
                        && this.graphDistance.get(startNodeKey).get(next_node_key) != Double.MAX_VALUE){
                    tempSPD = this.graphDistance.get(startNodeKey).get(next_node_key);
                }
                else {
                    tempSPD = shortestPathDist(startNodeKey, cities.get(i).getKey());
                }

                if(tempSPD < cost){
                    cost = tempSPD;
                    tempPath = shortestPath(startNodeKey,cities.get(i).getKey());
                    tempPath.remove(0);
                    currentNode = i;
                }
            }
            cost = Double.MAX_VALUE;
            startNode = cities.get(currentNode);

            for (Vertex nodeData : tempPath) {
                pathAns.add(nodeData);
                cities.remove(nodeData);
            }
        }
        return pathAns;
    }

    public boolean save(String file) {
        /***
         * save this graph to a json file
         */

        try {
            GraphJson graphJson = new GraphJson(this.g);

            Map<String, Object> map = new HashMap<>();
            map.put("Edges", graphJson.edgesList);
            map.put("Nodes", graphJson.nodesList);

            // create Gson
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // create a writer
            Writer writer = Files.newBufferedWriter(Paths.get(file));

            // convert this object to JSON file
            gson.toJson(map, writer);

            // close writer
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean load(String file) {
        /***
         * load a graph from a json file
         */

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(file));

            // convert JSON file to map
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            // convert Json map to Edges list and Nodes list
            List<LinkedTreeMap<String,Double>> EdgesList = new ArrayList<>();
            List<LinkedTreeMap<String,Object>> NodesList = new ArrayList<>();

            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey().equals("Edges")){
                    EdgesList = (List<LinkedTreeMap<String,Double>>) entry.getValue();
                }
                if (entry.getKey().equals("Nodes")){
                    NodesList = (List<LinkedTreeMap<String,Object>>) entry.getValue();
                }
            }

            GraphJson graphJson = new GraphJson(EdgesList,NodesList);
            Graph dwg = graphJson.graph;
            this.init(dwg);
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}