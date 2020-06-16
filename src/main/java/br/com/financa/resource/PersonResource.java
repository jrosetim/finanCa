package br.com.financa.resource;

import br.com.financa.model.AddressModel;
import br.com.financa.model.PersonModel;
import br.com.financa.repository.AddressRepository;
import br.com.financa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonResource {

    @Autowired
    PersonRepository pr;

    @Autowired
    AddressRepository ar;

    @GetMapping
    public List<PersonModel> ListAllPerson(){
        return pr.findAll();
    }

    @GetMapping("/person/{personId}")
    public ModelAndView GetPersonById(@PathVariable("personId") Long personId){
        Optional<PersonModel> person = pr.findById(personId);

        ModelAndView mv = new ModelAndView("person/personbyid");
        mv.addObject("personObj", person.get());

        return mv;
    }

    @PostMapping
    public ResponseEntity<PersonModel> SavePerson(@RequestBody PersonModel personModel, AddressModel address){
        PersonModel pm = pr.save(personModel);

        address.setPersonModel(personModel);
        ar.save(address);

        return ResponseEntity.ok().body(pm);
    }
}


