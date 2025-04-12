import javax.swing.*;
import java.awt.*;

public class CircleSliderGUI {

    public static void main(String[] args) {
        // Run GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new CircleSliderGUI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Circle Slider App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // Custom panel to draw the circle
        CirclePanel circlePanel = new CirclePanel();
        frame.add(circlePanel, BorderLayout.CENTER);

        // Panel for the sliders and controls
        ControlPanel controlPanel = new ControlPanel(circlePanel);
        frame.add(controlPanel, BorderLayout.EAST);

        // Text area at the bottom
        JTextArea infoArea = new JTextArea(2, 20);
        infoArea.setEditable(false);
        circlePanel.setInfoArea(infoArea);
        frame.add(new JScrollPane(infoArea), BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
