package br.com.alura.ceepapi.api.controller;

import br.com.alura.ceepapi.model.Erro;
import br.com.alura.ceepapi.model.Feedback;
import br.com.alura.ceepapi.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("feedback")
public class FeedbackController {

    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity salva(@Valid @RequestBody Feedback feedback,
                                BindingResult bindingResult) {

        System.out.println(feedback.getEmail());
        System.out.println(feedback.getConteudo());
        if (bindingResult.hasErrors()) {
            Erro representation = new Erro(bindingResult.getAllErrors());
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(representation);
        }
        Feedback feedbackSalvado = feedbackService.salva(feedback);
        return ResponseEntity.ok(feedbackSalvado);
    }
}
