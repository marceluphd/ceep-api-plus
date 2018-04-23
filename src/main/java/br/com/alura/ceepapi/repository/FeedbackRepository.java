package br.com.alura.ceepapi.repository;

import br.com.alura.ceepapi.model.Feedback;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, String> {
}
