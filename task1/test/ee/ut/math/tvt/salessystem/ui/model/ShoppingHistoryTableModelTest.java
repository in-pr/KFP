package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class ShoppingHistoryTableModelTest {
	
	HistoryItem hItem;
	ShoppingHistoryTableModel shtm;
	
	@Before
	public void setUp() throws Exception {
		List<SoldItem> goods = new ArrayList<SoldItem>();
		goods.add(new SoldItem(new StockItem(1L, "Lauaviin", "So semu", 3.50), 10));
		goods.add(new SoldItem(new StockItem(1L, "Kurgivesi", "Mo semu", 1.50), 6));
		hItem = new HistoryItem(goods);
		shtm = new ShoppingHistoryTableModel();
		shtm.addItem(hItem);
	}
	
	@Test
	public void testAddHistoryItem() {
		assertEquals(hItem.getDate(), shtm.getTableRows().get(0).getDate());
		assertEquals(hItem.getTime(), shtm.getTableRows().get(0).getTime());
		assertEquals(hItem.getTotal(), shtm.getTableRows().get(0).getTotal(), 0.0001);
	}
	
	@Test
	public void testGetColumnValue() {
		assertEquals(hItem.getDate(), shtm.getColumnValue(hItem, 0));
		assertEquals(hItem.getTime(), shtm.getColumnValue(hItem, 1));
		assertEquals(hItem.getTotal(), shtm.getColumnValue(hItem, 2));
	}

}
