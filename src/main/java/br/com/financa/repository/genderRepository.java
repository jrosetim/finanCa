package br.com.financa.repository;

import br.com.financa.model.GenderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface genderRepository extends JpaRepository<GenderModel, Long> {

}
