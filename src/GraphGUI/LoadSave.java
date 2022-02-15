package GraphGUI;

import GraphAndAlgo.GraphAlgo;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadSave implements ActionListener {
    JFrame frame = new JFrame();
    JButton loadCButton = new JButton("Load file from your computer's files");
    JButton loadSButton = new JButton("Load your commit file");
    JButton saveCButton = new JButton("Save graph on your computer");
    JButton saveSButton = new JButton("Save graph on your commit file");
    JButton createEmptyButton = new JButton("Create empty graph");
    JButton returnButton = new JButton("Return back");
    JLabel messageLabel = new JLabel();

    String json_file;
    GraphAlgo graphAlgo;

    LoadSave(String json_file, int a){
        this.json_file = json_file;
        graphAlgo = new GraphAlgo();

        messageLabel.setBounds(100,120,350,35);
        frame.add(messageLabel);
        if(a==1) {
            loadCButton.setBounds(50, 10, 300, 25);
            loadCButton.setFocusable(false);
            frame.add(loadCButton);
            loadCButton.addActionListener(this);

            loadSButton.setBounds(50, 35, 300, 25);
            loadSButton.setFocusable(false);
            frame.add(loadSButton);
            loadSButton.addActionListener(this);

            returnButton.setBounds(100, 70, 200, 25);
            returnButton.setFocusable(false);
            frame.add(returnButton);
            returnButton.addActionListener(this);
        }
        else if(a==2) {
            saveCButton.setBounds(50, 10, 300, 25);
            saveCButton.setFocusable(false);
            frame.add(saveCButton);
            saveCButton.addActionListener(this);

            saveSButton.setBounds(50, 35, 300, 25);
            saveSButton.setFocusable(false);
            frame.add(saveSButton);
            saveSButton.addActionListener(this);

            returnButton.setBounds(100, 70, 200, 25);
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
        if(e.getSource() == loadCButton){
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
            j.setDialogTitle("Load graph from file");

            int userSelection1 = j.showSaveDialog(null);
            if (userSelection1 == JFileChooser.APPROVE_OPTION) {
                graphAlgo.load(j.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Load file from: " + j.getSelectedFile().getAbsolutePath());
            }
            MyFrame newFrame = new MyFrame(graphAlgo);
        }
        else if(e.getSource() == loadSButton){
            boolean b = this.graphAlgo.load(this.json_file);
            if (b){
                messageLabel.setText("The graph was loaded successfully");
                MyFrame newFrame = new MyFrame(graphAlgo);
            }
            else {
                messageLabel.setText("Couldn't load file");
            }
        }
        else if(e.getSource() == saveCButton){
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
            int userSelection1 = j.showSaveDialog(null);
            if (userSelection1 == JFileChooser.APPROVE_OPTION) {
                System.out.println("Saved as file - " + j.getSelectedFile().getAbsolutePath());
                graphAlgo.save(j.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Saved graph in - " + j.getSelectedFile().getAbsolutePath());
            }
        }
        else if(e.getSource() == saveSButton){
            boolean b = this.graphAlgo.save(this.json_file);
            if (b){
                messageLabel.setText("The graph was saved successfully");
            }
            else {
                messageLabel.setText("Couldn't save file");
            }
        }
        else if(e.getSource() == returnButton){
            LoginPage loginPage = new LoginPage(this.graphAlgo.getGraph());
            this.frame.dispose();
        }
    }
}
