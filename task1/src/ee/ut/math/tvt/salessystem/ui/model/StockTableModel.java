package ee.ut.math.tvt.salessystem.ui.model;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.DuplicateProductException;
import ee.ut.math.tvt.salessystem.domain.exception.OutOfStockException;

/**
 * Stock item table model.
 */
public class StockTableModel extends SalesSystemTableModel<StockItem> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(StockTableModel.class);

	public StockTableModel() {
		super(new String[] { "Id", "Name", "Price", "Quantity" });
	}

	@Override
	protected Object getColumnValue(StockItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	/**
	 * Add new stock item to table. If there already is a stock item with same
	 * id, then existing item's quantity will be increased.
	 * 
	 * @param stockItem
	 */
	public void addItem(final StockItem stockItem)
			throws DuplicateProductException {
		try {
			StockItem item = getItemById(stockItem.getId());
			item.setQuantity(item.getQuantity() + stockItem.getQuantity());
			log.debug("Found existing item " + stockItem.getName()
					+ " increased quantity by " + stockItem.getQuantity());
		} catch (NoSuchElementException e) {
			for (StockItem item : getTableRows()) {
				if (stockItem.getName().equals(item.getName())) {
					throw new DuplicateProductException(
							"Product with this name already exists!");
				}
			}
			rows.add(stockItem);
			log.debug("Added " + stockItem.getName() + " quantity of "
					+ stockItem.getQuantity());
		}
		fireTableDataChanged();
	}

	public StockItem getItem(long barCode, int quantity)
			throws OutOfStockException {
		for (StockItem it : rows) {
			if (it.getId() == barCode) {
				if (quantity <= it.getQuantity()) {
					return it;
				} else {
					throw new OutOfStockException("Out of stock!");
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final StockItem stockItem : rows) {
			buffer.append(stockItem.getId() + "\t");
			buffer.append(stockItem.getName() + "\t");
			buffer.append(stockItem.getPrice() + "\t");
			buffer.append(stockItem.getQuantity() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}

}
