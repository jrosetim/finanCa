package br.com.financa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.financa.model.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Long>{

}
