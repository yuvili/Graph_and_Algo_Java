package BaseElements;

import java.util.Objects;

public class Edge {
    public int src;
    public double w;
    public int dest;
    private int tag;

    // Constructors
    public Edge(double src, double w, double dest){
        this.src = (int) src;
        this.w = w;
        this.dest= (int) dest;
    }
    public Edge(int src,double weight,int dest, int tag) {
        this.src = src;
        this.dest = dest;
        this.w = weight;
        this.tag = tag;
    }
    public Edge(){
        this.src = 0;
        this.dest = 0;
        this.w = 0.0;
        this.tag = 1;
    }
    public Edge(int src , int dst) {
        this.src = src;
        this.dest = dst;
        this.w = 0;
        this.tag = 0;
    }
    public Edge(int src ,double w, int dst) {
        this.src = src;
        this.dest = dst;
        this.w = w;
        this.tag = 0;
    }
    public Edge(Edge e){
        this(e.src, e.w, e.dest, e.tag);
    }

    public Edge copy() {
        return new Edge(this.src,this.w,this.dest, this.tag);
    }

    // Getters and Setters
    public int getSrc() {
        return this.src;
    }

    public int getDest() {
        return this.dest;
    }

    public double getWeight() {
        return this.w;
    }

    public void setWeight(double w){ this.w = w; }

    public int getTag() {
        return this.tag;
    }

    public void setTag(int t) {
        this.tag = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return src == edge.src && Double.compare(edge.w, w) == 0 && dest == edge.dest;
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, w, dest);
    }
}
