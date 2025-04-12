import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ControlPanel extends JPanel {

    private final CirclePanel circlePanel;

    public ControlPanel(CirclePanel circlePanel) {
        this.circlePanel = circlePanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(180, 400));
        setBorder(BorderFactory.createTitledBorder("Controls"));

        // Diameter Slider
        JSlider diameterSlider = new JSlider(10, 300, 100);
        setupSlider(diameterSlider, "Diameter");
        diameterSlider.addChangeListener(e -> circlePanel.setDiameter(diameterSlider.getValue()));

        // RED Slider
        JSlider redSlider = new JSlider(0, 255, 0);
        setupSlider(redSlider, "Red");
        redSlider.addChangeListener(e -> updateColor(redSlider, null, null));

        // GREEN Slider
        JSlider greenSlider = new JSlider(0, 255, 0);
        setupSlider(greenSlider, "Green");
        greenSlider.addChangeListener(e -> updateColor(null, greenSlider, null));

        // BLUE Slider
        JSlider blueSlider = new JSlider(0, 255, 0);
        setupSlider(blueSlider, "Blue");
        blueSlider.addChangeListener(e -> updateColor(null, null, blueSlider));

        // Language selector
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

    private void updateColor(JSlider r, JSlider g, JSlider b) {
        int red = r != null ? r.getValue() : circlePanel.getForeground().getRed();
        int green = g != null ? g.getValue() : circlePanel.getForeground().getGreen();
        int blue = b != null ? b.getValue() : circlePanel.getForeground().getBlue();
        circlePanel.setColor(red, green, blue);
    }
}
