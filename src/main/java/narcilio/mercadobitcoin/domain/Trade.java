package narcilio.mercadobitcoin.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {

	private long tid;
	private String type;
	private Date date;
	private BigDecimal price;
	private BigDecimal amount;

	public long getTid() {
		return tid;
	}

	public String getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s - %s", tid, type, date, price, amount);
	}

}
