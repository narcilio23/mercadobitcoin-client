package narcilio.mercadobitcoin.connection;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.function.Supplier;

import org.junit.Before;
import org.junit.Test;

import narcilio.mercadobitcoin.connection.MercadoBitcoinAPIConnection;
import narcilio.mercadobitcoin.domain.Trade;

public class MercadoBitcoinAPIConnectionTest {

	Supplier<MercadoBitcoinAPIConnection> connectionFactory;

	@Before
	public void init() {
		connectionFactory = MercadoBitcoinAPIConnection::new;
	}

	@Test
	public void testAConnection() throws IOException {
		assertNotNull(connectionFactory.get().execute("GET", "/BTC/trades/1501871369/1501891200/", Trade[].class));
	}
}
