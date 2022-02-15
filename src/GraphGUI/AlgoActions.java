package GraphGUI;

import BaseElements.Vertex;
import GraphAndAlgo.Graph;
import GraphAndAlgo.GraphAlgo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AlgoActions implements ActionListener {
    JFrame frame = new JFrame();
    JButton shortestPathDistButton = new JButton("Enter");
    JButton shortestPathButton = new JButton("Enter");
    JButton tspButton = new JButton("Enter");
    JLabel errormessageLabel = new JLabel();

    JLabel srcLabel = new JLabel("Edge source: ");
    JLabel destLabel = new JLabel("Edge destination: ");

    JLabel listLabel = new JLabel("Cities list: ");
    JTextField list = new JTextField();

    JTextField src = new JTextField();
    JTextField dest = new JTextField();
    JLabel messageLabel = new JLabel();
    JLabel SPDLabel = new JLabel();
    JLabel SPLabel = new JLabel();

    Graph graph;
    GraphAlgo graphAlgo;
    JButton returnButton = new JButton("Return back");

    public AlgoActions(Graph graph, int a){
        this.graph = graph;
        this.graphAlgo = new GraphAlgo();
        this.graphAlgo.init(graph);

        messageLabel.setBounds(25,10,300,25);
        frame.add(messageLabel);
        errormessageLabel.setBounds(10,45,350,35);
        frame.add(errormessageLabel);
        SPDLabel.setBounds(25,70,300,25);
        frame.add(SPDLabel);
        SPLabel.setBounds(25,65,300,25);
        frame.add(SPLabel);

        if(a == 1){
            boolean b = this.graphAlgo.isConnected();

            if(b){
                messageLabel.setText("This graph is connected");
            }
            else {
                messageLabel.setText("This graph is not connected");
            }

            returnButton.setBounds(50,95,200,25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }
        if(a == 2){
            srcLabel.setBounds(25,10,125,25);
            frame.add(srcLabel);
            destLabel.setBounds(25,35,125,25);
            frame.add(destLabel);

            src.setBounds(178,10,150,25);
            frame.add(src);

            dest.setBounds(178,35,150,25);
            frame.add(dest);

            shortestPathDistButton.setBounds(50,90,200,25);
            shortestPathDistButton.setFocusable(false);
            frame.add(shortestPathDistButton);
            shortestPathDistButton.addActionListener(this);

            returnButton.setBounds(50,115,200,25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }
        else if(a == 3){
            srcLabel.setBounds(25,10,125,25);
            frame.add(srcLabel);
            destLabel.setBounds(25,35,125,25);
            frame.add(destLabel);

            src.setBounds(178,10,150,25);
            frame.add(src);

            dest.setBounds(178,35,150,25);
            frame.add(dest);

            shortestPathButton.setBounds(50,90,200,25);
            frame.add(shortestPathButton);
            shortestPathButton.addActionListener(this);

            returnButton.setBounds(50,115,200,25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }

        else if(a == 4){
            int center = this.graphAlgo.center().getKey();
            messageLabel.setText("The graph's center is Vertex number " + center);

            returnButton.setBounds(50,95,200,25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }
        else if(a == 5){
            messageLabel.setText("Please enter the nodes's keys (e.g. 1,2,3)");
            listLabel.setBounds(25,35,75,25);
            frame.add(listLabel);

            list.setBounds(100,35,150,25);
            frame.add(list);

            tspButton.setBounds(50,90,200,25);
            tspButton.setFocusable(false);
            frame.add(tspButton);
            tspButton.addActionListener(this);

            returnButton.setBounds(50,115,200,25);
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
            if (e.getSource() == returnButton) {
                AlgoGraph algoGraph = new AlgoGraph(this.graph);
                this.frame.dispose();
            }
            else if (e.getSource() == shortestPathDistButton) {
                int source = Integer.parseInt(src.getText().trim());
                int destination = Integer.parseInt(dest.getText().trim());
                double ans = this.graphAlgo.shortestPathDist(source, destination);

                SPDLabel.setText("The distance of the shortest path is " + ans);
            }
            else if (e.getSource() == shortestPathButton) {
                int source = Integer.parseInt(src.getText().trim());
                int destination = Integer.parseInt(dest.getText().trim());
                List<Vertex> ans = this.graphAlgo.shortestPath(source, destination);
                MyFrame newFrame = new MyFrame(graphAlgo,ans);
            }
            else if (e.getSource() == tspButton) {
                String s = list.getText().trim();
                String[] arr = s.split(",");
                List<Vertex> inputList = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                    Vertex temp = (Vertex) this.graph.getNode(Integer.parseInt(arr[i]));
                    if(!inputList.contains(temp)) {
                        inputList.add(temp);
                    }
                }
                List<Vertex> ans = this.graphAlgo.tsp(inputList);
                MyFrame newFrame = new MyFrame(graphAlgo,ans);
            }
        }
        catch (Exception ex){
            messageLabel.setText("Something went wrong...");
            messageLabel.setBounds(100, 150, 200, 25);
            errormessageLabel.setText(""+ex);
            errormessageLabel.setBounds(25, 175, 400, 25);

            if (e.getSource() == returnButton) {
                AlgoGraph algoGraph = new AlgoGraph(this.graph);
                this.frame.dispose();
            }
        }
    }
}
