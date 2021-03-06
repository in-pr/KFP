package ee.ut.math.tvt.salessystem.ui.model;

import java.util.List;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {

	private static final Logger log = Logger.getLogger(SalesSystemModel.class);

	// Warehouse model
	private StockTableModel warehouseTableModel;

	// Current shopping cart model
	private PurchaseInfoTableModel currentPurchaseTableModel;

	// Shopping history model
	private ShoppingHistoryTableModel historyTableModel;
	private PurchaseInfoTableModel historyPurchaseTableModel;

	private final SalesDomainController domainController;

	/**
	 * Construct application model.
	 * 
	 * @param domainController
	 *            Sales domain controller.
	 */
	public SalesSystemModel(SalesDomainController domainController) {
		this.domainController = domainController;

		warehouseTableModel = new StockTableModel();
		currentPurchaseTableModel = new PurchaseInfoTableModel();
		historyTableModel = new ShoppingHistoryTableModel();
		historyPurchaseTableModel = new PurchaseInfoTableModel();

		// populate history model with data from the database
		List<HistoryItem> previousPurchases = HibernateUtil.currentSession()
				.createQuery("from HistoryItem").list();
		historyTableModel.populateWithData(previousPurchases);

		// populate stock model with data from the warehouse
		List<StockItem> warehouseContents = HibernateUtil.currentSession()
				.createQuery("from StockItem").list();
		warehouseTableModel.populateWithData(warehouseContents);

	}

	public StockTableModel getWarehouseTableModel() {
		return warehouseTableModel;
	}

	public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
		return currentPurchaseTableModel;
	}

	public ShoppingHistoryTableModel getHistoryTableModel() {
		return historyTableModel;
	}

	public PurchaseInfoTableModel getHistoryInfoTableModel() {
		return historyPurchaseTableModel;
	}

}
