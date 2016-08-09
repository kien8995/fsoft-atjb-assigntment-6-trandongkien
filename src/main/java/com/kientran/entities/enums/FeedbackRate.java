package com.kientran.entities.enums;

import java.util.ArrayList;
import java.util.List;

public enum FeedbackRate {
	Rate_1("Strongly disagree"), Rate_2("Disagree"), Rate_3("Neutral"), Rate_4("Agree"), Rate_5("Strongly agree");

	private final String rate;

	private FeedbackRate(String rate) {
		this.rate = rate;
	}

	public static List<String> getFeedbackRateList() {
		List<String> rates = new ArrayList<>();
		rates.add(Rate_1.toString());
		rates.add(Rate_2.toString());
		rates.add(Rate_3.toString());
		rates.add(Rate_4.toString());
		rates.add(Rate_5.toString());
		return rates;
	}

	public static FeedbackRate getFeedbackRate(String rate) {
		FeedbackRate[] rates = FeedbackRate.values();
		for (int i = 0; i < rates.length; i++) {
			if (rates[i].toString().equals(rate)) {
				return rates[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return rate;
	}
}
