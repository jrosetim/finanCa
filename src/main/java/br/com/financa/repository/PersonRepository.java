package br.com.financa.repository;

import br.com.financa.model.PersonModel;
import br.com.financa.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
    //List<PersonModel> findByUser(Optional<UsersModel> user);
//    PersonModel findByUser(Optional<UsersModel> user);
    PersonModel findByEmail(String email);
}
