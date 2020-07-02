package br.com.financa.repository;

import br.com.financa.model.GroupExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupExpenseRepository extends JpaRepository<GroupExpenseModel, Long> {
}
