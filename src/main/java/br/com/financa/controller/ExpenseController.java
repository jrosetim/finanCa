package br.com.financa.controller;

import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.ExpenseModel;
import br.com.financa.model.GroupExpenseModel;
import br.com.financa.model.PaymentoMethodModel;
import br.com.financa.model.SituationExpenseModel;
import br.com.financa.model.TypeExpenseModel;
import br.com.financa.model.UsersModel;
import br.com.financa.repository.ExpenseRepository;
import br.com.financa.repository.GroupExpenseRepository;
import br.com.financa.repository.PaymentMethodRepository;
import br.com.financa.repository.SituationExpenseRepository;
import br.com.financa.repository.TypeExpenseRepository;
import br.com.financa.repository.UsersRepository;
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
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private TypeExpenseRepository typeExpenseRepository;

    @Autowired
    private GroupExpenseRepository groupExpenseRepository;

    @Autowired
    private SituationExpenseRepository situationExpenseRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public List<ExpenseModel> GetAllExpense(){
        return expenseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ExpenseModel> insertExpense(@Valid @RequestBody ExpenseModel expenseModel){
        PaymentoMethodModel pm = paymentMethodRepository.findById(expenseModel.getPaymentmethod().getId())
                .orElseThrow(() -> new BusinessException("Payment method not found"));

        TypeExpenseModel tm = typeExpenseRepository.findById(expenseModel.getTypeexpense().getId())
                .orElseThrow(()-> new BusinessException("Type expense not found"));

        GroupExpenseModel gm = groupExpenseRepository.findById(expenseModel.getGroupexpense().getId())
                .orElseThrow(()-> new BusinessException("Group expense not fount"));

        SituationExpenseModel sm = situationExpenseRepository.findById(expenseModel.getSituationexpense().getId())
                .orElseThrow(()-> new BusinessException("Situation expense not found"));

        UsersModel um = usersRepository.findById(expenseModel.getUser().getUserid())
                .orElseThrow( () -> new BusinessException("User not found"));

        expenseModel.setPaymentmethod(pm);
        expenseModel.setTypeexpense(tm);
        expenseModel.setGroupexpense(gm);
        expenseModel.setSituationexpense(sm);
        expenseModel.setUser(um);
        ExpenseModel em = expenseRepository.save(expenseModel);

        return ResponseEntity.ok(em);
    }

}
