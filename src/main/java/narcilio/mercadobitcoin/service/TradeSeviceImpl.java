package narcilio.mercadobitcoin.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import narcilio.mercadobitcoin.connection.MercadoBitcoinAPIConnection;
import narcilio.mercadobitcoin.domain.Trade;
import narcilio.mercadobitcoin.domain.TradeResume;

@Service
public class TradeSeviceImpl implements TradeSevice {
	
	private static final Logger LOG = Logger.getLogger("TradeSeviceImpl");

	private Supplier<MercadoBitcoinAPIConnection> connectionFactory;
	
	public TradeSeviceImpl() {
		connectionFactory = MercadoBitcoinAPIConnection::new;
	}

	@Override
	public TradeResume getTradeResume() {
		try {
			Trade[] trades = connectionFactory.get().execute("GET", "/BTC/trades/1501871369/1501891200/", Trade[].class);
			return new TradeResume(Arrays.asList(trades));
		}catch(IOException e) {
			LOG.log(Level.SEVERE, "Fail on connecting to API", e.getMessage());
		}
		return null;
	}

	
}
