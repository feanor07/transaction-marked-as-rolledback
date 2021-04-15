package com.alptugdilek.transactionmarkedasrolledback.controller;

import com.alptugdilek.transactionmarkedasrolledback.service.InitialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    private final InitialService initialService;

    public TransactionController(InitialService initialService) {
        this.initialService = initialService;
    }

    @GetMapping("/tofail-transactional")
    public String failingTransactionalServiceCall() {
        return initialService.returnAfterCallingTransactionalServiceExceptionThrowingMethod();
    }

    @GetMapping("/tosucceed-transactional")
    public String succeedingTransactionalServiceCall() {
        return initialService.returnAfterCallingTransactionalServiceExceptionCatchingMethod();
    }

    @GetMapping("/tosucceed-non-transactional")
    public String succeedingNonTransactionalServiceCall() {
        return initialService.returnAfterCallingNonTransactionalServiceExceptionThrowingMethod();
    }
}
