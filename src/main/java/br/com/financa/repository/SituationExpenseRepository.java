package br.com.financa.repository;

import br.com.financa.model.SituationExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituationExpenseRepository extends JpaRepository<SituationExpenseModel, Long> {

}
