package BaseElements;

import java.util.Objects;

public class GeoLocation {
    private double x,y,z;

    // Constructors
    public GeoLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public GeoLocation(GeoLocation g) {
        this(g.x, g.y, g.z);
    }
    public GeoLocation(String s) {
        try {
            String[] a = s.split(",");
            x = Double.parseDouble(a[0]);
            y = Double.parseDouble(a[1]);
            z = Double.parseDouble(a[2]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for GeoLocation init, got:"+s+"  should be of format: x,y,z");
            throw(e);
        }
    }

    public GeoLocation(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double z() {
        return z;
    }

    // Setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public GeoLocation copy() {
        return new GeoLocation(this.x,this.y,this.z);
    }

    // Distance function
    public double distance(GeoLocation g) {
        double dx = this.x() - g.x();
        double dy = this.y() - g.y();
        double dz = this.z() - g.z();
        double t = (dx*dx+dy*dy+dz*dz);
        return Math.sqrt(t);
    }
    @Override
    public String toString() {
        return ""+x +","+y+","+z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoLocation GeoLocation = (GeoLocation) o;
        return Double.compare(GeoLocation.x, x) == 0 && Double.compare(GeoLocation.y, y) == 0 && Double.compare(GeoLocation.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
