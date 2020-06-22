package br.com.financa.repository;

import br.com.financa.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {

     UsersModel findByUserEmail(String userEmail);
//    UsersModel findByUserEmailContaining(String userMail);
}
