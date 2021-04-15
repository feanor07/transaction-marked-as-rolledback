package com.alptugdilek.transactionmarkedasrolledback.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DownStreamTransactionalService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void throwException() {
        throw new RuntimeException("It fails in Transactional Service");
    }

    public void throwAndCatchException() {
        try {
            throwException();
        } catch (Exception e) {
            logger.error("Catching my own exception; in order not to mark transaction as rolled back", e);
        }
    }
}
