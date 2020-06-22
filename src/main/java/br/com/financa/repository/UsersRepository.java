package br.com.financa.repository;

import br.com.financa.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {

     UsersModel findByUseremail(String userEmail);
//    UsersModel findByUserEmailContaining(String userMail);
}
