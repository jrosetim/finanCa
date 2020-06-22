package br.com.financa.repository;

import br.com.financa.model.GenderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<GenderModel, Long> {

}
