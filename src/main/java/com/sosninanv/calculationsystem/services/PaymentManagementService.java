package com.sosninanv.calculationsystem.services;

import com.sosninanv.calculationsystem.dtos.requests.CreatePaymentRequest;

import javax.validation.constraints.NotNull;

/**
 * Упралвение платежами
 */
public interface PaymentManagementService {

    void createPayment(@NotNull(message = "null object") CreatePaymentRequest request);

}
