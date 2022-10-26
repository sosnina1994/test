package com.sosninanv.calculationsystem.controllers;

import com.sosninanv.calculationsystem.dtos.requests.CreatePaymentRequest;
import com.sosninanv.calculationsystem.services.PaymentManagementService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Контроллер для управления платежами
 */
@Validated
@RestController
@AllArgsConstructor
public class PaymentManagementController {

    private PaymentManagementService paymentManagementService;

    @Operation(description = "Создание платежа")
    @PostMapping("/payments")
    public void createDeposit(
            @Valid
            @RequestBody CreatePaymentRequest createPaymentRequest) {

        paymentManagementService.createPayment(createPaymentRequest);
    }
}
