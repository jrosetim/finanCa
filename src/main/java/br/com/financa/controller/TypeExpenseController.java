package br.com.financa.controller;

import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.TypeExpenseModel;
import br.com.financa.repository.TypeExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/typeexpense")
public class TypeExpenseController {

    @Autowired
    private TypeExpenseRepository typeExpenseRepository;

    @GetMapping
    public List<TypeExpenseModel> getAll(){
        return typeExpenseRepository.findAll();
    }

    @GetMapping("/{id}")
    public TypeExpenseModel getTypeById(@PathVariable Long id){
        TypeExpenseModel te = typeExpenseRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Type expense not found"));

        return te;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity insertTypeExpense(@RequestBody TypeExpenseModel typeExpenseModel){
        TypeExpenseModel tem = typeExpenseRepository.save(typeExpenseModel);

        return ResponseEntity.ok(tem);
    }
}
