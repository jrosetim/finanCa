package br.com.financa.controller;

import br.com.financa.model.GenderModel;
import br.com.financa.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private GenderRepository genderRepository;

    @GetMapping
    public List<GenderModel> getAllGender(){
        return genderRepository.findAll();
    }
}
