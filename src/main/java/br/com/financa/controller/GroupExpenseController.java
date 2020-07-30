package br.com.financa.controller;

import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.GroupExpenseModel;
import br.com.financa.repository.GroupExpenseRepository;
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
import java.util.Optional;

@RestController
@RequestMapping("/groupexpense")
public class GroupExpenseController {

    @Autowired
    private GroupExpenseRepository groupExpenseRepository;

    @GetMapping
    public List<GroupExpenseModel> getAll() {
        return groupExpenseRepository.findAll();
    }

    @GetMapping("/{id}")
    public GroupExpenseModel getGroupExpenseById(@PathVariable Long id) {
        //Optional<GroupExpenseModel> gem = groupExpenseRepository.findById(id);
        GroupExpenseModel gem = groupExpenseRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Group not found"));

        return gem;
//        if (gem.isPresent()) {
//            return gem;
//        } else {
//            return null;
//        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GroupExpenseModel> insertGroupExpense(@RequestBody GroupExpenseModel groupExpenseModel){
        GroupExpenseModel gem = groupExpenseRepository.save(groupExpenseModel);

        return ResponseEntity.ok(gem);
    }
}
