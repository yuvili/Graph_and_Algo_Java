package Json;

import com.google.gson.internal.LinkedTreeMap;

public class EdgeJson {
    LinkedTreeMap<String,Double> edgeJson;

    public EdgeJson(LinkedTreeMap<String, Double> edgeJson) {
        this.edgeJson = edgeJson;
    }
    public double getSrc(){
        return this.edgeJson.get("src");
    }
    public double getW(){
        return this.edgeJson.get("w");
    }
    public double getDest(){
        return this.edgeJson.get("dest");
    }

}

