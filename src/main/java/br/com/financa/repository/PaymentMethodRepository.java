package br.com.financa.repository;

import br.com.financa.model.PaymentoMethodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentoMethodModel, Long> {
}
