package br.com.financa.service;

import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.ExpenseModel;
import br.com.financa.model.GroupExpenseModel;
import br.com.financa.model.PaymentMethodModel;
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
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

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

    @Autowired
    private ExpenseInstalmentService expenseInstalmentService;

    private Integer instalment;

    public ExpenseModel insertExpense(ExpenseModel expenseModel){
        PaymentMethodModel pm = paymentMethodRepository.findById(expenseModel.getPaymentmethod().getId())
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

        expenseInstalmentService.inserExpenseInstalment(em, em.getInstalment(), em.getValue(), em.getDateexpense());
        return em;
    }
}
