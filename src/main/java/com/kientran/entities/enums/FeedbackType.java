package com.kientran.entities.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author trand
 *
 */
public enum FeedbackType {
	Type_A("The course objectives were met"), Type_B("The level of the course is appropriate"), Type_C(
			"This course will be useful for my work"), Type_D("The training materials were good"), Type_E(
					"The organization of the course (facility) was good"), Type_F(
							"Subject coverage is good with respect to courseware"), Type_G(
									"Your questions/doubts were answered satisfactorily and teacher support is good"), Type_H(
											"The quality of trainer instruction and communication was good");

	private final String feedback;

	private FeedbackType(String feedback) {
		this.feedback = feedback;
	}

	public static List<String> getFeedbackTypeList() {
		List<String> feedbacks = new ArrayList<>();
		feedbacks.add(Type_A.toString());
		feedbacks.add(Type_B.toString());
		feedbacks.add(Type_C.toString());
		feedbacks.add(Type_D.toString());
		feedbacks.add(Type_E.toString());
		feedbacks.add(Type_F.toString());
		feedbacks.add(Type_G.toString());
		feedbacks.add(Type_H.toString());
		return feedbacks;
	}

	public static FeedbackType getFeedbackType(String type) {
		FeedbackType[] types = FeedbackType.values();
		for (int i = 0; i < types.length; i++) {
			if (types[i].toString().equals(type)) {
				return types[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return feedback;
	}
}
