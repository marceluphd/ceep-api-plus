package br.com.alura.ceepapi.service;

import br.com.alura.ceepapi.model.Feedback;
import br.com.alura.ceepapi.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback salva(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

}
