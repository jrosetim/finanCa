package br.com.financa.controller;

import br.com.financa.model.ExpenseModel;
import br.com.financa.repository.ExpenseRepository;
import br.com.financa.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<ExpenseModel> GetAllExpense(){
        return expenseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExpenseModel> insertExpense(@Valid @RequestBody ExpenseModel expenseModel){
        ExpenseModel em = expenseService.insertExpense(expenseModel);

        return ResponseEntity.ok(em);
    }

}
