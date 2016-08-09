package com.kientran.entities.converters;

import javax.persistence.AttributeConverter;

import com.kientran.entities.enums.FeedbackRate;

public class FeedbackRateConverter implements AttributeConverter<FeedbackRate, String> {

	@Override
	public String convertToDatabaseColumn(FeedbackRate feedbackRate) {
		switch (feedbackRate) {
		case Rate_1:
		case Rate_2:
		case Rate_3:
		case Rate_4:
		case Rate_5:
			return feedbackRate.toString();

		default:
			throw new IllegalArgumentException("Invalid value " + feedbackRate);
		}
	}

	@Override
	public FeedbackRate convertToEntityAttribute(String string) {
		switch (string) {
		case "Strongly disagree":
			return FeedbackRate.Rate_1;
		case "Disagree":
			return FeedbackRate.Rate_2;
		case "Neutral":
			return FeedbackRate.Rate_3;
		case "Agree":
			return FeedbackRate.Rate_4;
		case "Strongly agree":
			return FeedbackRate.Rate_5;
		}
		return null;
	}

}
