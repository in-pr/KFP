package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;

import ee.ut.math.tvt.salessystem.util.HibernateUtil;
@Entity
@Table(name = "HISTORY")
public class HistoryItem implements Cloneable, DisplayableItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "historyItem")
	private List<SoldItem> goods;

	@Column(name = "SOLD_DATE")
	private Date date;
	
	@Column(name = "TOTAL")
	private double total;

	public HistoryItem(){
	}
	
	public HistoryItem(List<SoldItem> goods) {
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		this.total = 0;
				this.goods = goods;
		for (SoldItem soldItem : goods) {
			this.total += soldItem.getSum();
		}
		
		this.saveHistoryItem();
	}

	public void saveHistoryItem(){
		Session em = HibernateUtil.currentSession();
		em.getTransaction().begin();
		for(SoldItem solditem : goods){
			em.persist(solditem);
		}
		em.persist(this);
		 
		em.getTransaction().commit();
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
