package GraphGUI;

import GraphAndAlgo.Graph;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlgoGraph implements ActionListener {
    JFrame frame = new JFrame();

    JButton isConnectedButton = new JButton("Check if the graph is connected");
    JButton shortestPathDistButton = new JButton("Get the distance of the shortest path");
    JButton shortestPathButton = new JButton("Get the shortest path");
    JButton centerButton = new JButton("Get graph's center");
    JButton tspButton = new JButton("TSP");
    JButton returnButton = new JButton("Return back");

    Graph graph;

    AlgoGraph(Graph graph){
        this.graph = graph;

        isConnectedButton.setBounds(50,10,300,25);
        isConnectedButton.setFocusable(false);
        frame.add(isConnectedButton);
        isConnectedButton.addActionListener(this);

        shortestPathDistButton.setBounds(50,35,300,25);
        shortestPathDistButton.setFocusable(false);
        frame.add(shortestPathDistButton);
        shortestPathDistButton.addActionListener(this);

        shortestPathButton.setBounds(50,60,300,25);
        shortestPathButton.setFocusable(false);
        frame.add(shortestPathButton);
        shortestPathButton.addActionListener(this);

        centerButton.setBounds(50,80,300,25);
        centerButton.setFocusable(false);
        frame.add(centerButton);
        centerButton.addActionListener(this);

        tspButton.setBounds(50,105,300,25);
        tspButton.setFocusable(false);
        frame.add(tspButton);
        tspButton.addActionListener(this);

        returnButton.setBounds(85,150,200,25);
        returnButton.setFocusable(false);
        frame.add(returnButton);
        returnButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == isConnectedButton ){
            AlgoActions act = new AlgoActions(this.graph, 1);
            this.frame.dispose();
        }
        else if(e.getSource() == shortestPathDistButton){
            AlgoActions act = new AlgoActions(this.graph, 2);
            this.frame.dispose();
        }
        else if(e.getSource() == shortestPathButton){
            AlgoActions act = new AlgoActions(this.graph, 3);
            this.frame.dispose();
        }
        else if(e.getSource() == centerButton){
            AlgoActions act = new AlgoActions(this.graph, 4);
            this.frame.dispose();
        }
        else if(e.getSource() == tspButton){
            AlgoActions act = new AlgoActions(this.graph, 5);
            this.frame.dispose();
        }
        else if(e.getSource() == returnButton){
            LoginPage loginPage = new LoginPage(this.graph);
            this.frame.dispose();
        }

    }
}
