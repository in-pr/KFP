package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;

/**
 * Shopping History table model.
 */
public class ShoppingHistoryTableModel extends
		SalesSystemTableModel<HistoryItem> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(StockTableModel.class);

	public ShoppingHistoryTableModel() {
		super(new String[] { "Date", "Time", "Total" });
	}

	@Override
	protected Object getColumnValue(HistoryItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getDate();
		case 1:
			return item.getTime();
		case 2:
			return item.getTotal();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	/**
	 * Add new history item to table.
	 * 
	 * @param historyItem
	 */
	public void addItem(final HistoryItem historyItem) {
		rows.add(historyItem);
		fireTableDataChanged();
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final HistoryItem historyItem : rows) {
			buffer.append(historyItem.getDate() + "\t");
			buffer.append(historyItem.getTime() + "\t");
			buffer.append(historyItem.getTotal() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}

}
