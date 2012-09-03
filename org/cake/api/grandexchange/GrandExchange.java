package org.cake.api.grandexchange;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.cake.api.grandexchange.until.SearchResult;
import org.cake.api.grandexchange.until.SingleItem;
import org.json.simple.JSONArray;

/**
 * @author Cake Give some credits if used.
 * @version 47: 2.0.1 1
 */
public class GrandExchange implements Untils.Urls {

	/**
	 * Method getItem.
	 * 
	 * @param id int
	 * @return SingleItem
	 */
	public static SingleItem getItem(int id) {
		String input = null;

		try {
			input = Untils.readPage(new URL(SINGLE_ITEM + id));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HashMap<String, Object> parse = Parser.parse(input);

		if (parse.get("name") == null)
			return null;

		parse = Parser.fixData(parse);

		String name = parse.get("name").toString().trim();
		int parse_id = (int) parse.get("ge_id");
		int parse_marketPrice = (int) parse.get("mark_price");
		double parse_dailyChange = (double) parse.get("daily_pct_change");
		double parse_monthlyChange = (double) parse.get("_30_day_change");
		double parse_halfHalfYearlyChange = (double) parse.get("_90_day_change");
		double parse_halfYearlyChange = (double) parse.get("_180_day_change");

		return new SingleItem(name, parse_id, parse_marketPrice, parse_dailyChange, parse_monthlyChange, parse_halfHalfYearlyChange, parse_halfYearlyChange);
	}

	/**
	 * Method searchItem.
	 * 
	 * @param name String
	 * @return ArrayList<SearchResult>
	 */
	public static ArrayList<SearchResult> searchItem(String name) {
		ArrayList<SearchResult> output = new ArrayList<>();

		String input = null;
		int id = -1;
		String label = null;

		try {
			input = Untils.readPage(new URL(SEARCH_ITEM + URLEncoder.encode(name, "UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONArray array = Parser.parseArray(input);

		if (array == null)
			return null;
		
		for (Object entry : array) {
			HashMap<String, Object> parse = Parser.fixData(Parser.parse(entry.toString()));
			for (Entry<String, Object> object : parse.entrySet()) {
				if (object.getKey().toString().equals("id"))
					id = (int) object.getValue();
				else if (object.getKey().toString().equals("label"))
					label = (String) object.getValue();
			}
			output.add(new SearchResult(id, label));
		}

		return output.size() <= 0 ? null : output;
	}
}
