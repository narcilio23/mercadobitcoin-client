package narcilio.mercadobitcoin.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import narcilio.mercadobitcoin.MercadoBitcoinApplication;
import narcilio.mercadobitcoin.controller.TradeController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MercadoBitcoinApplication.class)
public class TradeControllerTest {

	@Autowired
	TradeController tradeController;
	
	@Test
	public void testAHigherSale() throws IOException {
		
		assertEquals(tradeController.getHigherSales().size(), 5);
		
		assertEquals(tradeController.getHigherSales().get(0).getTid(), 739724);
	}
	
	@Test
	public void testAHigherPurchase() throws IOException {

		assertEquals(tradeController.getHigherPurchases().size(), 5);
		
		assertEquals(tradeController.getHigherPurchases().get(0).getTid(), 739728);
	}
	
	@Test
	public void testBAverageSale() throws IOException {
		
		assertEquals(tradeController.getAverageSale(), BigDecimal.valueOf(4355.62357495));
	}
	
	@Test
	public void testBAveragePurchase() throws IOException {
		
		assertEquals(tradeController.getAveragePurchase(), BigDecimal.valueOf(5259.24499388));
	}
	
	@Test
	public void testCMedianSale() throws IOException {
		
		assertEquals(tradeController.getMedianSale(), BigDecimal.valueOf(9593.00001));
	}
	
	@Test
	public void testCMedianPurchase() throws IOException {
		
		assertEquals(tradeController.getMedianPurchase(), BigDecimal.valueOf(9650.0));
	}
}
