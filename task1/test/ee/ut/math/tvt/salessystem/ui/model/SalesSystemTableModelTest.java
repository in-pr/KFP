package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SalesSystemTableModelTest {

	List<StockItem> asd;
	SalesSystemTableModel<StockItem> qwe;
	StockItem sItem1;

	@Before
	public void setUp() throws Exception {
		asd = new ArrayList<StockItem>();
		qwe = new StockTableModel();
		sItem1 = new StockItem(1L, "Lauaviin", "Hea jook", 3.50, 0);
		asd.add(sItem1);
	}

	@Test
	public void testPopulateWithData() {
		qwe.populateWithData(asd);
		StockItem sItem2 = qwe.getTableRows().get(0);
		assertEquals(sItem1.getId(), sItem2.getId());
		assertEquals(sItem1.getName(), sItem2.getName());
		assertEquals(sItem1.getDescription(), sItem2.getDescription());
		assertEquals(sItem1.getPrice(), sItem2.getPrice(), 0.0001);
		assertEquals(sItem1.getQuantity(), sItem2.getQuantity());
	}

}
