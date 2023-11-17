package com.spring.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.quiz.model.Question;
import com.spring.quiz.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService QuestionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return QuestionService.getAllQuestios();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return QuestionService.getQuestionByCategory(category);
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return QuestionService.addQuestion(question);
	}
	
	@DeleteMapping("deleteQuestion")
	public String deleteQuestion(@RequestBody Question question) {
		return QuestionService.deleteQuestion(question);
	}
	
	@PutMapping("updateQuestion")
	public String updateQuestion(@RequestBody Question question) {
		return QuestionService.updateQuestion(question);
		
	}
	
	
}
