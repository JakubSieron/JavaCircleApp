import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {

    private int diameter = 100;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private String language = "English"; // or "Irish"
    private JTextArea infoArea;

    public CirclePanel() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    public void setInfoArea(JTextArea area) {
        this.infoArea = area;
        updateInfoText();
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
        repaint();
        updateInfoText();
    }

    public void setColor(int r, int g, int b) {
        this.red = r;
        this.green = g;
        this.blue = b;
        repaint();
    }

    public void setLanguage(String lang) {
        this.language = lang;
        updateInfoText();
    }

    private void updateInfoText() {
        if (infoArea != null) {
        	String label = language.equals("Polish") ? "Œrednica" : "Diameter";
            infoArea.setText(label + ": " + diameter + " px");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Center circle in panel
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g.setColor(new Color(red, green, blue));
        g.fillOval(x, y, diameter, diameter);
    }
}
