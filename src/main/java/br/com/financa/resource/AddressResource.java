package br.com.financa.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financa.model.AddressModel;
import br.com.financa.repository.AddressRepository;


import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressResource {

    @Autowired
    AddressRepository ar;

    @GetMapping
    public List<AddressModel> ListAllAddress(){
        return ar.findAll();
    }

    @PostMapping
    public ResponseEntity<AddressModel> SaveAddress(@RequestBody AddressModel addressModel){
        AddressModel am = ar.save(addressModel);

        return ResponseEntity.ok().body(am);
    }
}
