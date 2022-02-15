package BaseElements;

import java.util.Objects;

public class Vertex {

    private GeoLocation pos;
    private final int id;
    public int tag;

    // Constructors
    public Vertex(GeoLocation gl, int key, int tag) {
        this.pos = gl;
        this.id = key;
        this.tag = tag;
    }
    public Vertex(GeoLocation gl, int key) {
        this.pos = gl;
        this.id = key;
        this.tag = 0;
    }
    public Vertex(int key) {
        this.id = key;
        this.pos = null;
        this.tag = 0;
    }
    public Vertex(){
        this.pos = new GeoLocation();
        this.id = 0;
        this.tag = 0;
    }

    // Getters and Setters
    public int getKey() {
        return id;
    }

    public GeoLocation getLocation() {
        return pos;
    }

    public void setLocation(GeoLocation p) {
        this.pos = p;
    }

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
        Vertex node = (Vertex) o;
        return id == node.id && pos.equals(node.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, id);
    }
}
