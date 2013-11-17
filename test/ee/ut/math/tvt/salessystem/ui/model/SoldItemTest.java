package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {

	StockItem item1;

	@Before
	public void setUp() {
		item1 = new StockItem(1L, "Lauaviin", "Joodiku parim kaaslane", 3.50);
	}

	@Test
	public void testGetSum() {
		SoldItem sItem1 = new SoldItem(item1, 2);

		assertEquals(7.0, sItem1.getSum(), 0.0001);
	}

	@Test
	public void testGetSumWithZeroQuantity() {
		SoldItem sItem2 = new SoldItem(item1, 0);

		assertEquals(0.0, sItem2.getSum(), 0.0001);
	}

}
