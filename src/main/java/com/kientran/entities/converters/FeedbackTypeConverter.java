package com.kientran.entities.converters;

import javax.persistence.AttributeConverter;

import com.kientran.entities.enums.FeedbackType;

public class FeedbackTypeConverter implements AttributeConverter<FeedbackType, String> {

	@Override
	public String convertToDatabaseColumn(FeedbackType feedbackType) {
		switch (feedbackType) {
		case Type_A:
		case Type_B:
		case Type_C:
		case Type_D:
		case Type_E:
		case Type_F:
		case Type_G:
		case Type_H:
			return feedbackType.toString();

		default:
			throw new IllegalArgumentException("Invalid value " + feedbackType);
		}
	}

	@Override
	public FeedbackType convertToEntityAttribute(String string) {
		switch (string) {
		case "The course objectives were met":
			return FeedbackType.Type_A;

		case "The level of the course is appropriate":
			return FeedbackType.Type_B;

		case "This course will be useful for my work":
			return FeedbackType.Type_C;

		case "The training materials were good":
			return FeedbackType.Type_D;

		case "The organization of the course (facility) was good":
			return FeedbackType.Type_E;

		case "Subject coverage is good with respect to courseware":
			return FeedbackType.Type_F;

		case "Your questions/doubts were answered satisfactorily and teacher support is good":
			return FeedbackType.Type_G;

		case "The quality of trainer instruction and communication was good":
			return FeedbackType.Type_H;
		}
		return null;
	}

}
