package br.com.financa.service;

import br.com.financa.model.ExpenseInstalmentModel;
import br.com.financa.model.ExpenseModel;
import br.com.financa.repository.ExpenseInstalmenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ExpenseInstalmentService {

    @Autowired
    private ExpenseInstalmenteRepository eiRepository;

    public void inserExpenseInstalment(ExpenseModel em, Integer instalment, Float value, Date dueDate){
        ExpenseInstalmentModel expenseInstalmentModel = new ExpenseInstalmentModel();
        expenseInstalmentModel.setExpense(em);
        expenseInstalmentModel.setInstalment(instalment);
        expenseInstalmentModel.setValue(value);
        expenseInstalmentModel.setDuedate(dueDate);

        eiRepository.save(expenseInstalmentModel);
    }

//    private void getDueDateByInstalment(Integer instalment){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.MONTH,instalment);
//         return   cal.getTime();
//    }
}