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
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @RequestMapping
    public List<UsersModel> GetAllUsers(){
        return usersRepository.findAll();
    }

    @RequestMapping("/{userEmail}")
    public ResponseEntity<UsersModel> GetUsersByEmail(@PathVariable String userEmail){
        UsersModel um =  usersRepository.findByUseremail(userEmail);

        try {
            return ResponseEntity.ok(um);
        }catch (Exception error){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsersModel> InsertUsers(@Valid @RequestBody UsersModel usersModel){
        usersModel.setUserstatus("A");
        usersModel.setUsertype("U");
        usersModel.setDatecreation(OffsetDateTime.now());

        return usersService.insertUser(usersModel);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UsersModel> DeleteUsers(@PathVariable Long userId){
        usersService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UsersModel> UpdateUsers(@Valid @PathVariable Long userId, @RequestBody UsersModel usersModel){

        if(!usersRepository.existsById(userId)){
            return ResponseEntity.notFound().build();
        }

        usersModel.setUserid(userId);
        usersService.insertUser(usersModel);

        return ResponseEntity.ok(usersModel);
    }
}
