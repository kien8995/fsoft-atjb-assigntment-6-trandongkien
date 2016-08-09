package com.kientran.services;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.kientran.entities.Feedback;
import com.kientran.repositories.FeedbackRepository;
import com.kientran.services.interfaces.Service;

public class FeedbackService implements Service<Feedback, Long> {

	private FeedbackRepository feedbackRepository;

	public FeedbackService() {
		feedbackRepository = new FeedbackRepository();
	}

	@Override
	public Feedback save(Feedback feedback) {
		feedbackRepository.persist(feedback);
		return feedback;
	}

	public List<Feedback> getFeedbacks(String userId) {
		List<Feedback> feedbacks = feedbackRepository.findByCriteria(Restrictions.eq("user.id", userId));
		return feedbacks;
	}

	@Override
	public List<Feedback> getAll() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback update(Feedback feedback) {
		feedbackRepository.merge(feedback);
		return feedback;
	}
}
