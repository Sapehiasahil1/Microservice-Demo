package com.sapehia.quiz_service.service;

import com.sapehia.quiz_service.feign.QuizInterface;
import com.sapehia.quiz_service.model.QuestionWrapper;
import com.sapehia.quiz_service.model.Quiz;
import com.sapehia.quiz_service.model.Response;
import com.sapehia.quiz_service.repository.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizInterface quizInterface;

    public QuizService(QuizRepository quizRepository, QuizInterface quizInterface) {
        this.quizInterface = quizInterface;
        this.quizRepository = quizRepository;
    }

    public ResponseEntity<String> createQuiz(String category, int questionCount, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, questionCount).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);

        quizRepository.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int quizId) {
        Quiz quiz = quizRepository.findById(quizId).get();
        List<Integer> questionIds = quiz.getQuestionIds();

        return quizInterface.getQuestionsFromId(questionIds);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        return quizInterface.getScore(responses);
    }
}
