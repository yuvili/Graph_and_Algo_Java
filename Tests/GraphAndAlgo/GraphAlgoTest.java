package GraphAndAlgo;

import BaseElements.Edge;
import BaseElements.GeoLocation;
import BaseElements.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlgoTest {
        GraphAlgo graphA;
        Graph graph;

        @BeforeEach
        void setUp() {
            Edge e0 = new Edge(0,1.3118716362419698, 16);
            Edge e1 = new Edge(0,1.232037506070033, 1);
            Edge e2 = new Edge(1,1.8635670623870366, 0);
            Edge e3 = new Edge(1, 1.8015954015822042,2 );
            Edge e4 = new Edge(2,1.5784991011275615, 1);
            Edge e5 = new Edge(2,1.0631605142699874, 3 );
            Edge e6 = new Edge(2, 1.7938753352369698,6);
            Edge e7 = new Edge(3, 1.440561778177153,2 );
            Edge e8 = new Edge(3,1.2539385028794277, 4 );
            Edge e9 = new Edge(4,1.8418222744214585, 3);
            Edge e10 = new Edge(4,1.1422264879958028, 5);
            Edge e11 = new Edge(5,1.5855912911662344, 4);
            Edge e12 = new Edge(5,1.734311926030133, 6);
            Edge e13 = new Edge(6,1.8474047229605628, 2);
            Edge e14 = new Edge(6,1.4964304236123005, 5);
            Edge e15 = new Edge(6,1.237565124536135, 7);
            Edge e16 = new Edge(7,1.5786081900467002, 6);
            Edge e17 = new Edge(7,1.3717352984705653, 8);
            Edge e18 = new Edge(8,1.2817370911337442, 7);
            Edge e19 = new Edge(8,1.5328553219807337, 9);
            Edge e20 = new Edge(9,1.9855087252581762, 8);
            Edge e21 = new Edge(9,1.2861739185896588, 10);
            Edge e22 = new Edge(10,1.5815006562559664, 9);
            Edge e23 = new Edge(10,1.4962204797190428, 11);
            Edge e24 = new Edge(11,1.3784147388591739, 10);
            Edge e25 = new Edge(11,1.9316059913913906, 12);
            Edge e26 = new Edge(12,1.0666986438224981, 11);
            Edge e27 = new Edge(12,1.5484109702862576, 13);
            Edge e28 = new Edge(13,1.823489852982211, 12);
            Edge e29 = new Edge(13,1.011071987085077, 14);
            Edge e30 = new Edge(14,1.3207562671517605, 13);
            Edge e31 = new Edge(14,1.118950355920981, 15);
            Edge e32 = new Edge(15,1.8726071511162605, 16);
            Edge e33 = new Edge(15,1.635946027210021, 14);
            Edge e34 = new Edge(16,1.4418017651347552, 0);
            Edge e35 = new Edge(16,1.5677693324851103, 15);

            HashMap<Integer, Map<Integer, Edge>> Edges = new HashMap<Integer, Map<Integer, Edge>>();

            HashMap<Integer, Edge> edge0 = new HashMap<>();
            edge0.put(e0.getDest(),e0);
            edge0.put(e1.getDest(),e1);
            HashMap<Integer, Edge> edge1 = new HashMap<>();
            edge1.put(e2.getDest(),e2);
            edge1.put(e3.getDest(),e3);
            HashMap<Integer, Edge> edge2 = new HashMap<>();
            edge2.put(e4.getDest(),e4);
            edge2.put(e5.getDest(),e5);
            edge2.put(e6.getDest(),e6);
            HashMap<Integer, Edge> edge3 = new HashMap<>();
            edge3.put(e7.getDest(),e7);
            edge3.put(e8.getDest(),e8);
            HashMap<Integer, Edge> edge4 = new HashMap<>();
            edge4.put(e9.getDest(),e9);
            edge4.put(e10.getDest(),e10);
            HashMap<Integer, Edge> edge5 = new HashMap<>();
            edge5.put(e11.getDest(),e11);
            edge5.put(e12.getDest(),e12);
            HashMap<Integer, Edge> edge6 = new HashMap<>();
            edge6.put(e13.getDest(),e13);
            edge6.put(e14.getDest(),e14);
            edge6.put(e15.getDest(),e15);
            HashMap<Integer, Edge> edge7 = new HashMap<>();
            edge7.put(e16.getDest(),e16);
            edge7.put(e17.getDest(),e17);
            HashMap<Integer, Edge> edge8 = new HashMap<>();
            edge8.put(e18.getDest(),e18);
            edge8.put(e19.getDest(),e19);
            HashMap<Integer, Edge> edge9 = new HashMap<>();
            edge9.put(e20.getDest(),e20);
            edge9.put(e21.getDest(),e21);
            HashMap<Integer, Edge> edge10 = new HashMap<>();
            edge10.put(e22.getDest(),e22);
            edge10.put(e23.getDest(),e23);
            HashMap<Integer, Edge> edge11 = new HashMap<>();
            edge11.put(e24.getDest(),e24);
            edge11.put(e25.getDest(),e25);
            HashMap<Integer, Edge> edge12 = new HashMap<>();
            edge12.put(e26.getDest(),e26);
            edge12.put(e27.getDest(),e27);
            HashMap<Integer, Edge> edge13 = new HashMap<>();
            edge13.put(e28.getDest(),e28);
            edge13.put(e29.getDest(),e29);
            HashMap<Integer, Edge> edge14 = new HashMap<>();
            edge14.put(e30.getDest(),e30);
            edge14.put(e31.getDest(),e31);
            HashMap<Integer, Edge> edge15 = new HashMap<>();
            edge15.put(e32.getDest(),e32);
            edge15.put(e33.getDest(),e33);
            HashMap<Integer, Edge> edge16 = new HashMap<>();
            edge16.put(e34.getDest(),e34);
            edge16.put(e35.getDest(),e35);

            Edges.put(0,edge0);
            Edges.put(1,edge1);
            Edges.put(2,edge2);
            Edges.put(3,edge3);
            Edges.put(4,edge4);
            Edges.put(5,edge5);
            Edges.put(6,edge6);
            Edges.put(7,edge7);
            Edges.put(8,edge8);
            Edges.put(9,edge9);
            Edges.put(10,edge10);
            Edges.put(11,edge11);
            Edges.put(12,edge12);
            Edges.put(13,edge13);
            Edges.put(14,edge14);
            Edges.put(15,edge15);
            Edges.put(16,edge16);

            GeoLocation g0 = new GeoLocation(35.19589389346247,32.10152879327731,0.0);
            Vertex n0 = new Vertex(g0,0,0);

            GeoLocation g1 = new GeoLocation(35.20319591121872,32.10318254621849,0.0);
            Vertex n1 = new Vertex(g1,1,0);

            GeoLocation g2 = new GeoLocation(35.20752617756255,32.1025646605042,0.0);
            Vertex n2 = new Vertex(g2,2,0);

            GeoLocation g3 = new GeoLocation(35.21007339305892,32.10107446554622,0.0);
            Vertex n3 = new Vertex(g3,3,0);

            GeoLocation g4 = new GeoLocation(35.21310882485876,32.104636394957986,0.0);
            Vertex n4 = new Vertex(g4,4,0);

            GeoLocation g5 = new GeoLocation(35.212111165456015,32.106235628571426,0.0);
            Vertex n5 = new Vertex(g5,5,0);

            GeoLocation g6 = new GeoLocation(35.20797194027441,32.104854472268904,0.0);
            Vertex n6 = new Vertex(g6,6,0);

            GeoLocation g7 = new GeoLocation(35.205764353510894,32.106326494117646,0.0);
            Vertex n7 = new Vertex(g7,7,0);

            GeoLocation g8 = new GeoLocation(35.20154022114608,32.10594485882353,0.0);
            Vertex n8 = new Vertex(g8,8,0);

            GeoLocation g9 = new GeoLocation(35.19805902663438,32.10525428067227,0.0);
            Vertex n9 = new Vertex(g9,9,0);

            GeoLocation g10 = new GeoLocation(35.197400995964486,32.10510889579832,0.0);
            Vertex n10 = new Vertex(g10,10,0);

            GeoLocation g11 = new GeoLocation(35.19351649233253,32.1061811092437,0.0);
            Vertex n11 = new Vertex(g11,11,0);

            GeoLocation g12 = new GeoLocation(35.18950462792575,32.10788938151261,0.0);
            Vertex n12 = new Vertex(g12,12,0);

            GeoLocation g13 = new GeoLocation(35.189568308313156,32.106617263865544,0.0);
            Vertex n13 = new Vertex(g13,13,0);

            GeoLocation g14 = new GeoLocation(35.18869800968523,32.104927164705884,0.0);
            Vertex n14 = new Vertex(g14,14,0);

            GeoLocation g15 = new GeoLocation(35.187594216303474,32.10378225882353,0.0);
            Vertex n15 = new Vertex(g15,15,0);

            GeoLocation g16 = new GeoLocation(35.19381366747377,32.102419275630254,0.0);
            Vertex n16 = new Vertex(g16,16,0);

            HashMap<Integer, Vertex> nd = new HashMap<Integer, Vertex>();
            nd.put(0, n0);
            nd.put(1,n1);
            nd.put(2,n2);
            nd.put(3,n3);
            nd.put(4,n4);
            nd.put(5,n5);
            nd.put(6,n6);
            nd.put(7,n7);
            nd.put(8,n8);
            nd.put(9,n9);
            nd.put(10,n10);
            nd.put(11,n11);
            nd.put(12,n12);
            nd.put(13,n13);
            nd.put(14,n14);
            nd.put(15,n15);
            nd.put(16,n16);

            graph = new Graph(nd,Edges);
            graphA = new GraphAlgo();
            graphA.init(graph);
        }

        @Test
        void init(){
            assertEquals(graphA.getGraph(), graph);
        }

        @Test
        void isEmpty(){
            GraphAlgo graphA = new GraphAlgo();
            assertTrue(graphA.isEmpty());
        }

        @Test
        void getGraph() {
            assertEquals(graphA.getGraph(), graph);
        }

        @Test
        void copy() {
            Graph newG = graphA.copy();
            assertEquals(newG.nodeSize(), graph.nodeSize());
            assertEquals(newG.edgeSize(), graph.edgeSize());
            assertEquals(newG.getNode(0), graph.getNode(0));
        }

        @Test
        void isConnected() {
            assertTrue(graphA.isConnected());

            Edge e03 = new Edge(1, 1.8015954015822042,2 );
            Edge e04 = new Edge(2,1.5784991011275615, 1);
            Edge e05 = new Edge(2,1.0631605142699874, 3 );
            Edge e06 = new Edge(2, 1.7938753352369698,6);
            Edge e07 = new Edge(3, 1.440561778177153,2 );
            Edge e08 = new Edge(3,1.2539385028794277, 4 );
            Edge e09 = new Edge(4,1.8418222744214585, 3);
            Edge e010 = new Edge(4,1.1422264879958028, 5);
            Edge e011 = new Edge(5,1.5855912911662344, 4);
            Edge e012 = new Edge(5,1.734311926030133, 6);
            Edge e013 = new Edge(6,1.8474047229605628, 2);
            Edge e014 = new Edge(6,1.4964304236123005, 5);
            Edge e015 = new Edge(6,1.237565124536135, 7);
            Edge e016 = new Edge(7,1.5786081900467002, 6);
            Edge e017 = new Edge(7,1.3717352984705653, 8);

            HashMap<Integer, Edge> edge01 = new HashMap<>();
            edge01.put(e03.getDest(),e03);
            HashMap<Integer, Edge> edge02 = new HashMap<>();
            edge02.put(e04.getDest(),e04);
            edge02.put(e05.getDest(),e05);
            edge02.put(e06.getDest(),e06);
            HashMap<Integer, Edge> edge03 = new HashMap<>();
            edge03.put(e07.getDest(),e07);
            edge03.put(e08.getDest(),e08);
            HashMap<Integer, Edge> edge04 = new HashMap<>();
            edge04.put(e09.getDest(),e09);
            edge04.put(e010.getDest(),e010);
            HashMap<Integer, Edge> edge05 = new HashMap<>();
            edge05.put(e011.getDest(),e011);
            edge05.put(e012.getDest(),e012);
            HashMap<Integer, Edge> edge06 = new HashMap<>();
            edge06.put(e013.getDest(),e013);
            edge06.put(e014.getDest(),e014);
            edge06.put(e015.getDest(),e015);
            HashMap<Integer, Edge> edge07 = new HashMap<>();
            edge07.put(e016.getDest(),e016);
            edge07.put(e017.getDest(),e017);

            HashMap<Integer, Map<Integer, Edge>> Edges2 = new HashMap<Integer, Map<Integer, Edge>>();
            Edges2.put(1,edge01);
            Edges2.put(2,edge02);
            Edges2.put(3,edge03);
            Edges2.put(4,edge04);
            Edges2.put(5,edge05);
            Edges2.put(6,edge06);
            Edges2.put(7,edge07);

            GeoLocation g0 = new GeoLocation(35.19589389346247,32.10152879327731,0.0);
            GeoLocation g1 = new GeoLocation(35.20319591121872,32.10318254621849,0.0);
            GeoLocation g2 = new GeoLocation(35.20752617756255,32.1025646605042,0.0);
            GeoLocation g3 = new GeoLocation(35.21007339305892,32.10107446554622,0.0);
            GeoLocation g4 = new GeoLocation(35.21310882485876,32.104636394957986,0.0);
            GeoLocation g5 = new GeoLocation(35.212111165456015,32.106235628571426,0.0);
            GeoLocation g6 = new GeoLocation(35.20797194027441,32.104854472268904,0.0);
            GeoLocation g7 = new GeoLocation(35.205764353510894,32.106326494117646,0.0);

            Vertex n00 = new Vertex(g0,0,0);
            Vertex n01 = new Vertex(g1,1,0);
            Vertex n02 = new Vertex(g2,2,0);
            Vertex n03 = new Vertex(g3,3,0);
            Vertex n04 = new Vertex(g4,4,0);
            Vertex n05 = new Vertex(g5,5,0);
            Vertex n06 = new Vertex(g6,6,0);
            Vertex n07 = new Vertex(g7,7,0);

            HashMap<Integer, Vertex> nd2 = new HashMap<Integer, Vertex>();
            nd2.put(0, n00);
            nd2.put(1,n01);
            nd2.put(2,n02);
            nd2.put(3,n03);
            nd2.put(4,n04);
            nd2.put(5,n05);
            nd2.put(6,n06);
            nd2.put(7,n07);

            GraphAlgo graphA2 = new GraphAlgo();
            Graph graph2 = new Graph(nd2,Edges2);
            graphA2.init(graph2);
            boolean b = graphA2.isConnected();
            assertFalse(b);
        }

        @Test
        void shortestPathDist() {
            assertEquals(graphA.shortestPathDist(8,12), 6.246855711680825);
            assertEquals(graphA.shortestPathDist(0,6), 4.827508242889207);
            assertEquals(graphA.shortestPathDist(12,11), 1.0666986438224981);
            assertEquals(graphA.shortestPathDist(0,15), 2.87964096872708);
            assertEquals(graphA.shortestPathDist(7,16), 8.17995071276383);
            assertEquals(graphA.shortestPathDist(8,8), 0.0);
        }

        @Test
        void shortestPath() {
            List<Vertex> nodeDataList = graphA.shortestPath(0,6);
            assertEquals(nodeDataList.get(0).getKey(), 0);
            assertEquals(nodeDataList.get(1).getKey(), 1);
            assertEquals(nodeDataList.get(2).getKey(), 2);
            assertEquals(nodeDataList.get(3).getKey(), 6);

            List<Vertex> nodeDataList2 = graphA.shortestPath(8,12);
            assertEquals(nodeDataList2.get(0).getKey(), 8);
            assertEquals(nodeDataList2.get(1).getKey(), 9);
            assertEquals(nodeDataList2.get(2).getKey(), 10);
            assertEquals(nodeDataList2.get(3).getKey(), 11);
            assertEquals(nodeDataList2.get(4).getKey(), 12);
        }

        @Test
        void center() {
            assertEquals(graphA.center().getKey(), 8);
        }

        @Test
        void tsp() {
            GeoLocation g1 = new GeoLocation(35.20319591121872,32.10318254621849,0.0);
            Vertex n1 = new Vertex(g1,1,0);

            GeoLocation g6 = new GeoLocation(35.20797194027441,32.104854472268904,0.0);
            Vertex n6 = new Vertex(g6,6,0);

            GeoLocation g12 = new GeoLocation(35.18950462792575,32.10788938151261,0.0);
            Vertex n12 = new Vertex(g12,12,0);

            GeoLocation g16 = new GeoLocation(35.19381366747377,32.102419275630254,0.0);
            Vertex n16 = new Vertex(g16,16,0);

            List<Vertex> input = new ArrayList<>();
            input.add(n1);
            input.add(n6);
            input.add(n12);
            input.add(n16);
            List<Vertex> output = graphA.tsp(input);

            assertEquals(output.size(), 9);

            List<Vertex> input2 = new ArrayList<>();
            input2.add(n1);
            input2.add(n6);
            input2.add(n12);
            input2.add(n1);
            input2.add(n16);
            List<Vertex> output2 = graphA.tsp(input2);
            assertEquals(output2.size(), 9);
        }
        @Test
        void save() {
            graphA.save("G5.json");
        }
        @Test
        void load() {
            GraphAlgo graphAlgo = new GraphAlgo();
            graphAlgo.load("G1.json");
        }
    }