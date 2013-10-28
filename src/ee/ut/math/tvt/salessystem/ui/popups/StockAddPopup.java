package ee.ut.math.tvt.salessystem.ui.popups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class StockAddPopup extends JFrame {

	private static final long serialVersionUID = 1L; // class version

	private DefaultPopup frame;

	private Map<String, JTextField> elements = new HashMap<String, JTextField>();

	private SalesSystemModel model;

	private String idField = "Bar code:";
	private String nameField = "Name:";
	private String descriptionField = "Description:";
	private String priceField = "Price:";
	private String quantityField = "Quantity:";

	// builds add product panel
	public StockAddPopup(SalesSystemModel model) {
		String title = "Add product";

		this.model = model;

		// Make the elements
		elements = new HashMap<String, JTextField>();
		elements.put(idField, new JTextField());
		elements.put(nameField, new JTextField());
		elements.put(descriptionField, new JTextField());
		elements.put(priceField, new JTextField());
		elements.put(quantityField, new JTextField());

		// Make the window
		frame = new DefaultPopup(title, 400, 280, 1);

		// Make the panel
		JPanel panel = frame.makePanel(title, elements, true);

		// Add ok button
		JButton okButton = new JButton("Add product");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct(elements);
			}
		});
		panel.add(okButton);

		// Add cancel button
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(cancelButton);

		// Fill window
		frame.add(panel);
		frame.setVisible(true);
	}

	private void addProduct(Map<String, JTextField> elements) {
		try {
			// Format data
			long id = Long.valueOf(elements.get(idField).getText());
			String name = elements.get(nameField).getText();
			String description = elements.get(descriptionField).getText();
			double price = Double.valueOf(elements.get(priceField).getText());
			int quantity = Integer.valueOf(elements.get(quantityField).getText());
			// Check values
			if (id < 0) {
				throw new IllegalArgumentException(
						"Bar Code must be a non-negative number.");
			}
			if (price < 0) {
				throw new IllegalArgumentException(
						"Price must be a non-negative number.");
			}
			if (quantity < 0) {
				throw new IllegalArgumentException(
						"Quantity must be a non-negative number.");
			}
			// Add product
			StockItem newItem = new StockItem(id, name, description, price,
					quantity);
			model.getWarehouseTableModel().addItem(newItem);
			frame.dispose();
		} catch (IllegalArgumentException e) {
			String message = e.getMessage();
			if (message.equals("")) {
				message = "Data was not entered in the correct format.";
			}
			JOptionPane.showMessageDialog(this, message, "Product not added!",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

}
