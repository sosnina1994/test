package com.sosninanv.calculationsystem.services.impl;

import com.sosninanv.calculationsystem.dtos.requests.CreatePaymentRequest;
import com.sosninanv.calculationsystem.entities.AccountEntity;
import com.sosninanv.calculationsystem.repositories.AccountRepository;
import com.sosninanv.calculationsystem.services.PaymentManagementService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentManagementServiceImpl implements PaymentManagementService {

    private AccountRepository accountRepository;

    @Override
    public void createPayment(CreatePaymentRequest createPaymentRequest) {

        AccountEntity accountEntity = accountRepository
                .findById(createPaymentRequest.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("not found account"));

        if (!checkUserName(accountEntity, accountEntity.getUserName()) ||
                !checkAvailabilityAmount(accountEntity, createPaymentRequest.getSum())) {
            throw new RuntimeException("refusal");
        }


        //do something for update data

    }

    private boolean checkUserName(AccountEntity accountEntity, String userName) {
        Validate.notNull(accountEntity, "no account");
        Validate.notBlank(userName, "no user name");

        return accountEntity.getUserName().equalsIgnoreCase(userName);
    }

    private boolean checkAvailabilityAmount(AccountEntity accountEntity, Float sum) {
        Validate.notNull(accountEntity, "no account");
        Validate.notNull(sum, "no sum");

        return !accountEntity.isBlock() && (sum <= accountEntity.getAmount());
    }
}
