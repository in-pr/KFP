package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class PurchaseInfoTableModelTest {

	PurchaseInfoTableModel pit;
	SoldItem item1, item2, item3, item4;

	@Before
	public void setUp() throws Exception {
		pit = new PurchaseInfoTableModel();
		item1 = new SoldItem(new StockItem(1L, "Lauaviin", "viin", 3.50), 3);
		item2 = new SoldItem(new StockItem(1L, "Hapukurk", "sakuska", 0.40), 10);
		item3 = new SoldItem(new StockItem(1L, "Pirni Fizz", "siider", 2.00), 1);
	}

	@Test
	public void testAddSoldItem() {
		pit.addItem(item1);
		SoldItem mItem = pit.getTableRows().get(0);
		
		assertEquals(item1.getStockItem().getId(), mItem.getStockItem().getId());
		assertEquals(item1.getStockItem().getName(), mItem.getStockItem().getName());
		assertEquals(item1.getStockItem().getDescription(), mItem.getStockItem().getDescription());
		assertEquals(item1.getStockItem().getPrice(), mItem.getStockItem().getPrice(), 0.0001);
		assertEquals(item1.getStockItem().getQuantity(), mItem.getStockItem().getQuantity());
		assertEquals(item1.getQuantity(), mItem.getQuantity());
	}

	@Test
	public void testGetSumWithNoItems() {
		assertEquals(0.00, pit.getSum(), 0.0001);
	}

	@Test
	public void testGetSumWithOneItem() {
		pit.addItem(item1);
		assertEquals(10.50, pit.getSum(), 0.0001);
	}

	@Test
	public void testGetSumWithMultipleItems() {
		pit.addItem(item1);
		pit.addItem(item2);
		pit.addItem(item3);
		assertEquals(16.50, pit.getSum(), 0.0001);
	}

}
