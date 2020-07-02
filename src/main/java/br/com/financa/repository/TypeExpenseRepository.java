package br.com.financa.repository;

import br.com.financa.model.TypeExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeExpenseRepository extends JpaRepository<TypeExpenseModel, Long> {
}
