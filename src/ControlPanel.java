
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Panel containing all user controls: sliders and language selector.
 */
public class ControlPanel extends JPanel {

    private final CirclePanel circlePanel; // reference to the drawing panel

    public ControlPanel(CirclePanel circlePanel) {
        this.circlePanel = circlePanel;

        // Use vertical layout for stacking controls
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(180, 400));
        setBorder(BorderFactory.createTitledBorder("Controls"));

        // Create and configure the diameter slider
        JSlider diameterSlider = new JSlider(10, 300, 100);
        setupSlider(diameterSlider, "Diameter");
        diameterSlider.addChangeListener(e -> circlePanel.setDiameter(diameterSlider.getValue()));

        // RED color slider
        JSlider redSlider = new JSlider(0, 255, 0);
        setupSlider(redSlider, "Red");
        redSlider.addChangeListener(e -> updateColor(redSlider, null, null));

        // GREEN color slider
        JSlider greenSlider = new JSlider(0, 255, 0);
        setupSlider(greenSlider, "Green");
        greenSlider.addChangeListener(e -> updateColor(null, greenSlider, null));

        // BLUE color slider
        JSlider blueSlider = new JSlider(0, 255, 0);
        setupSlider(blueSlider, "Blue");
        blueSlider.addChangeListener(e -> updateColor(null, null, blueSlider));

        // Dropdown menu for selecting language
        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel langLabel = new JLabel("Select Language:");
        add(langLabel);

        String[] languages = {"English", "Polish"};
        JComboBox<String> languageDropdown = new JComboBox<>(languages);
        languageDropdown.setMaximumSize(new Dimension(150, 25));
        languageDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        languageDropdown.addActionListener(e -> {
            String selected = (String) languageDropdown.getSelectedItem();
            circlePanel.setLanguage(selected); // apply language choice
        });

        add(languageDropdown);
    }

    // Helper method to format sliders with labels and tick marks
    private void setupSlider(JSlider slider, String label) {
        slider.setMajorTickSpacing(slider.getMaximum() / 2);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JLabel sliderLabel = new JLabel(label, JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(sliderLabel);
        add(slider);
    }

    // Helper method to update color by checking which sliders were adjusted
    private void updateColor(JSlider r, JSlider g, JSlider b) {
        int red = r != null ? r.getValue() : circlePanel.getForeground().getRed();
        int green = g != null ? g.getValue() : circlePanel.getForeground().getGreen();
        int blue = b != null ? b.getValue() : circlePanel.getForeground().getBlue();
        circlePanel.setColor(red, green, blue);
    }
}
