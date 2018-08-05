package narcilio.mercadobitcoin.domain;

import java.math.BigDecimal;
import java.util.List;

import narcilio.mercadobitcoin.util.TradeUtil;

public class TradeResume {

	private List<Trade> higherSales;
	private List<Trade> higherPurchases;
	private BigDecimal averageSale;
	private BigDecimal averagePurchase;
	private BigDecimal medianSale;
	private BigDecimal medianPurchase;
	private BigDecimal defaultDeviationSale;
	private BigDecimal defaultDeviationPurchase;
	
	public TradeResume(List<Trade> trades) {
		higherSales = TradeUtil.calculateTopFive(trades, "sell");
		higherPurchases = TradeUtil.calculateTopFive(trades, "buy");
		averageSale = TradeUtil.calculateAverage(trades, "sell");
		averagePurchase = TradeUtil.calculateAverage(trades, "buy");
		medianSale = TradeUtil.calculateMedian(trades, "sell");
		medianPurchase = TradeUtil.calculateMedian(trades, "buy");
		defaultDeviationSale = TradeUtil.calculateDefaultDeviation(trades, "sell");
		defaultDeviationPurchase = TradeUtil.calculateDefaultDeviation(trades, "buy");
	}

	public List<Trade> getHigherSales() {
		return higherSales;
	}

	public List<Trade> getHigherPurchases() {
		return higherPurchases;
	}

	public BigDecimal getAverageSale() {
		return averageSale;
	}

	public BigDecimal getAveragePurchase() {
		return averagePurchase;
	}

	public BigDecimal getMedianSale() {
		return medianSale;
	}

	public BigDecimal getMedianPurchase() {
		return medianPurchase;
	}

	public BigDecimal getDefaultDeviationSale() {
		return defaultDeviationSale;
	}

	public BigDecimal getDefaultDeviationPurchase() {
		return defaultDeviationPurchase;
	}

}
