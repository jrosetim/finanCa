package br.com.financa.service;

import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.UsersModel;
import br.com.financa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Boolean findByEmail(String userEmail){
//        List<UsersModel> um = usersRepository.findByUserEmail(userEmail);
//
//        if (! um.isEmpty()){
//            return true;
//        }
        return false;
    }

    public ResponseEntity<UsersModel> insertUser(UsersModel usersModel){
        UsersModel usersModel1 = usersRepository.findByUseremail(usersModel.getUseremail());

        if (usersModel1 != null && !usersModel1.equals(usersModel)){
            throw new BusinessException("E-mail já cadastrado no sistema");
        }

        usersModel1 = usersRepository.save(usersModel);

        return ResponseEntity.ok(usersModel1);
    }

    public void deleteUser(Long userId){
//        if(!usersRepository.existsById(userId)){
//            return ResponseEntity.notFound().build();
//        }

        usersRepository.deleteById(userId);
    }
}
