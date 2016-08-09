package com.kientran.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.kientran.entities.Feedback;
import com.kientran.entities.User;
import com.kientran.entities.enums.FeedbackRate;
import com.kientran.entities.enums.FeedbackType;
import com.kientran.services.FeedbackService;
import com.opensymphony.xwork2.ActionSupport;

public class FeedbackAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> feedbackTypeList;
	private String feedbackType;
	private List<String> feedbackRateList;
	private String feedbackRate;
	private String feedbackNote;
	private List<Feedback> feedbacks;
	private Feedback feedback;
	private User user;
	private FeedbackService feedbackService = new FeedbackService();
	private Map<String, Object> session;

	public FeedbackAction() {
		feedbackTypeList = FeedbackType.getFeedbackTypeList();
		feedbackRateList = FeedbackRate.getFeedbackRateList();
	}

	@Override
	public String execute() throws Exception {
		user = (User) session.get("user");
		if (user != null && user.validate()) {
			if (feedbackTypeList.contains(feedbackType) && feedbackRateList.contains(feedbackRate)) {
				feedback = new Feedback();
				feedback.setFeedbackType(FeedbackType.getFeedbackType(feedbackType));
				feedback.setFeedbackRate(FeedbackRate.getFeedbackRate(feedbackRate));
				feedback.setNotes(feedbackNote);
				feedback.setUser(user);
				user.getFeedbacks().add(feedback);
				feedbackService.save(feedback);

				session.put("user", user);
			}
			feedbacks = feedbackService.getFeedbacks(user.getAccount());
		}
		return SUCCESS;
	}

	public String getDefaultFeedbackRateValue() {
		return "Neutral";
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public String getFeedbackNote() {
		return feedbackNote;
	}

	public void setFeedbackNote(String feedbackNote) {
		this.feedbackNote = feedbackNote;
	}

	public List<String> getFeedbackTypeList() {
		return feedbackTypeList;
	}

	public void setFeedbackTypeList(List<String> feedbackTypeList) {
		this.feedbackTypeList = feedbackTypeList;
	}

	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	public List<String> getFeedbackRateList() {
		return feedbackRateList;
	}

	public void setFeedbackRateList(List<String> feedbackRateList) {
		this.feedbackRateList = feedbackRateList;
	}

	public String getFeedbackRate() {
		return feedbackRate;
	}

	public void setFeedbackRate(String feedbackRate) {
		this.feedbackRate = feedbackRate;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
