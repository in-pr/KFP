package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class HistoryItem implements Cloneable, DisplayableItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "soldItem")
	private List<SoldItem> goods;

	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "TOTAL")
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
