package br.com.blz.testjava.dto.save;

import br.com.blz.testjava.enums.TYPE;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WarehouseSaveDTO(
    @NotBlank
    String locality,

    @NotNull
    Long quantity,

    @NotNull
    TYPE type
) {
}
