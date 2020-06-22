package br.com.financa.controller;

import br.com.financa.model.UsersModel;
import br.com.financa.repository.UsersRepository;
import br.com.financa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    private Boolean emailExists;

    @RequestMapping
    public List<UsersModel> GetAllUsers(){
        return usersRepository.findAll();
    }

    @RequestMapping("/{userId}")
    public ResponseEntity<UsersModel> GetUsersById(@PathVariable Long userId){
        Optional<UsersModel> um =  usersRepository.findById(userId);

        if (um.isPresent()){
            return ResponseEntity.ok(um.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsersModel> InsertUsers(@Valid @RequestBody UsersModel usersModel){
//        UsersService us = new UsersService();
//
//        emailExists = us.findByEmail(usersModel.getUserEmail());
//
//        if (emailExists){
//            return null;//ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//
//        UsersModel um = usersRepository.save(usersModel);
//
//        return ResponseEntity.ok(um);

       return usersService.insertUser(usersModel);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UsersModel> DeleteUsers(@PathVariable Long userId){
//        if(!usersRepository.existsById(userId)){
//            return ResponseEntity.notFound().build();
//        }
//
//        usersRepository.deleteById(userId);
//
//        return ResponseEntity.noContent().build();

        usersService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UsersModel> UpdateUsers(@Valid @PathVariable Long userId, @RequestBody UsersModel usersModel){

        if(!usersRepository.existsById(userId)){
            return ResponseEntity.notFound().build();
        }

        usersModel.setUserId(userId);
        //usersModel = usersRepository.save(usersModel);
        usersService.insertUser(usersModel);

        return ResponseEntity.ok(usersModel);
    }
}
