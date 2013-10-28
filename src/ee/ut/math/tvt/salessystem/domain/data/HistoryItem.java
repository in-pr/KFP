package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HistoryItem implements Cloneable, DisplayableItem {

	private Long id;
	private List<SoldItem> goods;

	private Date date;
	private double total;

	public HistoryItem(List<SoldItem> goods) {
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		this.total = 0;
				this.goods = goods;
		for (SoldItem soldItem : goods) {
			this.total += soldItem.getSum();
		}
	}

	@Override
	public Long getId() {
		return id;
	}
	
	public List<SoldItem> getGoods() {
		return goods;
	}

	public String getDate() {
		return new SimpleDateFormat("dd.MM.yyyy").format(date);
	}

	public String getTime() {
		return new SimpleDateFormat("HH:mm:ss").format(date);
	}

	public double getTotal() {
		return total;
	}

}
