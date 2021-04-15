package com.alptugdilek.transactionmarkedasrolledback.service;

import org.springframework.stereotype.Service;

@Service
public class DownStreamNonTransactionalService {
    public void throwException() {
        throw new RuntimeException("It fails in non-transactional service");
    }
}
