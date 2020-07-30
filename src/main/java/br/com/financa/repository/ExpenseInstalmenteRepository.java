package br.com.financa.repository;

import br.com.financa.model.ExpenseInstalmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseInstalmenteRepository extends JpaRepository<ExpenseInstalmentModel, Long> {
}
