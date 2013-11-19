package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.popups.PurchaseConfirmPopup;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {

	public void submitCurrentPurchase(List<SoldItem> goods)
			throws VerificationFailedException {
	}

	public void submitCurrentPurchase(List<SoldItem> goods,
			SalesSystemModel model) throws VerificationFailedException {
		// Let's assume we have checked and found out that the buyer is
		// underaged and
		// cannot buy chupa-chups
		// throw new VerificationFailedException("Underaged!");
		// XXX - Save purchase
		HistoryItem newHistoryItem = new HistoryItem(goods);
		model.getHistoryTableModel().addItem(newHistoryItem);
		Session em = HibernateUtil.currentSession();
		em.getTransaction().begin();
		for (SoldItem sItem : goods) {
			sItem.getStockItem().setQuantity(
					sItem.getStockItem().getQuantity() - sItem.getQuantity());
			sItem.setHistoryItem(newHistoryItem);
			em.update(sItem.getStockItem());
		}

		em.getTransaction().commit();
	}

	public void cancelCurrentPurchase() throws VerificationFailedException {
		// XXX - Cancel current purchase
	}

	public void startNewPurchase() throws VerificationFailedException {
		// XXX - Start new purchase
	}

	public List<StockItem> loadWarehouseState() {
		// XXX mock implementation
		List<StockItem> dataset = new ArrayList<StockItem>();

		StockItem chips = new StockItem(1l, "Lays chips", "Potato chips", 11.0,
				5);
		StockItem chupaChups = new StockItem(2l, "Chupa-chups", "Sweets", 8.0,
				8);
		StockItem frankfurters = new StockItem(3l, "Frankfurters",
				"Beer sauseges", 15.0, 12);
		StockItem beer = new StockItem(4l, "Free Beer", "Student's delight",
				0.0, 100);

		dataset.add(chips);
		dataset.add(chupaChups);
		dataset.add(frankfurters);
		dataset.add(beer);

		return dataset;
	}

	public void endSession() {
		HibernateUtil.closeSession();
	}

}