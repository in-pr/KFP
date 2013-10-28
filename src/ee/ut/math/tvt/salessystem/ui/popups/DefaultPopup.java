package ee.ut.math.tvt.salessystem.ui.popups;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DefaultPopup extends JFrame {

	private static final long serialVersionUID = 1L; // class version

	// constructs the user interface
	public DefaultPopup(String title, int width, int height) {
		super(title);
		setSize(width, height);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width - width) / 2, (screen.height - height) / 2);
	}

	// makes the panel
	public JPanel makePanel(String title, Map<String, JTextField> elements) {
		// Create the panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(elements.size() + 1, 2));
		// panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setBorder(BorderFactory.createTitledBorder(title));
		for (Entry<String, JTextField> elem : elements.entrySet()) {
			panel.add(new JLabel(elem.getKey()));
			panel.add(elem.getValue());
		}
		return panel;
	}

}
