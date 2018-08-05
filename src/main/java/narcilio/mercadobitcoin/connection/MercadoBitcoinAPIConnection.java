package narcilio.mercadobitcoin.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import narcilio.mercadobitcoin.adapter.LongToDateAdapter;

public class MercadoBitcoinAPIConnection {

	private static final String API_URL = "https://www.mercadobitcoin.net/api";

	public <T> T execute(String method, String service, Class<T> clazz) throws IOException {

		try (InputStream inputStream = createConnection(method, service)) {
			String content = readContent(inputStream);
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new LongToDateAdapter()).create();
			return gson.fromJson(content, clazz);
		}
	}

	private InputStream createConnection(String method, String service) throws IOException {
		URL url = new URL(API_URL + service);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(method);
		return con.getInputStream();
	}

	private String readContent(InputStream inputStream) throws IOException {
		
		try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
			String inputLine;
			StringBuffer content = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}

			return content.toString();
		}
	}

}
