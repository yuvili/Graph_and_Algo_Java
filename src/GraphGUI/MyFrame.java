package GraphGUI;

import BaseElements.Vertex;
import GraphAndAlgo.GraphAlgo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MyFrame extends JFrame {
    MyPanel panel;
    GraphAlgo graphAlgo;

    MyFrame(GraphAlgo graphAlgo){
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) (screenDimension.width * 0.9);
        int frameHeight = (int) (screenDimension.height * 0.7);

        this.graphAlgo = graphAlgo;
        panel = new MyPanel(graphAlgo, frameWidth, frameHeight);

        this.setSize(frameWidth,frameHeight);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
    }

    MyFrame(GraphAlgo graphAlgo, List<Vertex> ans){
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int frameWidth = (int) (screenDimension.width * 0.9);
        int frameHeight = (int) (screenDimension.height * 0.7);

        this.graphAlgo = graphAlgo;
        panel = new MyPanel(graphAlgo, frameWidth, frameHeight, ans);

        this.setSize(frameWidth,frameHeight);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
    }
}
