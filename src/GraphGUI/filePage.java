package GraphGUI;

import GraphAndAlgo.Graph;
import GraphAndAlgo.GraphAlgo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class filePage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loadButton = new JButton("Load file");
    JButton saveButton = new JButton("Save file");
    JButton createEmptyButton = new JButton("Create empty graph");
    JButton returnButton = new JButton("Return back");
    JLabel messageLabel = new JLabel();

    String json_file;
    GraphAlgo graphAlgo;

    public filePage(String json_file){
        this.json_file = json_file;
        graphAlgo = new GraphAlgo();

        messageLabel.setBounds(50,120,350,35);
        frame.add(messageLabel);

        loadButton.setBounds(50,10,200,25);
        loadButton.setFocusable(false);
        frame.add(loadButton);
        loadButton.addActionListener(this);

        saveButton.setBounds(50,35,200,25);
        saveButton.setFocusable(false);
        frame.add(saveButton);
        saveButton.addActionListener(this);

        createEmptyButton.setBounds(50, 60, 200, 25);
        createEmptyButton.setFocusable(false);
        frame.add(createEmptyButton);
        createEmptyButton.addActionListener(this);

        returnButton.setBounds(50, 90, 200, 25);
        returnButton.setFocusable(false);
        frame.add(returnButton);
        returnButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public filePage(Graph graph){
        graphAlgo = new GraphAlgo();
        graphAlgo.init(graph);

        messageLabel.setBounds(50,120,350,35);
        frame.add(messageLabel);

        loadButton.setBounds(50,10,200,25);
        loadButton.setFocusable(false);
        frame.add(loadButton);
        loadButton.addActionListener(this);

        saveButton.setBounds(50,35,200,25);
        saveButton.setFocusable(false);
        frame.add(saveButton);
        saveButton.addActionListener(this);

        createEmptyButton.setBounds(50, 60, 200, 25);
        createEmptyButton.setFocusable(false);
        frame.add(createEmptyButton);
        createEmptyButton.addActionListener(this);

        returnButton.setBounds(50, 90, 200, 25);
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
        if(e.getSource() == loadButton){
            LoadSave loadSave = new LoadSave(this.json_file, 1);
        }

        else if(e.getSource() == saveButton){
            LoadSave loadSave = new LoadSave(this.json_file, 2);
        }
        else if(e.getSource() == createEmptyButton){
            Graph emptyGraph = new Graph();
            this.graphAlgo.init(emptyGraph);
            this.messageLabel.setText("An empty graph was created!");
        }
        else if(e.getSource() == returnButton){
            LoginPage loginPage = new LoginPage(this.graphAlgo.getGraph());
            this.frame.dispose();
        }

    }
}
