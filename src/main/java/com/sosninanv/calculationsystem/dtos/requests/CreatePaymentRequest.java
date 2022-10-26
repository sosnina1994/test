package com.sosninanv.calculationsystem.dtos.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@Schema(description = "Запрос создания платежа")
public class CreatePaymentRequest {

    @Schema(description = "Номер счета")
    @NotBlank(message = "")
    private String accountNumber;

    @Schema(description = "Сумма платежа")
    @NotNull(message = "")
    @Pattern(regexp = "^\\d+(?:[\\.,]\\d+)?$", message = "")
    private Float sum;

    @Schema(description = "Дата оформления платежа")
    @NotNull(message = "")
    private OffsetDateTime paymentDate;
}
