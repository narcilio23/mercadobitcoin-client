package narcilio.mercadobitcoin.service;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import narcilio.mercadobitcoin.MercadoBitcoinApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MercadoBitcoinApplication.class)
public class TradeServiceTest {
	
	@Autowired
	TradeSevice service;
	
	@Test
	public void testAExecute() throws IOException {
		
		assertNotNull(service.getTradeResume());
	}

}
