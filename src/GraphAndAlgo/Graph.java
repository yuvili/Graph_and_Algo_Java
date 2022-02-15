package GraphAndAlgo;

import BaseElements.Edge;
import BaseElements.Vertex;

import java.util.*;

public class Graph {
    // A HashMap of edges - first key for source, second key for destination, value for edge
    public HashMap<Integer, Map<Integer, Edge>> Edges;

    // A HashMap of nodes - key for node's id, value for node
    public HashMap<Integer, Vertex> Nodes;
    private int mc = 0;

    // Constructors
    public Graph(HashMap<Integer, Vertex> nd, HashMap<Integer, Map<Integer, Edge>> Edges, int mc) {
        this.Nodes = nd;
        this.Edges = Edges;
        this.mc = mc;
    }

    public Graph(HashMap<Integer, Vertex> nd, HashMap<Integer, Map<Integer, Edge>> Edges){
        this.Nodes = nd;
        this.Edges = Edges;
        this.mc = 0;
    }

    public Graph(){
        this.Nodes = new HashMap<>();
        this.Edges = new HashMap<>();
        this.mc = 0;
    }

    public Graph(Graph dwg) {
        this(dwg.Nodes,dwg.Edges, dwg.mc);
    }

    public boolean isEmpty(){
        try {
            return this.Nodes == null && this.Edges == null;
        }
        catch (NullPointerException e){
            return true;
        }
    }

    public Vertex getNode(int key) {
        // if NodeData doesn't exist the function will return Null
        if(Nodes.isEmpty()){
            return null;
        }
        if(Nodes.get(key) == null){
            return null;
        }
        return Nodes.get(key);
    }

    public Edge getEdge(int src, int dest) {
        // if EdgeData doesn't exist the function will return Null
        if(Edges.isEmpty()){
            return null;
        }
        if(Edges.get(src).isEmpty()){
            return null;
        }
        if(Edges.get(src).get(dest) == null){
            return null;
        }
        return Edges.get(src).get(dest);
    }

    public void addNode(Vertex n) {
        // if the node's key exist the node won't be added
        if(this.getNode(n.getKey()) == null){
            Nodes.put(n.getKey(),n);
            mc++;
        }
    }

    public void connect(int src, int dest, double w) {
        if(this.getNode(src) == null){
            throw new NullPointerException();
        }
        if(this.getNode(dest) == null){
            throw new NullPointerException();
        }
        if(w < 0){
            throw new IllegalArgumentException();
        }
        if(src != dest){
            if(this.getEdge(src,dest) == null) {
                Edge temp = this.getEdge(src, dest);

                if (temp == null) {
                    Edge new_edge = new Edge(src, w, dest);
                    if (this.Edges.get(src) != null) {
                        this.Edges.get(src).put(dest, new_edge);
                    } else {
                        HashMap<Integer, Edge> new_edges = new HashMap<>();
                        new_edges.put(dest, new_edge);
                        this.Edges.put(src, new_edges);
                    }
                }
            }
            // if this edge is already in the graph then check if the new edge has lower weight
            else if (this.getEdge(src,dest).getWeight() > w){
                Edge temp = (Edge) this.getEdge(src, dest);
                temp.setWeight(w);
            }
        }
        mc++;
    }

    public Iterator<Vertex> nodeIter() {
        if(this.Nodes.isEmpty()){
            return null;
        }
        ArrayList<Vertex> temp = new ArrayList<Vertex>();
        Map map = this.Nodes;
        int mcount = this.getMC();

        for (Object o : map.entrySet()) {
            //if the graph was changed since the iterator was constructed - a RuntimeException will be thrown
            if (mcount == this.getMC()) {
                Map.Entry entry = (Map.Entry) o;
                Vertex value = (Vertex) entry.getValue();
                temp.add(value);
            } else {
                throw new RuntimeException();
            }
        }
        return temp.iterator();
    }

    public Iterator<Edge> edgeIter() {
        ArrayList<Edge> ed_temp = new ArrayList<Edge>();
        Map map = new HashMap();
        map = this.Edges;
        int mcount = this.getMC();

        for (Object o : map.entrySet()) {
            // if any of the edges in the graph were changed since the iterator was constructed -
            // a RuntimeException will be thrown.
            if (mcount == this.getMC()) {
                Map.Entry entry = (Map.Entry) o;
                Map value = (Map) entry.getValue();

                for (Object item : value.entrySet()) {
                    Map.Entry entry2 = (Map.Entry) item;
                    Edge value2 = (Edge) entry2.getValue();
                    ed_temp.add(value2);
                }
            } else {
                throw new RuntimeException();
            }
        }
        return ed_temp.iterator();
    }

    public Iterator<Edge> edgeIter(int node_id) {
        ArrayList<Edge> ed_temp = new ArrayList<Edge>();
        Iterator iter = this.edgeIter();
        int mcount = this.getMC();

        while (iter.hasNext()){
            // if any of the edges in the graph were changed since the iterator was constructed -
            // a RuntimeException will be thrown.
            if(mcount == this.getMC()) {
                Edge value = (Edge) iter.next();

                if(value.getSrc() == node_id){
                    ed_temp.add(value);
                }
            }
            else {
                throw new RuntimeException();
            }
        }
        return ed_temp.iterator();
    }

    public Vertex removeNode(int key) {
        // if the node isn't in the graph - a NullPointerException will be thrown.
        if(this.getNode(key) == null){
            throw new NullPointerException();
        }
        else {
            for (int i = 0; i < this.nodeSize(); i++) {
                if(this.getNode(i) != null){
                    // removing the edges connecting to the node
                    if (this.getEdge(i, key) != null) {
                        this.removeEdge(i, key);
                    }
                    if(this.getEdge(key,i) != null){
                        this.removeEdge(key,i);
                    }
                }
            }
        }
        mc++;
        return Nodes.remove(key);
    }


    public Edge removeEdge(int src, int dest) {
        if(this.getEdge(src,dest) == null){
            throw new NullPointerException();
        }
        if(this.getNode(src) == null){
            throw new NullPointerException();
        }
        if(this.getNode(dest) == null){
            throw new NullPointerException();
        }
        Edge ans = this.getEdge(src,dest);
        mc++;
        return this.Edges.get(src).remove(dest);
    }

    public int nodeSize() {
        return Nodes.size();
    }

    public int edgeSize() {
        int counter = 0;
        Iterator<Edge> temp_iter = this.edgeIter();
        while (temp_iter.hasNext()){
            Edge temp = temp_iter.next();
            counter++;
        }
        return counter;
    }

    public int getMC() {
        return mc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Edges.equals(graph.Edges) && Nodes.equals(graph.Nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Edges, Nodes);
    }
}
