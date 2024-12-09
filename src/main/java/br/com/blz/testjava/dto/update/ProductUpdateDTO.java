package br.com.blz.testjava.dto.update;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDTO(
    @NotBlank
    String name,

    @Valid
    @NotNull
    InventoryUpdateDTO inventory
) {
}
