package org.cake.api.grandexchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Cake
 * Give some credits if used.
 * @version 47: 2.0.1 1
 */
public class Untils {
	/**
	 * Method readPage.
	 * 
	 * @param url URL
	 * @return String
	 */
	public static String readPage(URL url) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = in.readLine();
			in.close();
			return line;
		} catch (IOException e) {
			return null;
		}
	}

	public interface Urls {
		String TIP_IT = "http://open.tip.it/json/";
		String SINGLE_ITEM = TIP_IT + "ge_single_item?item=";
		String SEARCH_ITEM = TIP_IT + "ge-search?term=";
	}
}
