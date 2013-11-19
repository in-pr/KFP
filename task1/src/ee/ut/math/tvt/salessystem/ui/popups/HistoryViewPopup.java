package ee.ut.math.tvt.salessystem.ui.popups;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class HistoryViewPopup extends JFrame {

	private static final long serialVersionUID = 1L; // class version

	private DefaultPopup frame;

	private Map<String, JTextField> elements = new HashMap<String, JTextField>();

	private SalesSystemModel model;

	private String dateField = "Date:";
	private String timeField = "Time:";
	private String totalField = "Total:";
	
	// builds add product panel
	public HistoryViewPopup(HistoryItem historyItem, SalesSystemModel model) {
		String title = "View purchase";

		this.model = model;

		// Make the elements
		elements = new HashMap<String, JTextField>();
		elements.put(dateField, new JTextField(historyItem.getDate()));
		elements.put(timeField, new JTextField(historyItem.getTime()));
		elements.put(totalField,
				new JTextField(String.valueOf(historyItem.getTotal())));

		// Make the window
		frame = new DefaultPopup(title, 400, 280, 2);

		// Make the panel
		JPanel panel = frame.makePanel(title, elements, false);

		// Fill window
		frame.add(panel);
		frame.add(drawBasketPane(historyItem.getGoods()));
		frame.setVisible(true);
	}

	// shopping cart pane
	private JComponent drawBasketPane(List<SoldItem> goods) {

		// Create the basketPane
		JPanel basketPane = new JPanel();
		basketPane.setLayout(new GridBagLayout());
		basketPane.setBorder(BorderFactory.createTitledBorder("Shopping cart"));

		// Create the table, put it inside a scollPane,
		// and add the scrollPane to the basketPanel.
		model.getHistoryInfoTableModel().populateWithData(goods);
		JTable table = new JTable(model.getHistoryInfoTableModel());
		JScrollPane scrollPane = new JScrollPane(table);

		basketPane.add(scrollPane, getBacketScrollPaneConstraints());
		

		return basketPane;
	}

	private GridBagConstraints getBacketScrollPaneConstraints() {
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		return gc;
	}

}
