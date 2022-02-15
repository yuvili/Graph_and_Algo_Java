package GraphGUI;

import GraphAndAlgo.Graph;
import GraphAndAlgo.GraphAlgo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton fileButton = new JButton("File");
    JButton editButton = new JButton("Edit Graph");
    JButton algoButton = new JButton("Run Graph's Algorithms");
    JLabel messageLabel = new JLabel();

    String json_file;
    GraphAlgo graphAlgo;

    public LoginPage(String json_file){
        this.json_file = json_file;
        graphAlgo = new GraphAlgo();

        messageLabel.setBounds(90,110,230,70);
        frame.add(messageLabel);

        fileButton.setBounds(100,10,200,25);
        fileButton.setFocusable(false);
        frame.add(fileButton);
        fileButton.addActionListener(this);

        editButton.setBounds(100,35,200,25);
        editButton.setFocusable(false);
        frame.add(editButton);
        editButton.addActionListener(this);

        algoButton.setBounds(100,60,200,25);
        algoButton.setFocusable(false);
        frame.add(algoButton);
        algoButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    LoginPage(Graph graph){
        graphAlgo = new GraphAlgo();
        graphAlgo.init(graph);

        messageLabel.setBounds(100,10,200,25);
        frame.add(messageLabel);

        fileButton.setBounds(100,10,200,25);
        fileButton.setFocusable(false);
        frame.add(fileButton);
        fileButton.addActionListener(this);

        editButton.setBounds(100,35,200,25);
        editButton.setFocusable(false);
        frame.add(editButton);
        editButton.addActionListener(this);

        algoButton.setBounds(100,60,200,25);
        algoButton.setFocusable(false);
        frame.add(algoButton);
        algoButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    LoginPage(Graph graph, String json_file){
        this.json_file = json_file;
        graphAlgo = new GraphAlgo();
        graphAlgo.init(graph);

        messageLabel.setBounds(100,10,200,25);
        frame.add(messageLabel);

        fileButton.setBounds(100,10,200,25);
        fileButton.setFocusable(false);
        frame.add(fileButton);
        fileButton.addActionListener(this);

        editButton.setBounds(100,35,200,25);
        editButton.setFocusable(false);
        frame.add(editButton);
        editButton.addActionListener(this);

        algoButton.setBounds(100,60,200,25);
        algoButton.setFocusable(false);
        frame.add(algoButton);
        algoButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fileButton) {
            filePage loadPage = new filePage(json_file);
            this.frame.dispose();
        }
        else if(e.getSource() == editButton){
            EditGraph editGraph = new EditGraph(this.graphAlgo.getGraph(), json_file);
            this.frame.dispose();
        }
        else if(e.getSource() == algoButton){
            if(this.graphAlgo.isEmpty()){
                messageLabel.setText("<html>Please load a graph or init an empty <br/>graph to add new nodes to it</html>");
            }
            else {
                AlgoGraph algoGraph = new AlgoGraph(this.graphAlgo.getGraph());
                this.frame.dispose();
            }
        }
    }
}
