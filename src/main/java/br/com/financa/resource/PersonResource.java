package br.com.financa.resource;

import br.com.financa.model.PersonModel;
import br.com.financa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    PersonRepository pr;

    @GetMapping
    public List<PersonModel> ListAllPerson(){
        return pr.findAll();
    }

    @PostMapping
    public ResponseEntity<PersonModel> SavePerson(@RequestBody PersonModel personModel){
        PersonModel pm = pr.save(personModel);

        return ResponseEntity.ok().body(pm);
    }
}


