package GraphGUI;

import GraphAndAlgo.Graph;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditGraph implements ActionListener {
    JFrame frame = new JFrame();

    JButton addNodeButton = new JButton("Add new Vertex");
    JButton connectButton = new JButton("Add new Edge");
    JButton removeNodeButton = new JButton("Remove Vertex");
    JButton removeEdgeButton = new JButton("Remove Edge");
    JButton returnButton = new JButton("Return back");
    JLabel errormessageLabel = new JLabel();

    Graph graph;
    String json_file;

    EditGraph(Graph graph, String json_file){
        this.json_file = json_file;
        this.graph = graph;
        addNodeButton.setBounds(50,10,200,25);
        addNodeButton.setFocusable(false);
        frame.add(addNodeButton);
        addNodeButton.addActionListener(this);

        errormessageLabel.setBounds(10,150,350,35);
        frame.add(errormessageLabel);

        connectButton.setBounds(50,35,200,25);
        connectButton.setFocusable(false);
        frame.add(connectButton);
        connectButton.addActionListener(this);

        removeNodeButton.setBounds(50,60,200,25);
        removeNodeButton.setFocusable(false);
        frame.add(removeNodeButton);
        removeNodeButton.addActionListener(this);

        removeEdgeButton.setBounds(50,85,200,25);
        removeEdgeButton.setFocusable(false);
        frame.add(removeEdgeButton);
        removeEdgeButton.addActionListener(this);

        returnButton.setBounds(50,120,200,25);
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
        if(e.getSource() == addNodeButton){
            Actions act = new Actions(this.graph, 1, json_file);
            this.frame.dispose();
        }
        else if(e.getSource() == connectButton){
            if(this.graph.isEmpty()){
                errormessageLabel.setText("<html>Please load a graph or <br/>init an empty graph and add new nodes to it</html>");
            }
            else {
                Actions act = new Actions(this.graph, 2,json_file);
                this.frame.dispose();
            }
        }
        else if(e.getSource() == removeNodeButton){
            if(this.graph.isEmpty()){
                errormessageLabel.setText("<html>Please load a graph or <br/>init an empty graph and add new nodes to it</html>");
            }
            else {
                Actions act = new Actions(this.graph, 3,json_file);
                this.frame.dispose();
            }
        }
        else if(e.getSource() == removeEdgeButton){
            if(this.graph.isEmpty()){
                errormessageLabel.setText("<html>Please load a graph or <br/>init an empty graph and add new nodes to it</html>");
            }
            else {
                Actions act = new Actions(this.graph, 4,json_file);
                this.frame.dispose();
            }
        }
        else if(e.getSource() == returnButton){
            LoginPage loginPage = new LoginPage(this.graph,json_file);
            this.frame.dispose();
        }
    }
}
