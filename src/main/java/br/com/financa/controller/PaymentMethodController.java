package br.com.financa.controller;


import br.com.financa.exceptionhandler.BusinessException;
import br.com.financa.model.PaymentMethodModel;
import br.com.financa.repository.PaymentMethodRepository;
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
@RequestMapping("/paymentmethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @GetMapping
    public List<PaymentMethodModel> getAll(){
        return paymentMethodRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodModel> getPaymentMethodById(@PathVariable Long id){
        PaymentMethodModel pm = paymentMethodRepository.findById(id)
                .orElseThrow(()-> new BusinessException("Payment method not found"));

        return ResponseEntity.ok(pm);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PaymentMethodModel> insertPaymentMethod(@RequestBody PaymentMethodModel paymentMethodModel){
        PaymentMethodModel pm = paymentMethodRepository.save(paymentMethodModel);

        return ResponseEntity.ok(pm);
    }
}
