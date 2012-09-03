package org.cake.api.grandexchange.until;

/**
 * @author Cake
 * Give some credits if used.
 * @version 47: 2.0.1 1
 */
public class SingleItem {
	private String name;
	private int id;
	private int marketPrice;
	private double dailyChange;
	private double monthlyChange;
	private double halfHalfYearlyChange;
	private double halfYearlyChange;

	public SingleItem(String name, int id, int markPrice,
			double dailyChange, double monthlyChange,
			double halfYearlyChange, double halfhalfYearlyChange) {
		this.name = name;
		this.id = id;
		this.marketPrice = markPrice;
		this.dailyChange = dailyChange;
		this.monthlyChange = monthlyChange;
		this.halfYearlyChange = halfYearlyChange;
		this.halfHalfYearlyChange = halfhalfYearlyChange;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getMarketPrice() {
		return marketPrice;
	}

	public double getDailyChange() {
		return dailyChange;
	}

	public double getMonthlyChange() {
		return monthlyChange;
	}

	public double getHalfHalfYearlyChange() {
		return halfHalfYearlyChange;
	}

	public double getHalfYearlyChange() {
		return halfYearlyChange;
	}

	@Override
	public String toString() {
		return String
				.format("getName()=%s, getId()=%s, getMarketPrice()=%s, getDailyChange()=%s, getMonthlyChange()=%s, getHalfHalfYearlyChange()=%s, getHalfYearlyChange()=%s",
						getName(), getId(), getMarketPrice(),
						getDailyChange(), getMonthlyChange(),
						getHalfHalfYearlyChange(), getHalfYearlyChange());
	}
}