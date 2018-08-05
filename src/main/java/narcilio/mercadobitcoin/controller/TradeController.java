package narcilio.mercadobitcoin.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import narcilio.mercadobitcoin.domain.Trade;
import narcilio.mercadobitcoin.domain.TradeResume;
import narcilio.mercadobitcoin.service.TradeSevice;

@RestController
@RequestMapping("/trades")
public class TradeController {
	
	@Autowired
	private TradeSevice tradeService;
	private TradeResume tradeResume;
	
	@PostConstruct
	public void init() {
		tradeResume = tradeService.getTradeResume();
	}
	
	@GetMapping("/higher_sales")
	public List<Trade> getHigherSales(){
		return tradeResume.getHigherSales();
	}
	
	@GetMapping("/higher_purchases")
	public List<Trade> getHigherPurchases(){
		return tradeResume.getHigherPurchases();
	}
	
	@GetMapping("/average_sale")
	public BigDecimal getAverageSale(){
		return tradeResume.getAverageSale();
	}
	
	@GetMapping("/average_purchase")
	public BigDecimal getAveragePurchase(){
		return tradeResume.getAveragePurchase();
	}
	
	@GetMapping("/median_sale")
	public BigDecimal getMedianSale(){
		return tradeResume.getMedianSale();
	}
	
	@GetMapping("/median_purchase")
	public BigDecimal getMedianPurchase(){
		return tradeResume.getMedianPurchase();
	}
	
	@GetMapping("/default_deviation_sale")
	public BigDecimal getDefaultDeviationSale(){
		return tradeResume.getDefaultDeviationSale();
	}
	
	@GetMapping("/default_deviation_purchase")
	public BigDecimal getDefaultDeviationPurchase(){
		return tradeResume.getDefaultDeviationPurchase();
	}
}
