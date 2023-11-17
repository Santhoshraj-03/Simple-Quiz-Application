package com.spring.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.quiz.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
	List<Question> findByCategory(String category);

	@Query(nativeQuery = true,value = "SELECT * FROM question q WHERE q.category= :category ORDER BY RAND() LIMIT :noQues")
	List<Question> findRandomQuestionByCategory(String category, int noQues);
}
