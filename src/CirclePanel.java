
import javax.swing.*;
import java.awt.*;

/**
 * Custom JPanel responsible for drawing the circle and updating display info.
 */
public class CirclePanel extends JPanel {

    private int diameter = 100; // default diameter of the circle
    private int red = 0, green = 0, blue = 0; // RGB color components
    private String language = "English"; // selected language for label
    private JTextArea infoArea; // reference to the text area for display

    public CirclePanel() {
        setPreferredSize(new Dimension(400, 400)); // suggested size for layout
        setBackground(Color.WHITE); // background color of the panel
    }

    // Connect the external JTextArea to display info text
    public void setInfoArea(JTextArea area) {
        this.infoArea = area;
        updateInfoText(); // initial display update
    }

    // Update the circle's diameter and repaint
    public void setDiameter(int diameter) {
        this.diameter = diameter;
        repaint(); // trigger paintComponent
        updateInfoText(); // update text area
    }

    // Update the circle's color and repaint
    public void setColor(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
        repaint(); // trigger paintComponent
    }

    // Update language used in the display text
    public void setLanguage(String lang) {
        this.language = lang;
        updateInfoText(); // reflect language change immediately
    }

    // Updates the text area based on current diameter and language
    private void updateInfoText() {
        if (infoArea != null) {
            String label = language.equals("Polish") ? "Œrednica" : "Diameter";
            infoArea.setText(label + ": " + diameter + " px");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calculate coordinates to center the circle
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        // Set the current fill color and draw the circle
        g.setColor(new Color(red, green, blue));
        g.fillOval(x, y, diameter, diameter);
    }
}
