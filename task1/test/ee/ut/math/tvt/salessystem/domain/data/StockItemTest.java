package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StockItemTest {

	StockItem item1;

	@Before
	public void setUp() {
		item1 = new StockItem(1L, "Lauaviin", "Joodiku parim kaaslane", 3.50, 2);
	}

	@Test
	public void testClone() {
		StockItem item2 = (StockItem) item1.clone();
		assertEquals(item1, item2);

	}

	@Test
	public void testGetColumn() {
		assertEquals(1L, item1.getColumn(0));
		assertEquals("Lauaviin", item1.getColumn(1));
		assertEquals(3.50, item1.getColumn(2));
		assertEquals(2, item1.getColumn(3));
	}
}
