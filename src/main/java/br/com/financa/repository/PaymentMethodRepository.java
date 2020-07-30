package br.com.financa.repository;

import br.com.financa.model.PaymentMethodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodModel, Long> {
}
