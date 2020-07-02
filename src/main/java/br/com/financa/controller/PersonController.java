package br.com.financa.controller;


import br.com.financa.model.PersonModel;
import br.com.financa.model.UsersModel;
import br.com.financa.repository.GenderRepository;
import br.com.financa.repository.PersonRepository;
import br.com.financa.repository.UsersRepository;
import br.com.financa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonModel> getAllPerson(){
        return personRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonModel> insertPerson(@Valid @RequestBody PersonModel personModel){
        PersonModel pm = personService.insertPerson(personModel);

        return ResponseEntity.ok(pm);
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<PersonModel> deletePersonById(@PathVariable Long personId){
        personService.deletePerson(personId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<PersonModel> getPersonByUserId(@PathVariable Long userId){
        Optional<UsersModel> um = usersRepository.findById(userId);

        if (um.isPresent()) {
            PersonModel pm = personRepository.findByUser(um);
            return ResponseEntity.ok(pm);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonModel> updatePerson(@PathVariable Long personId, @RequestBody PersonModel personModel ){
        if (!personRepository.existsById(personId)){
            return ResponseEntity.notFound().build();
        }

        personModel.setPersonid(personId);
        personRepository.save(personModel);

        return ResponseEntity.ok(personModel);
    }

}
