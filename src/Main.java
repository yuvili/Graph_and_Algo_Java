import GraphAndAlgo.Graph;
import GraphAndAlgo.GraphAlgo;
import GraphGUI.LoginPage;

public class Main {
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static Graph getGrapg(String json_file) {
        Graph ans = null;
        GraphAlgo dwga = new GraphAlgo();
        dwga.load(json_file);
        ans = dwga.getGraph();

        return ans;
    }
    /**
     * This static function will be used to test your implementation
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     * @return
     */
    public static GraphAlgo getGrapgAlgo(String json_file) {
        GraphAlgo ans = new GraphAlgo();
        ans.load(json_file);

        return ans;
    }
    /**
     * This static function will run your GraphGUI.GUI using the json fime.
     * @param json_file - a json file (e.g., G1.json - G3.gson)
     *
     */
    public static void runGUI(String json_file) {
        new LoginPage(json_file);
    }

    public static void main(String[] args) {
        String path = "data\\";
        String json_file = args[0];
        runGUI(path+json_file);
    }
}
