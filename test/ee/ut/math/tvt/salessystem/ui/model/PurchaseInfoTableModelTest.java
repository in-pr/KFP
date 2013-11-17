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
	}

	@Test
	public void testAddSoldItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSumWithNoItems() {
		pit.getSum();
	}

	@Test
	public void testGetSumWithOneItem() {
		pit.addItem(item1);
	}

	@Test
	public void testGetSumWithMultipleItems() {
		fail("Not yet implemented");
	}

}
