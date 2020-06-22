package br.com.financa.service;

import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.PersonModel;
import br.com.financa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonModel insertPerson( PersonModel personModel ){
        PersonModel pm = personRepository.save(personModel);

        return pm;
    }


    public void deletePerson(Long personid){
        PersonModel pm = personRepository.findById(personid)
                .orElseThrow( () -> new BusinessException("Person not found"));

        personRepository.deleteById(personid);
    }

}
