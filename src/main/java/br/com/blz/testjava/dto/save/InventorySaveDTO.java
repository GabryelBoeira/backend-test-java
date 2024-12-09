package br.com.blz.testjava.dto.save;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record InventorySaveDTO(

    @Valid
    @NotNull
    List<WarehouseSaveDTO> warehouses
) {
}
