package org.cake.api.grandexchange.until;

/**
 * @author Cake
 * Give some credits if used.
 * @version 47: 2.0.1 1
 */
public class SearchResult {
	private int id;
	private String name;

	public SearchResult(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("SearchResult [getId()=%s, getName()=%s]", getId(), getName());
	}

}
