package com.sosninanv.calculationsystem.entities;

import lombok.Data;

/**
 * Класс для описания сущности счета из БД
 */
@Data
public class AccountEntity {
    private String accountNumber;
    private String userName;
    private Float amount;
    private boolean isBlock;
}
