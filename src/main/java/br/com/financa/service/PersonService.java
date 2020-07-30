package br.com.financa.service;

import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.GenderModel;
import br.com.financa.model.PersonModel;
import br.com.financa.model.UsersModel;
import br.com.financa.repository.GenderRepository;
import br.com.financa.repository.PersonRepository;
import br.com.financa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GenderRepository genderRepository;

    public PersonModel insertPerson( PersonModel personModel ){
        GenderModel genderModel = genderRepository.findById((personModel.getGender().getGenderid()))
                .orElseThrow( () -> new BusinessException("Gender not found"));

        personModel.setGender(genderModel);
        personModel.setPersonstate("A");

        PersonModel pm = personRepository.save(personModel);

        return pm;
    }

    public void deletePerson(Long personid){
        PersonModel pm = personRepository.findById(personid)
                .orElseThrow( () -> new BusinessException("Person not found"));

        personRepository.deleteById(personid);
    }

}
