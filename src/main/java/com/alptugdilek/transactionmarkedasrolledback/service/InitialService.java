package com.alptugdilek.transactionmarkedasrolledback.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InitialService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final DownStreamNonTransactionalService downStreamNonTransactionalService;
    private final DownStreamTransactionalService downStreamTransactionalService;

    public InitialService(DownStreamNonTransactionalService downStreamNonTransactionalService, DownStreamTransactionalService downStreamTransactionalService) {
        this.downStreamNonTransactionalService = downStreamNonTransactionalService;
        this.downStreamTransactionalService = downStreamTransactionalService;
    }

    public String returnAfterCallingTransactionalServiceExceptionThrowingMethod() {
        try {
            downStreamTransactionalService.throwException();
        } catch (Exception e) {
            logger.error("Caught exception from downStreamTransactionalService", e);
        }

        return "It works fine; but this string will not be returned";
    }

    public String returnAfterCallingTransactionalServiceExceptionCatchingMethod() {
        downStreamTransactionalService.throwAndCatchException();

        return "It works fine";
    }

    public String returnAfterCallingNonTransactionalServiceExceptionThrowingMethod() {
        try {
            downStreamNonTransactionalService.throwException();
        } catch (Exception e) {
            logger.error("Caught exception from downStreamNonTransactionalService", e);
        }

        return "It works fine";
    }
}
