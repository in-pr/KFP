package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockTableModelTest {

	StockItem item1;
	StockItem item2;
	StockItem item3;
	@Before
	public void setUp() throws Exception {
		item1=new StockItem(1L, "Lauaviin1", "viin", 4.0, 1);
		item2=new StockItem(2L, "Lauaviin1", "viin", 4.0, 2);
		
	}

	@Test
	public void testValidateNameUniqueness() {
		StockTableModel stockTableModel=new StockTableModel();
		stockTableModel.addItem(item1);
		stockTableModel.addItem(item2);
		stockTableModel.addItem(item1);
		assertEquals(1,stockTableModel.getRowCount());
	}

	//TODO 
	public void testHasEnoughInStock(){
		
	}
	@Test
	public void testGetItemByIdWhenItemExists(){
		StockTableModel stockTableModel=new StockTableModel();
		stockTableModel.addItem(item1);
		assertEquals(item1, stockTableModel.getItemById(1));
	}
	@Test(expected = java.util.NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException(){
		StockTableModel stockTableModel=new StockTableModel();
		assertEquals(item1, stockTableModel.getItemById(1));
	}
}
