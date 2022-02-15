package Json;

import BaseElements.Edge;
import BaseElements.GeoLocation;
import BaseElements.Vertex;
import GraphAndAlgo.Graph;
import com.google.gson.internal.LinkedTreeMap;

import java.util.*;

public class GraphJson {
        public List<LinkedTreeMap<String,Object>> edgesList;
        public List<LinkedTreeMap<String,Object>> nodesList;
        private List<EdgeJson> EdgesList;
        private List<VertexJson> NodesList;
        public Graph graph;

        public GraphJson(List<LinkedTreeMap<String,Double>> edges, List<LinkedTreeMap<String,Object>> nodes) {
            this.EdgesList = new ArrayList<>();
            this.NodesList = new LinkedList<>();

            HashMap<Integer, Map<Integer, Edge>> Edges = new HashMap<>();
            for (int i = 0; i < edges.size(); i++) {
                EdgesList.add(new EdgeJson(edges.get(i)));

                double src =  EdgesList.get(i).getSrc();
                double w = EdgesList.get(i).getW();
                double dest = EdgesList.get(i).getDest();

                Edge newEdge = new Edge(src,w,dest);
                HashMap<Integer,Edge> temp = new HashMap<>();
                temp.put(newEdge.dest,newEdge);

                if (Edges.get(newEdge.src) != null){
                    Edges.get(newEdge.src).put(newEdge.dest,newEdge);
                }
                else {
                    Edges.put(newEdge.src, temp);
                }
            }

            HashMap<Integer, Vertex> Nodes = new HashMap<>();
            for (int i = 0; i < nodes.size(); i++) {
                NodesList.add(new VertexJson(nodes.get(i)));
                Vertex newNode = NodesList.get(i).getNodeJson();
                Nodes.put(newNode.getKey(), newNode);
            }

            this.graph = new Graph(Nodes, Edges);
        }

        public GraphJson(Graph graph){
            this.edgesList = new ArrayList<>();
            this.nodesList = new ArrayList<>();

            Iterator edgeIter = graph.edgeIter();
            int i = 0;
            while (edgeIter.hasNext()){
                Edge edgeToAdd = (Edge)edgeIter.next();
                int src = edgeToAdd.getSrc();
                Double w = edgeToAdd.getWeight();
                int dest = edgeToAdd.getDest();

                LinkedTreeMap<String,Object> list = new LinkedTreeMap<>();
                list.put("src",src);
                list.put("w",w);
                list.put("dest",dest);
                edgesList.add(i, list);
                i++;
            }

            int j = 0;
            Iterator nodeIter = graph.nodeIter();
            while (nodeIter.hasNext()){
                Vertex nodeToAdd = (Vertex) nodeIter.next();
                int id = nodeToAdd.getKey();
                GeoLocation gl = (GeoLocation) nodeToAdd.getLocation();
                double x = gl.x();
                double y = gl.y();
                double z = gl.z();

                String location = ""+x+","+""+y+","+""+z;
                LinkedTreeMap<String,Object> list = new LinkedTreeMap<>();
                list.put("pos", location);
                list.put("id", id);
                nodesList.add(j,list);
                j++;
            }
        }
    }
