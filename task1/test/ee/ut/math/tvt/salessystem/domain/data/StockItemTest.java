package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StockItemTest {
	
	StockItem item1;

	@Before
	public void setUp() {
		item1 = new StockItem(1L, "Lauaviin", "Joodiku parim kaaslane", 3.50);
	}

	@Test
	public void testClone() {
		StockItem item2 = (StockItem) item1.clone();
//		StockItem item3 = new StockItem(1L, "Lauaviin", "Joodiku parim kaaslane", 3.50);
		
		assertEquals(item1, item2);
	}

	@Test
	public void testGetColumn() {
		assertEquals(3.50, item1.getColumn(2));
		
	}
}
