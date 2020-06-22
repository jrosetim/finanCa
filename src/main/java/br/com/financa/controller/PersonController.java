package br.com.financa.controller;


import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.GenderModel;
import br.com.financa.model.PersonModel;
import br.com.financa.model.UsersModel;
import br.com.financa.repository.GenderRepository;
import br.com.financa.repository.PersonRepository;
import br.com.financa.repository.UsersRepository;
import br.com.financa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        UsersModel usersModel = usersRepository.findById(personModel.getUser().getUserid())
                .orElseThrow( () -> new BusinessException("User not found"));

        GenderModel genderModel = genderRepository.findById((personModel.getGender().getGenderid()))
                .orElseThrow( () -> new BusinessException("Gender not found"));

        personModel.setUser(usersModel);
        personModel.setGender(genderModel);
        PersonModel pm = personService.insertPerson(personModel);

        return ResponseEntity.ok(pm);
    }

    @PutMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<PersonModel> deletePersonById(@PathVariable Long personId){
        personService.deletePerson(personId);

        return ResponseEntity.noContent().build();
    }
}
