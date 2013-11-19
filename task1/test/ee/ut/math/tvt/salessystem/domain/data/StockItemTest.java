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
		// StockItem item3 = new StockItem(1L, "Lauaviin",
		// "Joodiku parim kaaslane", 3.50);

		assertEquals(item1.getId(), item2.getId());
		assertEquals(item1.getName(), item2.getName());
		assertEquals(item1.getDescription(), item2.getDescription());
		assertEquals(item1.getPrice(), item2.getPrice(), 0.0001);
		assertEquals(item1.getQuantity(), item2.getQuantity());
	}

	@Test
	public void testGetColumn() {
		assertEquals(1L, item1.getColumn(0));
		assertEquals("Lauaviin", item1.getColumn(1));
		assertEquals(3.50, item1.getColumn(2));
		assertEquals(2, item1.getColumn(3));
	}
}
