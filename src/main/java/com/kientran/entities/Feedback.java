package com.kientran.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;

import com.kientran.entities.converters.FeedbackRateConverter;
import com.kientran.entities.converters.FeedbackTypeConverter;
import com.kientran.entities.enums.FeedbackRate;
import com.kientran.entities.enums.FeedbackType;

@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Feedback() {
		super();
	}

	public Feedback(FeedbackType feedbackType, FeedbackRate feedbackRate, String notes) {
		this.feedbackType = feedbackType;
		this.feedbackRate = feedbackRate;
		this.notes = notes;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id", nullable = false)
	private Long id;

	@Column(name = "feedback_type")
	// @Enumerated(EnumType.STRING)
	@Convert(converter = FeedbackTypeConverter.class)
	@NotNull
	private FeedbackType feedbackType;

	@Column(name = "feedback_rate")
	// @Enumerated(EnumType.STRING)
	@Convert(converter = FeedbackRateConverter.class)
	@NotNull
	private FeedbackRate feedbackRate;

	@Column(name = "notes")
	private String notes;

	@ManyToOne
	@JoinColumn(name = "user_account", referencedColumnName = "user_account")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FeedbackType getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(FeedbackType feedbackType) {
		this.feedbackType = feedbackType;
	}

	public FeedbackRate getFeedbackRate() {
		return feedbackRate;
	}

	public void setFeedbackRate(FeedbackRate feedbackRate) {
		this.feedbackRate = feedbackRate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean validate() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Feedback>> constraintViolations = validator.validate(this);
		return constraintViolations.size() == 0;
	}
}
