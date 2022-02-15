package Json;

import BaseElements.GeoLocation;
import BaseElements.Vertex;
import com.google.gson.internal.LinkedTreeMap;

public class VertexJson {
    LinkedTreeMap<String,Object> nodeJson;

    public VertexJson(LinkedTreeMap<String,Object> nodeJson){
        this.nodeJson = nodeJson;
    }

    public Vertex getNodeJson(){
        String pos = (String) nodeJson.get("pos");
        String[] a = pos.split(",");
        String xs = a[0];
        String ys = a[1];
        String zs = a[2];

        double x = Double.parseDouble(xs);
        double y = Double.parseDouble(ys);
        double z = Double.parseDouble(zs);

        GeoLocation geoLocation = new GeoLocation(x,y,z);
        double id = (double) nodeJson.get("id");
        return new Vertex(geoLocation,(int) id);
    }
}
