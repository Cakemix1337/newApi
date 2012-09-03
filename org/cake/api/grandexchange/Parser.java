package org.cake.api.grandexchange;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Cake
 * Give some credits if used.
 * @version 47: 2.0.1 1
 */
public class Parser {

	/**
	 * Method parse.
	 * @param input String
	 * @return HashMap<String,Object>
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> parse(String input) {
		try {
			return (HashMap<String, Object>) new JSONParser().parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Method parse.
	 * @param input String
	 * @return JSONArray
	 */
	public static JSONArray parseArray(String input) {
		try {
			return (JSONArray) new JSONParser().parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Method fixData.
	 * @param hashMap HashMap<String,Object>
	 * @return HashMap<String,Object>
	 */
	public static HashMap<String, Object> fixData(HashMap<String, Object> hashMap) {
		for (Entry<String, Object> entry : hashMap.entrySet())
			if (entry.getKey().matches("(\\_(\\d+)\\_day\\_change|daily\\_pct\\_change)"))
				hashMap.put(entry.getKey(), Double.valueOf(String.valueOf(entry.getValue()).replaceAll("\\,", "")));
			else if (entry.getKey().matches("(mark\\_price|ge\\_id|id)"))
				hashMap.put(entry.getKey(), Integer.valueOf(String.valueOf(entry.getValue()).replaceAll("\\D", "")));

		return hashMap;
	}
}
