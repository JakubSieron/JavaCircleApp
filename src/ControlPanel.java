import javax.swing.*;
import java.awt.*;

/**
 * Panel containing all user controls: sliders and language selector.
 */
public class ControlPanel extends JPanel {

    private final CirclePanel circlePanel;

    private int red = 0;
    private int green = 0;
    private int blue = 0;

    public ControlPanel(CirclePanel circlePanel) {
        this.circlePanel = circlePanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(180, 400));
        setBorder(BorderFactory.createTitledBorder("Controls"));

        // Diameter slider
        JSlider diameterSlider = new JSlider(10, 300, 100);
        setupSlider(diameterSlider, "Diameter");
        diameterSlider.addChangeListener(e -> circlePanel.setDiameter(diameterSlider.getValue()));

        // Red slider
        JSlider redSlider = new JSlider(0, 255, 0);
        setupSlider(redSlider, "Red");
        redSlider.addChangeListener(e -> {
            red = redSlider.getValue();
            updateColor();
        });

        // Green slider
        JSlider greenSlider = new JSlider(0, 255, 0);
        setupSlider(greenSlider, "Green");
        greenSlider.addChangeListener(e -> {
            green = greenSlider.getValue();
            updateColor();
        });

        // Blue slider
        JSlider blueSlider = new JSlider(0, 255, 0);
        setupSlider(blueSlider, "Blue");
        blueSlider.addChangeListener(e -> {
            blue = blueSlider.getValue();
            updateColor();
        });

        // Language selection
        add(Box.createRigidArea(new Dimension(0, 10)));
        JLabel langLabel = new JLabel("Select Language:");
        add(langLabel);

        String[] languages = {"English", "Polish"};
        JComboBox<String> languageDropdown = new JComboBox<>(languages);
        languageDropdown.setMaximumSize(new Dimension(150, 25));
        languageDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        languageDropdown.addActionListener(e -> {
            String selected = (String) languageDropdown.getSelectedItem();
            circlePanel.setLanguage(selected);
        });
        add(languageDropdown);
    }

    private void updateColor() {
        circlePanel.setColor(red, green, blue);
    }

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
}

