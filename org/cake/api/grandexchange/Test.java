package org.cake.api.grandexchange;

import java.util.ArrayList;

import org.cake.api.grandexchange.until.SearchResult;
import org.cake.api.grandexchange.until.SingleItem;

/**
 */
public class Test {

	/**
	 * Method main.
	 * @param args String[]
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//Search item
		ArrayList<SearchResult> searchItem = GrandExchange.searchItem("(4)");
		
		if (searchItem != null)
			for (SearchResult sr : searchItem)
				System.out.println(sr);
		
		//Single item
		SingleItem item = GrandExchange.getItem(11694);
		
		if(item != null)
			System.out.println(item);
	}
}
