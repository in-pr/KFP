package ee.ut.math.tvt.kungfupandas;

import java.util.Properties;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

public class IntroUI extends JFrame {

	private static final long serialVersionUID = 1L; // class version

	private static Logger log = Logger.getLogger(IntroUI.class);

	// constructs the user interface
	public IntroUI(Properties params, String version) {

		// sets window properties
		super(params.getProperty("team.name"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(500, 400);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		// makes components
		JLabel[] bits = new JLabel[6];
		try {
			bits[0] = new JLabel(new ImageIcon(getClass().getClassLoader()
					.getResource(params.getProperty("team.logo"))));
		} catch (NullPointerException e) {
			// if file is inaccessible, try a direct stream
			bits[0] = new JLabel(new ImageIcon(params.getProperty("team.logo")));
		}
		bits[1] = new JLabel("Team Name: " + params.getProperty("team.name"));
		bits[2] = new JLabel("Team Leader: "
				+ params.getProperty("team.leader"));
		bits[3] = new JLabel("Team Leader Email: "
				+ params.getProperty("team.leader.email"));
		bits[4] = new JLabel("Team Members: "
				+ params.getProperty("team.members"));
		bits[5] = new JLabel("Software Version: " + version);

		// adds components
		for (JLabel x : bits) {
			add(x);
			add(Box.createVerticalGlue());
		}

		// displays a message indicating that intro window is opened
		log.info("Intro window was opened.");

	}

}
