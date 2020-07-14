package br.com.financa.repository;

import br.com.financa.model.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {
}
