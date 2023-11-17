package com.spring.quiz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.quiz.dao.QuestionDao;
import com.spring.quiz.model.Question;


@Service
public class QuestionService {
	
	@Autowired
	QuestionDao QuestionDao;

	public ResponseEntity<List<Question>> getAllQuestios() {
		try {
			return new ResponseEntity<>(QuestionDao.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity<>(QuestionDao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		try {
			return new ResponseEntity<>(QuestionDao.save(question),HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public String deleteQuestion(Question question) {
		QuestionDao.delete(question);
		return "Question deleted";
	}

	public String updateQuestion(Question question) {
		QuestionDao.save(question);
		return "Question updated";
	}

}
