package com.spring.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.quiz.dao.QuestionDao;
import com.spring.quiz.dao.QuizDao;
import com.spring.quiz.model.Question;
import com.spring.quiz.model.QuestionWrapper;
import com.spring.quiz.model.Quiz;
import com.spring.quiz.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int noQues, String title) {
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		
		List<Question> questions = questionDao.findRandomQuestionByCategory(category,noQues);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> quesDB = quiz.get().getQuestions();
		List<QuestionWrapper> quesWrapper = new ArrayList<>();
		for(Question i : quesDB) {
			quesWrapper.
				add(new QuestionWrapper(i.getId(),
										i.getOption1(),
										i.getOption2(),
										i.getOption3(),
										i.getQuestionTitle()));
		}
		return new ResponseEntity<>(quesWrapper,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		Integer score = 0;
		int i = 0;
		for(Response r : responses) {
			if(r.getResponse().equals(questions.get(i).getRightAnswer())) {
				score++;
			}
			i++;
		}
		return new ResponseEntity<>(score,HttpStatus.ACCEPTED);
	}
}
