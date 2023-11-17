package com.spring.quiz.model;

import lombok.Data;

@Data
public class QuestionWrapper {

	private Integer id;
	private String option1;
	private String option2;
	private String option3;
	private String questionTitle;
	
	public QuestionWrapper(Integer id, String option1, String option2, String option3, String questionTitle) {
		super();
		this.id = id;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.questionTitle = questionTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	
	
	
}
