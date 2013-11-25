package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.DuplicateProductException;
import ee.ut.math.tvt.salessystem.domain.exception.OutOfStockException;

public class StockTableModelTest {

	StockItem item1;
	StockItem item2;
	StockItem item3;

	@Before
	public void setUp() throws Exception {
		item1 = new StockItem(1L, "Lauaviin", "viin", 4.0, 1);
		item2 = new StockItem(2L, "Originaal", "olu", 2.0, 2);
		item3 = new StockItem(3L, "Lauaviin", "olu", 6.0, 10);

	}

	@Test(expected = DuplicateProductException.class)
	public void testValidateNameUniqueness() throws DuplicateProductException {
		StockTableModel stockTableModel = new StockTableModel();
		stockTableModel.addItem(item1);
		stockTableModel.addItem(item2);
		stockTableModel.addItem(item3);
	}

	@Test(expected = OutOfStockException.class)
	public void testHasEnoughInStock() throws OutOfStockException,
			DuplicateProductException {
		StockTableModel STM = new StockTableModel();
		STM.addItem(item1);
		STM.getItem(1L, 2);
	}

	@Test
	public void testGetItemByIdWhenItemExists()
			throws DuplicateProductException {
		StockTableModel stockTableModel = new StockTableModel();
		stockTableModel.addItem(item1);
		assertEquals(item1, stockTableModel.getItemById(1));
	}

	@Test(expected = java.util.NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException() {
		StockTableModel stockTableModel = new StockTableModel();
		assertEquals(item1, stockTableModel.getItemById(1));
	}
}
