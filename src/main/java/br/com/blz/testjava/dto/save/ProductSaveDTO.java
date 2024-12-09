package br.com.blz.testjava.dto.save;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductSaveDTO(
    @NotNull
    Long sku,

    @NotBlank
    String name,

    @Valid
    @NotNull
    InventorySaveDTO inventory
) {
}
