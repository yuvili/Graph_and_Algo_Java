package GraphGUI;

import BaseElements.GeoLocation;
import BaseElements.Vertex;
import GraphAndAlgo.Graph;
import GraphAndAlgo.GraphAlgo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actions implements ActionListener{
    JFrame frame = new JFrame();
    JButton addNodeButton = new JButton("Enter");
    JButton connectButton = new JButton("Enter");
    JButton removeNodeButton = new JButton("Enter");
    JButton removeEdgeButton = new JButton("Enter");
    JButton returnButton = new JButton("Return back");

    JLabel posLabel = new JLabel("Vertex pos: ");
    JLabel idLabel = new JLabel("Vertex id: ");

    JLabel srcLabel = new JLabel("Edge source: ");
    JLabel destLabel = new JLabel("Edge destination: ");
    JLabel weightLabel = new JLabel("Edge weight: ");

    JTextField pos = new JTextField();
    JTextField id = new JTextField();
    JTextField src = new JTextField();
    JTextField dest = new JTextField();
    JTextField weight = new JTextField();

    JLabel messageLabel = new JLabel();
    JLabel errormessageLabel = new JLabel();
    JLabel wrongSRCLabel = new JLabel();
    JLabel wrongDESTLabel = new JLabel();
    JLabel WLabel = new JLabel();

    Graph graph;
    String json_file;

    public Actions(Graph graph, int a, String json_file){
        this.json_file = json_file;
        this.graph = graph;
        messageLabel.setBounds(20,10,350,35);
        frame.add(messageLabel);

        errormessageLabel.setBounds(10,45,350,35);
        frame.add(errormessageLabel);

        wrongSRCLabel.setBounds(50, 150, 250, 25);
        frame.add(wrongSRCLabel);
        wrongDESTLabel.setBounds(50, 175, 280, 25);
        frame.add(wrongDESTLabel);
        WLabel.setBounds(100, 190, 200, 25);
        frame.add(WLabel);

        if(a == 1){
            idLabel.setBounds(50,10,100,25);
            frame.add(idLabel);
            posLabel.setBounds(50,35,125,25);
            frame.add(posLabel);

            id.setBounds(150,10,150,25);
            frame.add(id);

            pos.setBounds(150,35,150,25);
            frame.add(pos);

            addNodeButton.setBounds(50,65,200,25);
            addNodeButton.setFocusable(false);
            frame.add(addNodeButton);
            addNodeButton.addActionListener(this);

            returnButton.setBounds(50,95,200,25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }
        else if(a == 2){
            srcLabel.setBounds(25,10,125,25);
            frame.add(srcLabel);
            destLabel.setBounds(25,35,125,25);
            frame.add(destLabel);
            weightLabel.setBounds(25,60,125,25);
            frame.add(weightLabel);

            src.setBounds(178,10,150,25);
            frame.add(src);

            dest.setBounds(178,35,150,25);
            frame.add(dest);

            weight.setBounds(178,60,150,25);
            frame.add(weight);

            connectButton.setBounds(50,90,200,25);
            connectButton.setFocusable(false);
            frame.add(connectButton);
            connectButton.addActionListener(this);

            returnButton.setBounds(50,115,200,25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }
        else if(a == 3){
            idLabel.setBounds(25,10,75,25);
            frame.add(idLabel);

            id.setBounds(80,10,100,25);
            frame.add(id);

            removeNodeButton.setBounds(50,35,200,25);
            frame.add(removeNodeButton);
            removeNodeButton.addActionListener(this);

            returnButton.setBounds(50,65,200,25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }
        else if(a == 4){
            srcLabel.setBounds(25,10,125,25);
            frame.add(srcLabel);
            destLabel.setBounds(25,35,125,25);
            frame.add(destLabel);

            src.setBounds(178,10,150,25);
            frame.add(src);

            dest.setBounds(178,35,150,25);
            frame.add(dest);

            removeEdgeButton.setBounds(50,65,200,25);
            removeEdgeButton.setFocusable(false);
            frame.add(removeEdgeButton);
            removeEdgeButton.addActionListener(this);

            returnButton.setBounds(50,95,200,25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addNodeButton) {
                String position = pos.getText();
                System.out.println(position);
                String nodeID = id.getText();

                GeoLocation geoLocation = new GeoLocation(position);
                int key = Integer.parseInt(nodeID.trim());
                graph.addNode(new Vertex(geoLocation, key));

                messageLabel.setText("New Vertex was added!");
                messageLabel.setBounds(100, 150, 200, 25);
                GraphAlgo graphAlgo = new GraphAlgo();
                graphAlgo.init(graph);
                MyFrame newFrame = new MyFrame(graphAlgo);
            }
            else if (e.getSource() == connectButton) {
                int source = Integer.parseInt(src.getText().trim());
                int destination = Integer.parseInt(dest.getText().trim());
                double w = Double.parseDouble(weight.getText().trim());

                wrongSRCLabel.setText("");
                wrongDESTLabel.setText("");
                WLabel.setText("");

                if(this.graph.getNode(source) == null){
                    wrongSRCLabel.setForeground(Color.RED);
                    wrongSRCLabel.setText("Source node wasn't found on the graph");
                }
                if(this.graph.getNode(destination) == null){
                    wrongSRCLabel.setForeground(Color.RED);
                    wrongDESTLabel.setText("Destination node wasn't found on the graph");
                }
                if(w < 0){
                    wrongSRCLabel.setForeground(Color.RED);
                    WLabel.setText("Edge weight cant be negative");
                }
                else {
                    graph.connect(source, destination, w);

                    messageLabel.setText("New Edge was added!");
                    messageLabel.setBounds(100, 150, 200, 25);

                    GraphAlgo graphAlgo = new GraphAlgo();
                    graphAlgo.init(graph);
                    MyFrame newFrame = new MyFrame(graphAlgo);
                }
            }
            else if (e.getSource() == removeNodeButton) {
                int key = Integer.parseInt(id.getText().trim());
                if(this.graph.getNode(key) == null){
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("This node doesn't exist");
                }
                else {
                    graph.removeNode(key);

                    messageLabel.setText("The node is no longer in the graph!");
                    messageLabel.setBounds(100, 150, 200, 25);

                    GraphAlgo graphAlgo = new GraphAlgo();
                    graphAlgo.init(graph);
                    MyFrame newFrame = new MyFrame(graphAlgo);
                }
            }
            else if (e.getSource() == removeEdgeButton) {
                int source = Integer.parseInt(src.getText().trim());
                int destination = Integer.parseInt(dest.getText().trim());

                wrongSRCLabel.setText("");
                wrongDESTLabel.setText("");

                if(this.graph.getNode(source) == null){
                    wrongSRCLabel.setForeground(Color.RED);
                    wrongSRCLabel.setText("Source node wasn't found on the graph");
                }
                if(this.graph.getNode(destination) == null){
                    wrongSRCLabel.setForeground(Color.RED);
                    wrongDESTLabel.setText("Destination node wasn't found on the graph");
                }
                else {
                    graph.removeEdge(source, destination);

                    messageLabel.setText("The edge is no longer in the graph!");
                    messageLabel.setBounds(100, 150, 200, 25);

                    GraphAlgo graphAlgo = new GraphAlgo();
                    graphAlgo.init(graph);
                    MyFrame newFrame = new MyFrame(graphAlgo);
                }
            }
            if (e.getSource() == returnButton) {
                EditGraph editGraph = new EditGraph(this.graph, json_file);
                this.frame.dispose();
            }
        }
        catch (Exception ex){
            if(this.graph == null) {
                messageLabel.setText("Something went wrong..");
                messageLabel.setBounds(100, 150, 200, 25);
                errormessageLabel.setText(""+ex);
                errormessageLabel.setBounds(25, 175, 400, 25);

                if (e.getSource() == returnButton) {
                    EditGraph editGraph = new EditGraph(this.graph,json_file);
                    this.frame.dispose();
                }
            }
        }
    }
}
