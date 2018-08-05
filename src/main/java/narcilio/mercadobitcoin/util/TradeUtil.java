package narcilio.mercadobitcoin.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import narcilio.mercadobitcoin.domain.Trade;

public class TradeUtil {
	
	public static List<Trade> calculateTopFive(List<Trade> trades, String type) {
		return trades.stream()
				.filter(t -> t.getType().equals(type))
				.sorted(Comparator
							.comparing(Trade::getPrice).reversed()
							.thenComparing(Comparator.comparing(Trade::getDate).reversed()))
				.limit(5)
				.collect(Collectors.toList());
		
	}
	
	public static  BigDecimal calculateAverage(List<Trade> trades, String type) {
		return trades.stream()
				.filter(t -> t.getType().equals(type))
				.map(Trade::getPrice)
				.reduce(BigDecimal::add)
				.get()
				.divide(BigDecimal.valueOf(trades.size()), RoundingMode.HALF_EVEN);
	}
	
	public static  BigDecimal calculateMedian(List<Trade> trades, String type) {
		List<Trade> filteredTrades = trades.stream()
				.filter(t -> t.getType().equals(type))
				.collect(Collectors.toList());
		
		DoubleStream sortedPrices = filteredTrades.stream()
				.mapToDouble(t -> t.getPrice().doubleValue())
				.sorted();
		
		double median = filteredTrades.size()%2 == 0?
				sortedPrices
					.skip(filteredTrades.size()/2-1)
					.limit(2)
					.average()
					.orElse(0): 
						
				sortedPrices
					.skip(filteredTrades.size()/2)
					.findFirst()
					.orElse(0);
					
		return BigDecimal.valueOf(median);
	}
	
	public static  BigDecimal calculateDefaultDeviation(List<Trade> trades, String type) {
		return trades.stream()
				.filter(t -> t.getType().equals(type))
				.map(t -> t.getPrice().doubleValue())
				.collect(Collector.of(
						DefaultDeviationStatistic::new,
						DefaultDeviationStatistic::accept,
						DefaultDeviationStatistic::combine,
		                    d -> d.getStandardDeviation()
		                ));
		
		
	}
	
}
