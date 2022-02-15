package GraphGUI;

import BaseElements.Edge;
import BaseElements.GeoLocation;
import BaseElements.Vertex;
import GraphAndAlgo.Graph;
import GraphAndAlgo.GraphAlgo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPanel extends JPanel {
    GraphAlgo graphAlgo;
    Graph graph;
    int width;
    int height;
    double minX;
    double minY;
    double xScale;
    double yScale;
    List<Vertex> nodeDataList;

    MyPanel(GraphAlgo graphAlgo, int frameWidth, int frameHeight){
        this.graphAlgo = graphAlgo;
        graph = graphAlgo.getGraph();
        this.width = frameWidth;
        this.height = frameHeight;

        double minX = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;

        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;

        Iterator<Vertex> iter_nodes = this.graph.nodeIter();
        while (iter_nodes.hasNext()) {
            Vertex current = (Vertex) iter_nodes.next();
            GeoLocation currentLoc = (GeoLocation) current.getLocation();

            if (currentLoc.x() < minX) {
                minX = currentLoc.x();
            }
            if (maxX < currentLoc.x()) {
                maxX = currentLoc.x();
            }

            if (currentLoc.y() < minY) {
                minY = currentLoc.y();
            }
            if (maxY < currentLoc.y()) {
                maxY = currentLoc.y();
            }
        }
        this.minX = minX;
        this.minY = minY;
            double absX = Math.abs(maxX-minX);
            double absY = Math.abs(maxY-minY);

            this.xScale = this.width / absX;
            this.yScale = this.height / absY;

            this.setPreferredSize(new Dimension(this.width+20,this.height+20));
    }

    MyPanel(GraphAlgo graphAlgo, int frameWidth, int frameHeight, List<Vertex> ans){
        this.graphAlgo = graphAlgo;
        graph = graphAlgo.getGraph();
        this.width = frameWidth;
        this.height = frameHeight;
        this.nodeDataList = new ArrayList<>(ans);

        double minX = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;

        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;

        Iterator<Vertex> iter_nodes = this.graph.nodeIter();
        while (iter_nodes.hasNext()) {
            Vertex current = (Vertex) iter_nodes.next();
            GeoLocation currentLoc = (GeoLocation) current.getLocation();

            if (currentLoc.x() < minX) {
                minX = currentLoc.x();
            }
            if (maxX < currentLoc.x()) {
                maxX = currentLoc.x();
            }

            if (currentLoc.y() < minY) {
                minY = currentLoc.y();
            }
            if (maxY < currentLoc.y()) {
                maxY = currentLoc.y();
            }
        }
        this.minX = minX;
        this.minY = minY;
        double absX = Math.abs(maxX-minX);
        double absY = Math.abs(maxY-minY);

        this.xScale = this.width / absX;
        this.yScale = this.height / absY;

        this.setPreferredSize(new Dimension(this.width+20,this.height+20));
    }

    public void paint(Graphics g) {
        if(this.graph != null) {
            Iterator iter_nodes = this.graph.nodeIter();
            while (iter_nodes.hasNext()) {
                Vertex current = (Vertex) iter_nodes.next();
                GeoLocation currentLoc = (GeoLocation) current.getLocation();
                int key = current.getKey();

                if((this.nodeDataList != null) && this.nodeDataList.contains(current)){
                    g.setColor(Color.ORANGE);
                    g.fillOval((int) ((currentLoc.x() - this.minX) * xScale), (int) ((currentLoc.y() - this.minY)* yScale) , 20, 20);
                }
                else {
                    g.setColor(Color.CYAN);
                    g.fillOval((int) ((currentLoc.x() - this.minX) * xScale), (int) ((currentLoc.y() - this.minY) * yScale), 20, 20);
                }
                g.setColor(Color.black);
                g.drawString(""+key, (int) ((currentLoc.x() - this.minX) * xScale)+4, (int) ((currentLoc.y() - this.minY) * yScale)+9);

                Iterator<Edge> iter_edges = this.graph.edgeIter(key);
                while (iter_edges.hasNext()) {
                    Edge current_edge = (Edge) iter_edges.next();
                    int dest = current_edge.getDest();

                    Vertex dest_node = (Vertex) this.graph.getNode(dest);
                    GeoLocation destLoc = (GeoLocation) dest_node.getLocation();
                    g.setColor(Color.black);

                    // drawing the edge
                    int startX = (int) ((currentLoc.x() - this.minX) * xScale);
                    int startY = (int) ((currentLoc.y() - this.minY) * yScale);
                    int endX = (int) ((destLoc.x()- this.minX) * xScale);
                    int endY = (int) ((destLoc.y() - this.minY) * yScale);
                    LineArrow.ArrowEdge new_edge = new LineArrow.ArrowEdge(startX, startY, endX, endY, Color.black);
                    new_edge.draw(g);
                }
            }
        }
    }
}
