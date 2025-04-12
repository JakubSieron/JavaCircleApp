
import javax.swing.*;
import java.awt.*;

/**
 * Main class that sets up and runs the application GUI.
 */
public class CircleSliderGUI {

    public static void main(String[] args) {
        // Run GUI on the Event Dispatch Thread (recommended for Swing apps)
        SwingUtilities.invokeLater(() -> new CircleSliderGUI().createAndShowGUI());
    }

    /**
     * Initializes the GUI components and layout.
     */
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Circle Slider App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // Custom panel that handles drawing the circle
        CirclePanel circlePanel = new CirclePanel();
        frame.add(circlePanel, BorderLayout.CENTER);

        // Panel containing sliders and language selector
        ControlPanel controlPanel = new ControlPanel(circlePanel);
        frame.add(controlPanel, BorderLayout.EAST);

        // Text area to display the diameter info
        JTextArea infoArea = new JTextArea(2, 20);
        infoArea.setEditable(false); // read-only
        circlePanel.setInfoArea(infoArea); // connect it to CirclePanel
        frame.add(new JScrollPane(infoArea), BorderLayout.SOUTH);

        frame.setVisible(true); // show the window
    }
}
